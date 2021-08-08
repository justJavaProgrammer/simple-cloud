package org.odeyalo.simplecloud.dao;

import org.odeyalo.simplecloud.user.User;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmailAndPassword(String email, String password);
}
