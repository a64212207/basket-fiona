package com.fchen.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Fiona on 2018/6/7.
 */
@Entity
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    private Integer num;//序号
    private String school;
    private String classb;
    private String name;
    private Integer sex;
    private String sexname;//性别
    private String phone;
    private String wechatno;
    private String height;
    private String weight;
    private Integer choosetime;
    private String choosetimestr;
    private Date createtime;
    private String createtimestr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getClassb() {
        return classb;
    }

    public void setClassb(String classb) {
        this.classb = classb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWechatno() {
        return wechatno;
    }

    public void setWechatno(String wechatno) {
        this.wechatno = wechatno;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getChoosetime() {
        return choosetime;
    }

    public void setChoosetime(Integer choosetime) {
        this.choosetime = choosetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreatetimestr() {
        return createtimestr;
    }

    public void setCreatetimestr(String createtimestr) {
        this.createtimestr = createtimestr;
    }

    public String getSexname() {
        return sexname;
    }

    public void setSexname(String sexname) {
        this.sexname = sexname;
    }

    public String getChoosetimestr() {
        return choosetimestr;
    }

    public void setChoosetimestr(String choosetimestr) {
        this.choosetimestr = choosetimestr;
    }
}
