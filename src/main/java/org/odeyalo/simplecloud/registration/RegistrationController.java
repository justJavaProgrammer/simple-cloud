package org.odeyalo.simplecloud.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("simple-cloud/register")
@Controller
public class RegistrationController {

    private RegistrationService service;

    @Autowired
    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "register/register";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String add(@RequestParam("email") String email, @RequestParam("password") String password) {
        service.add(email, password);

        return "UploadFile";
    }
}
