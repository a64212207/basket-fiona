package com.fchen.repository;

import com.fchen.bean.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Fiona on 2018/6/8.
 */
public interface BasketRepository extends JpaRepository<Person,Long> {
    List<Person> findByCreatetimeBetween(Date starttime,Date endtime,Sort sort);

    List<Person> findByClassbAndNameAndPhone(String classb,String name,String phone);

}
