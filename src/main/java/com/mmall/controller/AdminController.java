package com.mmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author LBZ
 * @create 2020/5/6 - 16:08
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    //登录成功后跳转
    @RequestMapping("index.page")
    public ModelAndView index() {
        return new ModelAndView("admin");
    }
}
