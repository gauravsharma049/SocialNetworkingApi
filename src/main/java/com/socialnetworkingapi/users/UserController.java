package com.socialnetworkingapi.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.socialnetworkingapi.locations.Location;


@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String getAllUser(Model model){

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        System.out.println("user dashboard");
        return "users";
    }
    @GetMapping("/adduser")
    public String add(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") String id){
        return userService.getUser(id);
    }
    @GetMapping("/user/fname/{fname}")
    public List<User> getUserByFname(@PathVariable("fname") String fname){
        return userService.getUserByFirstName(fname);
    }

    @GetMapping("/user/lname/{lname}")
    public List<User> getUserByLname(@PathVariable("lname") String lname){
        return userService.getUserByLastName(lname);
    }

    @PostMapping("/user")
    public String addUser(@ModelAttribute("user") User user, @RequestParam("location_id") String location_id){
        System.out.println(user);
        Location location = new Location();
        location.setId(location_id);
        user.setLocation(location);
        System.out.println(user.getId());
        System.out.println(user.getFname());
        System.out.println(user.getLname());
        System.out.println(user.getLocation());
        userService.addUser(user);
        System.out.println(location_id);
        return  "redirect:/user";
    }

    @PutMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") String id, @RequestBody User user){
        userService.updateUser(id, user);
        return "user updated successfully";
    }

    @RequestMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") String id){
        userService.deleteUser(id);
        return "redirect:/user";
    }
    
}
