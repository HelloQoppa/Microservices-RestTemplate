package com.qoppa.userservice.interfaces;

import com.qoppa.userservice.dtos.ResponseDTO;
import com.qoppa.userservice.models.User;

public interface IUser {

    User saveUser(User user);

    ResponseDTO getUser(Long userId);
    
}
