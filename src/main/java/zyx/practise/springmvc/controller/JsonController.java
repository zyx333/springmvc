/*
 * Copyright (c) 2018, TP-Link Co.,Ltd.
 * Author:  zhangyuxiang <zhangyuxiang@tp-link.com.cn>
 * Created: 2018-07-19
 */
package zyx.practise.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import zyx.practise.springmvc.model.Person;

@Controller
@RequestMapping("/json")
public class JsonController {
    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String get() {
        Person person = new Person();
        person.setName("jar");
        person.setAge(12);
        System.out.println("person out");
        return person.toString();
    }

//    @ResponseBody
//    @RequestMapping(value = "/user2")
//    public Person get2() {
//        Person person = new Person();
//        person.setName("jar");
//        person.setAge(12);
//        System.out.println("person out");
//        return person;
//    }
}
