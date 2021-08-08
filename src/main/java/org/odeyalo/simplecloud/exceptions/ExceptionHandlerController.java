package org.odeyalo.simplecloud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
   // @ExceptionHandler(UserNotFoundException.class)
    public ModelAndView handleUserNotFoundException() {
        return new ModelAndView("errors/404Error");
    }
}
