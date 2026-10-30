package com.tenant.tenantDemo.Controller;

import com.tenant.tenantDemo.Exception.RecordNotFoundException;
import com.tenant.tenantDemo.Entity.User;
import com.tenant.tenantDemo.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/deleteUser/{username}")
    public void deleteUser(@PathVariable("username") String userName) throws RecordNotFoundException {
        userService.deleteUser(userName);
    }

    @PutMapping("/updateEmailId")
    public void updateEmailId(@RequestBody User user) throws RecordNotFoundException {
        userService.updateEmailId(user);
    }

    @PutMapping("/updatePassword")
    public void updatePassword(@RequestBody User user) throws RecordNotFoundException {
        userService.updatePassword(user);
    }

    @GetMapping("/Users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/getUser/{userid}")
    public User getUser(@PathVariable int userid) throws RecordNotFoundException {
        return userService.findUserId(userid);
    }

}
