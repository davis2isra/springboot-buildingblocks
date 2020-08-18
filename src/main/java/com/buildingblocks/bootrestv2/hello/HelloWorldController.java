package com.buildingblocks.bootrestv2.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET, path = "/helloworld")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/helloworld-bean")
    public UserDetails helloWorldBean() {
        return new UserDetails("Karla", "Rulas", "Monterrey");
    }

    @GetMapping("/hello-int")
    public String getMessagesInI18NFormat(@RequestHeader(name="Accept-Language", required = false) String locale) {
        return messageSource.getMessage("label.hello", null, new Locale(locale));
    }

    @GetMapping("/hello-int2")
    public String getMessagesInI18NFormat2() {
        return messageSource.getMessage("label.hello", null, LocaleContextHolder.getLocale());
    }
}
