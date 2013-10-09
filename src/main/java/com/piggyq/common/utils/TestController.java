package com.piggyq.common.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created with IntelliJ IDEA.
 * User: IrisHome
 * Date: 10/9/13
 * Time: 10:46 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/*")
public class TestController {
    private static Logger log= Logger.getLogger(TestController.class);
    private static Logger log2 = LogManager.getLogger(TestController.class.getName());
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String welcome(Model model) {
        log.debug("=====================");
        log2.error("--------------------");
        model.addAttribute("message", "Love Iris");
        return "welcome";
    }
}