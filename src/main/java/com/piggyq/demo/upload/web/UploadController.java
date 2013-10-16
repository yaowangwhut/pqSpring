package com.piggyq.demo.upload.web;

import com.piggyq.demo.upload.dto.UploadForm;
import com.piggyq.demo.upload.utils.FileUploadValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles requests for the application upload demo page.
 */
@Controller
@SessionAttributes("upload")
public class UploadController {
    private static Logger log = LoggerFactory.getLogger(UploadController.class);

    @InitBinder("uploadForm")
    public void initBinder(final WebDataBinder binder) {
        binder.setValidator(new FileUploadValidator());
    }

    /**
     * Serve request
     */
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String uploadDemo(Model model) {
        if (!model.containsAttribute("uploadForm")) model.addAttribute("uploadForm", new UploadForm());
        return "/demo/upload/uploadFile";
    }

    /**
     * Form post handler
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(
            @Valid @ModelAttribute("uploadForm") UploadForm uploadForm,
            BindingResult binding,
            RedirectAttributes redirectAttributes) {

        // Redirect back into upload page if errors detected
        if (binding.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.uploadForm", binding);
            redirectAttributes.addFlashAttribute("uploadForm", uploadForm);
            return "redirect:/upload";
        }

        MultipartFile multipartFile = uploadForm.getFile();

        String fileName = "";

        if (multipartFile != null) {
            fileName = multipartFile.getOriginalFilename();
            //do whatever you want
            log.debug("-0-0-0-0-0-"+fileName);
            String fileType=fileName.substring(fileName.lastIndexOf("."));
            redirectAttributes.addFlashAttribute("filename",fileName);
            redirectAttributes.addFlashAttribute("filetype",fileType);
            if(!".txt".equals(fileType)){
                return "redirect:/upload-success";
            }

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream(),"UTF-8"));
                String line;
                List<String> lines=new ArrayList<String>();
                while ((line = reader.readLine()) != null)
                {
                    lines.add(line);
                }
                reader.close();
                log.debug(lines.toString());
                redirectAttributes.addFlashAttribute("lines",lines);
            } catch (FileNotFoundException e) {
                log.error(e.toString());
            } catch (IOException e) {
                log.error(e.toString());
            }
        }

        return "redirect:/upload-success";
    }

    /**
     * Result page, simply displays 'message has ben sent'
     */
    @RequestMapping(value = "/upload-success", method = RequestMethod.GET)
    public String uploadResult() {
        return "/demo/upload/success";
    }

}
