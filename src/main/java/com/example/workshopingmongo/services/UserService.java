package com.example.workshopingmongo.services;

import com.example.workshopingmongo.dto.UserDto;
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

    public User insert(User obj){
        return userRepository.insert(obj);
    }

    public User fromDto(UserDto obj){
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }

    public void delete(String id){
        userRepository.findById(id);
        userRepository.deleteById(id);
    }

    public void update(User obj){
        User newObj = userRepository.findById(obj.getId())
                .orElseThrow(() -> new ObjectNotFoundExcepion("Objeto não encontrado. ID: " + obj.getId()));

        updateData(newObj, obj);
        userRepository.save(newObj);
    }

    public void updateData(User newObj, User obj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }
}
