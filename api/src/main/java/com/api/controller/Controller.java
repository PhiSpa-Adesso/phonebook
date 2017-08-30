package com.api.controller;


import com.business.services.CreateService;
import com.business.services.ShowService;
import com.data.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private CreateService createService;

    @Autowired
    private ShowService showService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public String showAll(Model model){
        List<Person> personList =  showService.personList();
        model.addAttribute("personList", personList);
        return "showAll";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("person", new Person());
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String doCreate(@ModelAttribute Person person){
        createService.save(person);
        return "checkCreate";
    }

    @RequestMapping(value = "/searc", method = RequestMethod.GET)
    public String searc(Model model){
        model.addAttribute("person", new Person());
        return "searc";
    }

    @RequestMapping(value = "/searc", method = RequestMethod.POST)
    public String doSearc(@ModelAttribute Person person, Model model){
        List<Person> personList = showService.searc(person);
        model.addAttribute("personList", personList);
        return "searcResult";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, Model model){
        showService.delete(id);
        List<Person> personList =  showService.personList();
        model.addAttribute("personList", personList);
        return "delete";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model){
        Person oldPerson = showService.findById(id);
        model.addAttribute("person", oldPerson);
        return "edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String doEdit(@PathVariable long id,@ModelAttribute Person person){
        createService.overWrite(showService.findById(id),person);
        return "checkEdit";
    }

}
