package com.jspforms.jakubborkowski.controller;

import com.jspforms.jakubborkowski.model.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {
    @RequestMapping("/contacts")
    public String contact(Model model) {
        model.addAttribute("message", "simple string from form controller");
        Contact newContact = new Contact();
        model.addAttribute("conctact", newContact);
        return "form";
    }

    @RequestMapping(value = "/addContact.html", method = RequestMethod.POST)

    public String addContact(@ModelAttribute("contact") Contact contact) {
        System.out.println(contact.getFirstname() + " " + contact.getLastname() + " " + contact.getEmail() + " " + contact.getTelephone());

        return "redirect:contacts";
    }
}
