package com.groupeisi.DemendeEmploieI.service;


import com.groupeisi.DemendeEmploieI.dto.UserDto;
import com.groupeisi.DemendeEmploieI.model.UserDtls;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface UserService {
    @Autowired
    public UserDtls createUser(UserDtls user);
    public boolean checkEmail(String email);
}
