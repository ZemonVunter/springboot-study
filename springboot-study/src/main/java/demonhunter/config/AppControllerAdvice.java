package demonhunter.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



    @ControllerAdvice
    public class AppControllerAdvice {
        @ExceptionHandler(Exception.class)
        @ResponseBody
        public Object handle(Exception e){
            e.printStackTrace();
            return null;
        }
    }

