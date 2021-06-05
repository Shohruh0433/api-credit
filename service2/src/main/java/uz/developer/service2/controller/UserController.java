package uz.developer.service2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;
import uz.developer.service2.model.User;

import uz.developer.service2.service.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/create-user")
    public ResponseEntity<?> create(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/get-users")
    public ResponseEntity<?> getUsers() {
        return userService.getUsers();
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        return userService.delete(id);
    }


}
