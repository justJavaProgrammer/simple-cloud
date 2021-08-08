package org.odeyalo.simplecloud.registration;

import org.odeyalo.simplecloud.dao.UserRepository;
import org.odeyalo.simplecloud.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;

@Service
public class RegistrationService {

    private UserRepository repository;

    @Autowired
    public RegistrationService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void add(@RequestParam("email") String email, @RequestParam("password") String password) {
        User user = new User();
        if(email != null && password != null) {
            user.setEmail(email);
            user.setPassword(password);
            repository.save(user);
        }
    }
}
