package com.sbgraphql.sbgraphql.service;

import java.util.List;
import java.util.UUID;

import com.sbgraphql.sbgraphql.model.User;

public interface UserService {
User saveUser(User user);
Boolean updateUser(User user);
Boolean deleteUser(UUID userId);
User getUser(UUID userId);
List<User>getAllUsers();
}
