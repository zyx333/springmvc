/*
 * Copyright (c) 2018, TP-Link Co.,Ltd.
 * Author:  zhangyuxiang <zhangyuxiang@tp-link.com.cn>
 * Created: 2018-07-18
 */
package zyx.practise.springmvc.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zyx.practise.springmvc.model.Person;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/mvc")
public class MVCController {
    @RequestMapping("/hello")
    public String hello() {
        return "/index"; // path and name of jsp file.
    }

    // send params in url
    @RequestMapping("/person")
    public String toPerson(String name, double age) {
        System.out.println("name:" + name + ", age:" + age);
        return "index";
    }

    @RequestMapping("personModel")
    public String toPerson(Person person) {
        System.out.println("name:" + person.getName() + ", age:" + person.getAge());
        return "index";
    }

    @RequestMapping("/date")
    public String date(Date date) {
        System.out.println("date:" + date);
        return "index";
    }

    // help to convert String to Date
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    // todo?
    @RequestMapping("/show")
    public String showPerson(Map<String, Object> map) {
        Person p = new Person();
        map.put("p", p);
        p.setAge(20);
        p.setName("jay");
        return "show";
    }

    @RequestMapping("/redirect")
    public String redirect() {
        return "redirect:hello";
    }

    @RequestMapping(value = "/params")
    public String testRequestParam(@RequestParam(value = "id") Integer id, @RequestParam(value = "name",
            required = false) String name) {
        System.out.println(id + " " + name);
        return "index";
    }

}
