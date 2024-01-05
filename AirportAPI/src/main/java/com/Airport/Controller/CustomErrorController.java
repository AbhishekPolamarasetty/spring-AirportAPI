package com.Airport.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
public class CustomErrorController {

    @RequestMapping("/customerror")
    @ResponseBody
    public ResponseEntity<String> handle404Error() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Custom 404 - Page Not Found");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleNoHandlerFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Custom 404 - Page Not Found");
    }
}


