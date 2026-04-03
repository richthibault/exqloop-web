package com.exquisiteloop.website.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BaseController {

	@Value("${google.analytics.id:}")
	String googleAnalyticsId;

	@Value("${google.recaptcha.key:}")
	String googleRecaptchaKey;

	@ModelAttribute("googleAnalyticsId")
	public String getGoogleAnalyticsId() {
		return googleAnalyticsId;
	}

	@ModelAttribute("googleRecaptchaKey")
	public String getGoogleRecaptchaKey() {
		return googleRecaptchaKey;
	}

}
