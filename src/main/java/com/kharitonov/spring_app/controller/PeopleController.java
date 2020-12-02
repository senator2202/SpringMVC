package com.kharitonov.spring_app.controller;

import com.kharitonov.spring_app.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDao dao;

    @Autowired
    public PeopleController(PersonDao dao) {
        this.dao = dao;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", dao.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", dao.show(id));
        return "people/show";
    }
}
