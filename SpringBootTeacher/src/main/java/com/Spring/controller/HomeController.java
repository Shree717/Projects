package com.Spring.controller;

import com.Spring.model.Contact;
import com.Spring.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private ContactService contactService;
    @Autowired
    public HomeController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/html")
    public String html(){
        return "HTML";
    }
    @GetMapping("/css")
    public String css(){
        return "CSS";
    }
    @GetMapping("/javascript")
    public String javaScript(){return "javascript-notes";}
    @GetMapping("/backend")
    public String backend(){
        return "backend-notes";
    }
    @GetMapping("/spring")
    public String spring(){return "spring-notes";}
    @GetMapping("/springBoot")
    public String springBoot(){return "springboot-notes";}
    @GetMapping("/springMVC")
    public String springMVC(){return "springMVC-notes";}
    @GetMapping("/springSecurity")
    public String springSecurity(){return "springSecurity-notes";}
    @GetMapping("/contact")
    public String contactForm(Model model){
        Contact contact = new Contact();
        model.addAttribute("contact",contact);
        return "contact-form";
    }
    @PostMapping("/contact")
    public String sendContactForm(Model model,Contact contact){
        model.addAttribute("contact",contactService.saveContact(contact));
        return "redirect:/";
    }
}
