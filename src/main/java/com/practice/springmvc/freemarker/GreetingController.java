package com.practice.springmvc.freemarker;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {

    @RequestMapping(path = "/greeting_", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Model greeting_(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
//        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("name", name);
//        modelAndView.setViewName("greeting");
        /*
         *404
         * */
        return model;
    }

    @ResponseBody
    @RequestMapping(path = "/greeting", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Model greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        /*
         * 默认导向RequestMapping.path "/greeting"
         * */
        return model;
    }

    @RequestMapping(path = "/greeting3", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ModelAndView greeting3(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", name);
        modelAndView.setViewName("greeting");
        return modelAndView;
        /*
         * 加 @ResponseBody, 也不会返回json
         * */
    }

    @GetMapping("/greeting2")
    public String greeting2(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }


}
