package com.teste.demo.service;

import com.teste.demo.User;
import com.teste.demo.UserRepository;

public interface UserService{

    public String username(String name);

    public Iterable<User> getallusernames();

    public String deleteusername(int id);

    public String updateusername(int id, String name);


}
