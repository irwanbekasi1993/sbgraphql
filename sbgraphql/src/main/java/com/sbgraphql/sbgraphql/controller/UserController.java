package com.sbgraphql.sbgraphql.controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.sbgraphql.sbgraphql.model.User;
import com.sbgraphql.sbgraphql.service.UserService;
import com.sbgraphql.sbgraphql.service.UserServiceImpl;

@Controller
public class UserController {
@Autowired
UserServiceImpl userService;

private Boolean flag;

private static Logger logger = LoggerFactory.getLogger(UserController.class);

@MutationMapping
public User createUser(@Argument User user){
        userService.saveUser(user);
    return user;
}

@QueryMapping
public User getUser(@Argument UUID userId){
    logger.info("retrieve user by id");
return userService.getUser(userId);
}

@QueryMapping
public List<User> getAllUsers(){
    logger.info("retrieve all user data");
    return userService.getAllUsers();
}

@MutationMapping
public Boolean updateUser(@Argument User user){
        logger.info("updateing user data");
        flag = userService.updateUser(user);
    return flag;

}

@MutationMapping
public Boolean deleteUser(@Argument UUID userId){
        logger.info("deleting user data");
        flag = userService.deleteUser(userId);
    
    return flag;
}
}
