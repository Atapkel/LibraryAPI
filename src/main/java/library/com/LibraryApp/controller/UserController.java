package library.com.LibraryApp.controller;

import library.com.LibraryApp.model.User;
import library.com.LibraryApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    public final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAll();
    }
    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.save(user);
    }
}
