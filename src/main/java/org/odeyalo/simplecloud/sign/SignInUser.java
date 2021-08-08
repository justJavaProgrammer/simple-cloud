package org.odeyalo.simplecloud.sign;

import org.odeyalo.simplecloud.dao.UserRepository;
import org.odeyalo.simplecloud.exceptions.UserNotFoundException;
import org.odeyalo.simplecloud.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("simple-cloud/sign")
public class SignInUser {
    private UserRepository repository;
    private Logger logger = LoggerFactory.getLogger(SignInUser.class);
    @Autowired
    public SignInUser(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String mainPage() {
        return "sign";
    }

    @PostMapping
    public String sign(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        final User byEmailAndPassword = repository.findByEmailAndPassword(email, password);
        if (byEmailAndPassword != null) {
            logger.info(byEmailAndPassword.getEmail() + " " +
                    byEmailAndPassword.getPassword());
            return "UserCabinet";

        }
        throw new UserNotFoundException();
    }
}
