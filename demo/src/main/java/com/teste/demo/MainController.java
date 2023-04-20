package com.teste.demo;

import com.teste.demo.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class MainController {

    @Autowired
    private UserRepository userRep;

    @Autowired
    private UserService userSer;


    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name) {

        userSer.username(name);
//        User n = new User();
//        n.setName(name);
//        userRep.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userSer.getallusernames();
//        return userRep.findAll();
    }

    @PostMapping(path="/delete")
    @Transactional
    public @ResponseBody String deleteUser(@RequestParam int id){
        userSer.deleteusername(id);
//        userRep.deleteUserById(id);
        return "Deleted";
    }

    @PostMapping(path="/update")
    public @ResponseBody String updateUser(@RequestParam int id, @RequestParam String name){
        userSer.updateusername(id, name);
//        User n =userRep.findById(id);
//        n.setName(name);
//        userRep.save(n);
        return "Updated";
    }

}