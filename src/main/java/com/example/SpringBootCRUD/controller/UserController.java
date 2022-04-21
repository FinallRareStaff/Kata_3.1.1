package com.example.SpringBootCRUD.controller;

import com.example.SpringBootCRUD.model.User;
import com.example.SpringBootCRUD.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "templates/users_table";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "templates/user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "templates/user_new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/templates";
    }

    @GetMapping("/{id}/edit")
    public String createUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "templates/user_edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable("id") long id,
                             @ModelAttribute("user") User user) {
        userService.update(id, user);
        return "redirect:/templates";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/templates";
    }
}
