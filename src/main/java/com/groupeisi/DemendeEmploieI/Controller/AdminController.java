package com.groupeisi.DemendeEmploieI.Controller;

import com.groupeisi.DemendeEmploieI.exception.ResourceNotFoundException;
import com.groupeisi.DemendeEmploieI.model.UserDtls;
import com.groupeisi.DemendeEmploieI.repository.UserRepository;
import com.groupeisi.DemendeEmploieI.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/")
public class AdminController {
    @Autowired
    private UserServiceImpl userService;
    private UserRepository userRepository;


    // get all employees
    @GetMapping("admin/employees")
    public List<UserDtls> getAllUsers(){
        return userRepository.findAll();
    }

    // create employee rest api
    @PostMapping("/employees")
    public UserDtls createUserDtls(@RequestBody UserDtls userDtls) {
        return userRepository.save(userDtls);
    }

    // get employee by id rest api
    @GetMapping("/employees/{id}")
    public ResponseEntity<UserDtls> getUserDtlsById(@PathVariable int id) {
        UserDtls userDtls= userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
        return ResponseEntity.ok(userDtls);
    }

    // update employee rest api

    @PutMapping("/employees/{id}")
    public ResponseEntity<UserDtls> updateEmployee(@PathVariable int id, @RequestBody UserDtls em){
      UserDtls userDtls = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        userDtls.setFullName(em.getFullName());
        userDtls.setAge(em.getAge());
        userDtls.setEmail(em.getEmail());

        UserDtls updatedEmployee =userRepository.save(userDtls);
        return ResponseEntity.ok(updatedEmployee);
    }

    // delete employee rest api
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int id){
       UserDtls userDtls= userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        userRepository.delete(userDtls);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



}
