package com.aamir.resource;

import com.aamir.entity.User;
import com.aamir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @MutationMapping
    public User createUser(@Argument String name, @Argument String email, @Argument String phone, @Argument String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        return userService.createUser(user);
    }
    @QueryMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @QueryMapping
    public User getUserById(@Argument int userId){
        return userService.getUserById(userId);
    }

    @MutationMapping
    public boolean deleteUserById(@Argument int userId){
        return userService.deleteUserById(userId);
    }


}
