package com.api.controller;


import com.business.interfaces.MyStrings;
import com.business.services.AuthenticationService;
import com.data.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(value = "/")
    @ResponseBody
    public String index(){
        return "index";
    }

    @Autowired
    private com.business.interfaces.MyDatabase MyDatabase;

    @Autowired
    private MyStrings myStrings;

    @Autowired
    private AuthenticationService authenticationService;



    @RequestMapping(value = "/index/{login}", method = RequestMethod.GET)
    public String index(Model stringsModel, @PathVariable String login){
        stringsModel.addAttribute("MyStrings", myStrings);
        String prefix = authenticationService.getWebPagePrefix();
        return prefix + "index";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index2(Model stringsModel){
        stringsModel.addAttribute("MyStrings", myStrings);
        String prefix = authenticationService.getWebPagePrefix();
        return prefix + "index";
    }

    @RequestMapping(value = "/lang/{lang}/{page}", method = RequestMethod.GET)
    public String index(Model model ,Model stringsModel, @PathVariable String lang, @PathVariable String page){
        myStrings.setLanguage(lang);
        List<Person> personList =  MyDatabase.personList();
        model.addAttribute("personList", personList);
        model.addAttribute("person", new Person());
        stringsModel.addAttribute("MyStrings", myStrings);
        String prefix = authenticationService.getWebPagePrefix();
        return prefix + page;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String indexPost(Model stringsModel){
        stringsModel.addAttribute("MyStrings", myStrings);
        String prefix = authenticationService.getWebPagePrefix();
        return prefix + "index";
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public String showAll(Model model ,Model stringsModel){
        List<Person> personList =  MyDatabase.personList();
        model.addAttribute("personList", personList);
        stringsModel.addAttribute("MyStrings", myStrings);
        String prefix = authenticationService.getWebPagePrefix();
        return prefix + "showAll";
    }

    @RequestMapping(value = "/searc", method = RequestMethod.GET)
    public String searc(Model model ,Model stringsModel){
        model.addAttribute("person", new Person());
        stringsModel.addAttribute("MyStrings", myStrings);
        String prefix = authenticationService.getWebPagePrefix();
        return prefix + "searc";
    }

    @RequestMapping(value = "/searc", method = RequestMethod.POST)
    public String doSearc(@ModelAttribute Person person, Model model ,Model stringsModel){
        List<Person> personList = MyDatabase.searc(person);
        model.addAttribute("personList", personList);
        stringsModel.addAttribute("MyStrings", myStrings);
        String prefix = authenticationService.getWebPagePrefix();
        return prefix + "searcResult";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model ,Model stringsModel){
        model.addAttribute("person", new Person());
        stringsModel.addAttribute("MyStrings", myStrings);
        String prefix = authenticationService.getWebPagePrefix();
        return prefix + "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String doCreate(@ModelAttribute Person person ,Model stringsModel){
        MyDatabase.save(person);
        stringsModel.addAttribute("MyStrings", myStrings);
        String prefix = authenticationService.getWebPagePrefix();
        return prefix + "checkCreate";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable long id, Model model ,Model stringsModel){
        MyDatabase.delete(id);
        List<Person> personList =  MyDatabase.personList();
        model.addAttribute("personList", personList);
        stringsModel.addAttribute("MyStrings", myStrings);
        String prefix = authenticationService.getWebPagePrefix();
        return prefix + "delete";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model ,Model stringsModel){
        Person oldPerson = MyDatabase.findById(id);
        model.addAttribute("person", oldPerson);
        stringsModel.addAttribute("MyStrings", myStrings);
        String prefix = authenticationService.getWebPagePrefix();
        return prefix + "edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String doEdit(@PathVariable long id,@ModelAttribute Person person ,Model stringsModel, Model model){
        MyDatabase.overWrite(MyDatabase.findById(id),person);
        stringsModel.addAttribute("MyStrings", myStrings);
        model.addAttribute("person", person);
        String prefix = authenticationService.getWebPagePrefix();
        return prefix + "checkEdit";
    }


}
