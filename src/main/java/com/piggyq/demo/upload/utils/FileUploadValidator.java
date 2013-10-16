package com.piggyq.demo.upload.utils;

import com.piggyq.demo.upload.dto.UploadForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: IrisHome
 * Date: 10/16/13
 * Time: 10:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileUploadValidator implements Validator {
    @Override
    public boolean supports(Class clazz) {
        //just validate the FileUpload instances
        return UploadForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UploadForm file = (UploadForm)target;

        if(file.getFile().getSize()==0){
            errors.rejectValue("file", "required.fileUpload");
        }
    }
}
