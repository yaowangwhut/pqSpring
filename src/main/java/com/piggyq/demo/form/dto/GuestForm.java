package com.piggyq.demo.form.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class GuestForm {
  @NotBlank(message = "Please provide your name")
  private String name;

  @NotBlank(message = "Please provide your email")
  @Email(message = "Invalid email address")
  private String email;

  @Size(min = 10, message = "Please enter at least 10 characters")
  private String message;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
