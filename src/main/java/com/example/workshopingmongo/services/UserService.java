package com.example.workshopingmongo.services;

import com.example.workshopingmongo.repository.UserRepository;
import com.example.workshopingmongo.services.execption.ObjectNotFoundExcepion;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundExcepion("Objeto não encontrado. ID: " + id));
    }

}
