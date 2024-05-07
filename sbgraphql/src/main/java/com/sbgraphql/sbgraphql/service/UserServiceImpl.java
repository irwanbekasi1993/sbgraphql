package com.sbgraphql.sbgraphql.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.execution.*;
import org.springframework.stereotype.Service;

import com.sbgraphql.sbgraphql.exception.CustomException;
import com.sbgraphql.sbgraphql.model.User;
import com.sbgraphql.sbgraphql.repository.UserRepository;

import graphql.GraphqlErrorBuilder;

@Service
public class UserServiceImpl implements UserService{

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    boolean flag;

    @SchemaMapping
    @Override
    public User saveUser(User user) {
        // TODO Auto-generated method stub
        flag = userRepository.findByUsername(user.getUsername()).isPresent();
        if(!flag && user.getUsername()!=null){
            logger.info("saving user");
            userRepository.save(user);
        }
        if(flag){
            throw new CustomException("data user already exists");
        }
        
        return user;
    }

    @SchemaMapping
    @Override
    public Boolean updateUser(User user) {
        // TODO Auto-generated method stub
        Optional<User> cekUser = userRepository.findById(user.getId());
        flag = Optional.of(cekUser).isPresent(); 
        if(flag){
            logger.info("updating user");
            userRepository.save(user);
        }else{
            throw new RuntimeException("data user not found");
        }
        return flag;
    }

    @SchemaMapping
    @Override
    public Boolean deleteUser(UUID userId) {
        // TODO Auto-generated method stub
        Optional<User> cekUser = userRepository.findById(userId);
        flag = Optional.of(cekUser).isPresent();
        if(flag){
            logger.info("deleting user");
            userRepository.deleteById(userId);
        }else{
            throw new RuntimeException("data user not found");
        }
        return flag;
    }

    @SchemaMapping
    @Override
    public User getUser(UUID userId) {
        // TODO Auto-generated method stub
        Optional<User> cekUser = userRepository.findById(userId);
        logger.info("retreive user data");
        return Optional.of(cekUser).get().get();
    }

    @SchemaMapping
    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        logger.info("retrieve all user data");
        return userRepository.findAll();
    }

}
