package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String allUsers(ModelMap model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @RequestMapping("/new")
    public String newUserForm(ModelMap model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", userService.getById(id));
        return "update";
    }

    @PostMapping(value = "/update/{id}")
    public String editUserPost(@PathVariable("id") Long id, User user, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update";
        }
        userService.add(user);
        modelMap.addAttribute("user", userService.listUsers());
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUserForm(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }
}
