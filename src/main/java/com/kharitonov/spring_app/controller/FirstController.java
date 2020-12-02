package com.kharitonov.spring_app.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        model.addAttribute("message", "Hi, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a") String a,
                                 @RequestParam(value = "b") String b,
                                 @RequestParam(value = "action", required = true) String action,
                                 Model model) {
        double first = Integer.parseInt(a);
        double second = Integer.parseInt(b);
        double result;
        switch (action) {
            case "mult":
                result = first * second;
                break;
            case "div":
                result = first / second;
                break;
            case "add":
                result = first + second;
                break;
            case "sub":
                result = first - second;
                break;
            default: result = 0;
        }
        model.addAttribute("message", result);
        return "first/calculator";
    }
}
