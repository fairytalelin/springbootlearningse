package com.claylin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by claylin on 2017/5/8.
 */
@Controller
public class BaseController {

    @RequestMapping("/")
    public ModelAndView welcome(){
        return new ModelAndView("index.html");
    }

    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("index.jsp");
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "claylin");
        map.put("age", String.valueOf(12));
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
}
