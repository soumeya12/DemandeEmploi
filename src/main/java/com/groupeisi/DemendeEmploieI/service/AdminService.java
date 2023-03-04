package com.groupeisi.DemendeEmploieI.service;

import com.groupeisi.DemendeEmploieI.model.UserDtls;

import java.util.List;

public interface AdminService {
    List<UserDtls> findAllUsers();
}
