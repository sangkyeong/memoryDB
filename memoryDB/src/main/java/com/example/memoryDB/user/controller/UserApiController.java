package com.example.memoryDB.user.controller;

import com.example.memoryDB.user.db.UserRepository;
import com.example.memoryDB.user.model.UserEntity;
import com.example.memoryDB.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;
    @PutMapping("")
    public UserEntity create(
            @RequestBody UserEntity entity
        ){
        return userService.save(entity);

    }

    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    //delete
    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable Long id){
        //userService.delete(id);
    }


    // findby id->path variable(하나씩 select)
    @GetMapping("/find/{id}")
    public UserEntity findById(
            @PathVariable Long id
    ){
      return userService.findByid(id).get();
    }

    //10명이상일때 70점이상인 사용자 정보 출력
    @GetMapping("/score")
    public List<UserEntity> filterScore(
            @RequestParam(name = "score") int score
    ){
        return userService.filterScore(score);
    }

    @GetMapping("/min_max")
    public List<UserEntity> filterScore(
            @RequestParam(name = "min") int min,
            @RequestParam(name = "max") int max
    ){
        return userService.filterScore(min, max);
    }

}
