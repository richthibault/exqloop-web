package com.exquisiteloop.website.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exquisiteloop.website.model.ContactForm;
import com.exquisiteloop.website.services.CaptchaService;
import com.exquisiteloop.website.services.EmailService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/contact")
public class ContactController extends BaseController {

	private final EmailService emailService;
	private final CaptchaService captchaService;

	private final static String RECAPTCHA_ACTION = "contact_form_submit";

	public ContactController(EmailService emailService, CaptchaService captchaService) {
		this.emailService = emailService;
		this.captchaService = captchaService;
	}

	@GetMapping
	public String get(ModelMap model) {

		ContactForm contactForm = new ContactForm();
		model.addAttribute("contactForm", contactForm);

		return "contact";
	}

	@PostMapping
    public String submitContact(@Valid @ModelAttribute ContactForm contactForm,
                                BindingResult result, HttpServletRequest request, 
                                RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
            return "contact";
        }

		String captchaResponse = request.getParameter("g-recaptcha-response");
		try {
        	captchaService.validateRecaptchaResponse(captchaResponse, RECAPTCHA_ACTION, request);
		} catch (Exception e) {
			result.reject("captcha.invalid", "Captcha validation failed. Please try again.");
			return "contact";
		}
		
		emailService.submitContactForm(contactForm);

        redirectAttributes.addFlashAttribute("success", 
            "Thank you for your message! We will get back to you soon.");
        
        return "redirect:/contact";
    }


}
