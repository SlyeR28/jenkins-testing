package com.example.website.controller;

import com.example.website.dto.ContactFormDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {

    @GetMapping("/javawebapp")
    public String home(Model model) {
        model.addAttribute("pageTitle", "Aetheria - NextGen Digital Solutions");
        model.addAttribute("activePage", "home");
        return "home";
    }

    @GetMapping("/javawebapp/about")
    public String about(Model model) {
        model.addAttribute("pageTitle", "About Us - Aetheria");
        model.addAttribute("activePage", "about");
        return "about";
    }

    @GetMapping("/javawebapp/services")
    public String services(Model model) {
        model.addAttribute("pageTitle", "Our Services - Aetheria");
        model.addAttribute("activePage", "services");
        return "services";
    }

    @GetMapping("/javawebapp/contact")
    public String contact(Model model) {
        model.addAttribute("pageTitle", "Contact Us - Aetheria");
        model.addAttribute("activePage", "contact");
        if (!model.containsAttribute("contactForm")) {
            model.addAttribute("contactForm", new ContactFormDto());
        }
        return "contact";
    }

    @PostMapping("/javawebapp/contact")
    public String handleContactSubmit(@ModelAttribute ContactFormDto contactForm, RedirectAttributes redirectAttributes) {
        String displayName = (contactForm.getName() != null && !contactForm.getName().isBlank()) 
                ? contactForm.getName() : "Valued Guest";
        
        redirectAttributes.addFlashAttribute("successMessage", 
                "Thank you, " + displayName + "! Your inquiry has been dispatched successfully. Our engineering team will get back to you within 24 hours.");
        return "redirect:/contact";
    }
}
