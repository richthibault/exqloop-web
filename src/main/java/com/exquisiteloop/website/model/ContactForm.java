package com.exquisiteloop.website.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ContactForm {

    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email address")
    private String email;

    @NotBlank(message = "Message is required")
    private String message;

    public ContactForm() {}

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
