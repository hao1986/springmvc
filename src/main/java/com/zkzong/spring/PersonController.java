package com.zkzong.spring;

import com.zkzong.spring.model.Person;
import com.zkzong.spring.service.PersonService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zong on 2017/3/2.
 */
@Controller
public class PersonController {
    private PersonService personService;

    @Autowired(required = true)
    @Qualifier(value = "personService")
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        List<Person> persons = personService.listPersons();
        System.out.println("persons = " + persons.size());
        model.addAttribute("listPersons", persons);
        return "person";
    }

    @RequestMapping(value = "/person/add", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p) {
    	System.out.println("id = " + p.toString());
        //if (p.getId() == 0) {
    	if(p.getId() == null){
            personService.addPerson(p);
        } else {
            personService.updatePerson(p);
        }
        return "redirect:/persons";
    }

    @RequestMapping(value = "remove/{id}")
    public String removePerson(@PathVariable("id") int id) {
        personService.removePerson(id);
        return "redirect:/persons";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personService.getPersonById(id));
        model.addAttribute("listPersons", personService.listPersons());
        return "person";
    }
}
