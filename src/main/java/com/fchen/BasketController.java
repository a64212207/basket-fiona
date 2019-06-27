package com.fchen;

import com.fchen.bean.Person;
import com.fchen.repository.BasketRepository;
import com.fchen.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Fiona on 2018/6/7.
 */
@RestController
@RequestMapping("/")
public class BasketController {
    private final Logger log = LoggerFactory.getLogger(BasketController.class);
    ReentrantLock lock = new ReentrantLock();
    @Autowired
    private BasketRepository basketRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView indexForm(Model model) {
        model.addAttribute("person", new Person());
        return new ModelAndView("index");
    }

    @GetMapping("/success")
    public ModelAndView successPage(Model model) {
        return new ModelAndView("success");
    }

    @RequestMapping(value = "/addUser")
    public String formSubmit(@ModelAttribute Person person, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        response.addHeader("Access-Control-Expose-Headers", "x-requested-with,content-type,CA-Token,Client-Flag");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type,CA-Token,Client-Flag,X_Requested_With");
        try {
            lock.tryLock(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Person> retlist = this.basketRepository.findByNameAndPhone(person.getName().trim(), person.getPhone().trim());
        if (retlist != null && retlist.size() > 0) {
            return "fail";
        } else {
            person.setCreatetime(new Date());
            this.basketRepository.save(person);
            lock.unlock();
            return "success";
        }
    }

    /**
     * 获取学生列表
     * 处理 "/listStudents" 的 GET 请求，用来获取用户列表
     * 通过 @RequestParam 传递参数，进一步实现条件查询或者分页查询
     */
    @RequestMapping(value = "/studentList")
    public ModelAndView studentList(Model model, String begintime, String endtime) {
        Date beginDate = null;
        Date endDate = null;
        if (begintime == null || "".equals(begintime)) {
            beginDate = DateUtil.getCurrYearFirst();
            endDate = DateUtil.getCurrYearLast();
        } else {
            beginDate = DateUtil.convertString2Date(begintime, DateUtil.DATE_FORMAT1_1);
            endDate = DateUtil.addDate(DateUtil.convertString2Date(endtime, DateUtil.DATE_FORMAT1_1), 1);
        }
        Sort sort = new Sort(Sort.Direction.DESC, "createtime");
//        List<Person> retlist = basketRepository.findAll();
        log.info("query date:{},{}",beginDate,endDate);
        List<Person> retlist = basketRepository.findByCreatetimeBetween(beginDate, endDate, sort);

        if (!CollectionUtils.isEmpty(retlist)) {
            log.info("student size:{}",retlist.size());
            int count = 0;
            for (Person person : retlist) {
                person.setNum(++count);
                if (person.getSex() != null) {
                    if (person.getSex() == 1) {
                        person.setSexname("男");
                    } else {
                        person.setSexname("女");
                    }
                }
                if (person.getChoosetime() != null) {
                    if (person.getChoosetime() == 1) {
                        person.setChoosetimestr("周一、三、五 16:30-18:00");
                    } else if (person.getChoosetime() == 2) {
                        person.setChoosetimestr("周二、四、六 16:30-18:00");
                    } else if (person.getChoosetime() == 3) {
                        person.setChoosetimestr("周一、三、五 19:00-20:30");
                    } else if (person.getChoosetime() == 4) {
                        person.setChoosetimestr("周二、四、六 19:00-20:30");
                    }
                }
                person.setCreatetimestr(DateUtil.convertDate2String(person.getCreatetime(), DateUtil.DATE_FORMAT));
            }
        }else{
            retlist = Collections.EMPTY_LIST;
        }
        model.addAttribute("stuList", retlist);
        model.addAttribute("begintime", begintime);
        model.addAttribute("endtime", endtime);
        log.info("retlist:{}",retlist.size());
        return new ModelAndView("studentslist");
    }

    @RequestMapping(value = "/delUser/{id}")
    public String delUser(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        basketRepository.deleteById(id);
        response.sendRedirect("studentList");
        return "";
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(Model model) {
        return new ModelAndView("login");
    }
}
