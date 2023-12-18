package com.example.memoryDB.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "user")  //`user`라는 테이블과 매칭
public class UserEntity{

    @Id //primary key이기 때문에 Id지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db에 위임하도록 지정
    private Long id;
    private String name;
    private int score;

}
