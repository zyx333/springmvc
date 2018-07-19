/*
 * Copyright (c) 2018, TP-Link Co.,Ltd.
 * Author:  zhangyuxiang <zhangyuxiang@tp-link.com.cn>
 * Created: 2018-07-19
 */
package zyx.practise.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rest")
public class RestController {
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") Integer id) {
        System.out.println("get " + id);
        return "/index";
    }
}
