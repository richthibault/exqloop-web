package com.exquisiteloop.website.controller;

import com.exquisiteloop.website.model.ContactForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "redirect:/about";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/portfolio")
    public String portfolio() {
        return "portfolio";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContact(@Valid @ModelAttribute ContactForm contactForm,
                                BindingResult result,
                                RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "contact";
        }
        
        // In a real application, you would send an email or save to database here
        redirectAttributes.addFlashAttribute("success", 
            "Thank you for your message! We will get back to you soon.");
        
        return "redirect:/contact";
    }
}
