package com.example.demo;

import javax.validation.Valid;
import com.example.demo.database.User;
import com.example.demo.database.UserRepository;
import com.example.demo.healper.ValidationUtil;
import com.example.demo.models.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public @ResponseBody ApiResponse addNewUser(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            return ValidationUtil.getErrorMessage(errors);
        }
        userRepository.save(user);
        return ApiResponse.SetSuccessResponse("Record inserted successfully!");
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
