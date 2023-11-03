package com.spring.VideoCall.Video.Call.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Service
public class UserService {

    private static final List<User> userList=new ArrayList<>();

    public void register(User user){
        System.out.println(user);
        user.setStatus("online");
        userList.add(user);
    }

    public User login(User user){
        System.out.println(user);
        System.out.println(userList);
        var userIndex= IntStream.range(0,userList.size())
                .filter(i->userList.get(i).getEmail().equals(user.getEmail()))
                .findAny()
                .orElseThrow(()->new RuntimeException("User Not Found!"));
        var connectedUser=userList.get(userIndex);
        System.out.println(connectedUser);
        if(!connectedUser.getPassword().equals(user.getPassword())){
throw new RuntimeException("Password is invalid!");
        }
        connectedUser.setStatus("online");
return connectedUser;
    }

    public void logout(String email){
        var userIndex= IntStream.range(0,userList.size())
                .filter(i->userList.get(i).getEmail().equals(email))
                .findAny()
                .orElseThrow(()->new RuntimeException("User Not Found!"));

        userList.get(userIndex).setStatus("offline");

    }

    public List<User> findAll(){
        return userList;
    }

    public ResponseEntity<String> handle(Exception ex){
        ex.printStackTrace();
        return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }



}
