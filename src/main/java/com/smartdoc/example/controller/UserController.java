package com.smartdoc.example.controller;

import com.smartdoc.example.exception.ResourceNotFoundException;
import com.smartdoc.example.model.User;
import com.smartdoc.example.repository.UserRepository;
import com.smartdoc.example.response.ResponseResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;


/**
 * The type User controller.
 *
 * @author yu 2020/12/27.
 */
@RestController
//@RequestMapping("/api/v1")
public class UserController {

    @Resource
    private UserRepository userRepository;

    /**
     * Create user.
     *
     * @param user the user
     * @return the user
     */
    @PostMapping("/api/v1/users")
    public ResponseResult<User> createUser(@Valid @RequestBody User user) {
        userRepository.add(user);
        return ResponseResult.ok();
    }

    /**
     * Get all users list.
     *
     * @return the list
     */
    @GetMapping("/api/v1/users")
    public ResponseResult<List<User>> getAllUsers() {
        return ResponseResult.ok().setResultData(userRepository.getUsers());
    }

    /**
     * Gets users by id.
     *
     * @param userId the user id|1
     * @return the users by id
     */
    @GetMapping("/api/v1/users/{id}")
    public ResponseResult<User> getUsersById(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId).
                orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        return ResponseResult.ok().setResultData(user);
    }


    /**
     * Update user response entity.
     *
     * @param userId      the user id|1
     * @param userDetails the user details
     * @return the response entity
     */
    @PutMapping("/api/v1/users/{id}")
    public ResponseResult<User> updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) {
        User user = userRepository.findById(userId).
                orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        user.setEmail(userDetails.getEmail());
        user.setLastName(userDetails.getLastName());
        user.setFirstName(userDetails.getFirstName());
        userRepository.add(user);
        return ResponseResult.ok().setResultData(user);
    }

    /**
     * Delete user.
     *
     * @param userId the user id|1
     * @return the map
     */
    @DeleteMapping("/api/v1/user/{id}")
    public ResponseResult<Boolean> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId).
                orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        return ResponseResult.ok().setResultData(userRepository.delete(user));
    }
}
