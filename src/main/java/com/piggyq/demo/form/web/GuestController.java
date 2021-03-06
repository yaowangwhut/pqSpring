package com.piggyq.demo.form.web;

import javax.validation.Valid;

import com.piggyq.demo.form.dto.GuestForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application form demo page.
 */
@Controller
@SessionAttributes("guestForm")
public class GuestController {

  /**
   * Serve form request
   */
  @RequestMapping(value = "/form", method = RequestMethod.GET)
  public String home(Model model) {
    if(!model.containsAttribute("guestForm")) model.addAttribute("guestForm", new GuestForm());
    return "/demo/form/guestbook";
  }
	
  /**
   * Form post handler
   */
  @RequestMapping(value = "/form", method = RequestMethod.POST)
  public String send(
      @Valid @ModelAttribute("guestForm") GuestForm guestForm,
      BindingResult binding, 
      RedirectAttributes redirectAttributes) {
  
    // Redirect back into form page if errors detected
    if (binding.hasErrors()) {
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.guestForm", binding);
      redirectAttributes.addFlashAttribute("guestForm", guestForm);
      return "redirect:/form";
    }
  
    return "redirect:/form-success";
  }

  /**
   * Result page, simply displays 'message has ben sent'
   */
  @RequestMapping(value = "/form-success", method = RequestMethod.GET)
  public String formResult() {
    return "/demo/form/success";
  }

}
