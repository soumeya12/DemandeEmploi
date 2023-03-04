package com.groupeisi.DemendeEmploieI.service;



import com.groupeisi.DemendeEmploieI.model.UserDtls;
import com.groupeisi.DemendeEmploieI.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

private UserRepository userRepository;

    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDtls> findAllUsers() {
        List<UserDtls> userDtls = userRepository.findAll();
        return userDtls;
    }


}
