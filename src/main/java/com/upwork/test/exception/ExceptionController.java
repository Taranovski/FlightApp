package com.upwork.test.exception;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

/**
 * Created by Titan on 18.04.2017.
 */

@RestController
public class ExceptionController {

    @RequestMapping(ExceptionConstants.MAPPING_NAME)
    public String getErrorInfo(ModelAndView modelAndView) {
        Object object = modelAndView.getModel().get(ExceptionConstants.EXCEPTION_OBJECT_NAME);

        Exception exception = (Exception) object;

        return Arrays.toString(exception.getStackTrace());
    }
}
