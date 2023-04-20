package com.teste.demo.service;

import com.teste.demo.User;
import com.teste.demo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRep;

    @Override
    public String username(String name){
        User n = new User();
        n.setName(name);
        userRep.save(n);
        return "Saved";
    }

    @Override
    public Iterable<User> getallusernames(){
        return userRep.findAll();
    }

    @Override
    public String deleteusername(int id){
        userRep.deleteUserById(id);
        return "Deleted";
    }

    @Override
    public String updateusername(int id, String name){
        User n =userRep.findById(id);
        n.setName(name);
        userRep.save(n);
        return "Updated";
    }
}
