package com.upwork.test.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Titan on 18.04.2017.
 */
//@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {

        ModelAndView model = new ModelAndView(ExceptionConstants.MAPPING_NAME);
        model.addObject(ExceptionConstants.EXCEPTION_OBJECT_NAME, ex);

        return model;
    }

}