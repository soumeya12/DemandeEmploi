package com.groupeisi.DemendeEmploieI.Controller;

import com.groupeisi.DemendeEmploieI.model.UserDtls;
import com.groupeisi.DemendeEmploieI.repository.UserRepository;
import com.groupeisi.DemendeEmploieI.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepo;

    @ModelAttribute
    private void userDetails(Model m, Principal p){
        String email= p.getName();
        UserDtls user=userRepo.findByEmail(email);

        m.addAttribute("user",user);
    }

    @GetMapping("/")
    public String home(){
        return "user/home";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m){

        UserDtls e = userService.getUserById(id);

        m.addAttribute("user",e);
        return "edit";
    }


}

