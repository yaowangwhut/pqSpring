package com.piggyq.common.web;

import com.piggyq.demo.form.dto.GuestForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: IrisHome
 * Date: 10/16/13
 * Time: 10:17 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {
    /**
     * Home Index
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homeGet(Model model) {
        model.addAttribute("message", "Welcome ~~");
        return "/welcome";
    }

    /**
     * Form post handler
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String homePost(Model model){
        model.addAttribute("message", "Welcome ~~");
        return "/welcome";
    }
}
