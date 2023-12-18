package com.example.memoryDB.user.service;

import com.example.memoryDB.user.db.UserRepository;
import com.example.memoryDB.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    public UserEntity save(UserEntity user){
        //save
        return userRepository.save(user);
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public void delete(UserEntity id){
        userRepository.delete(id);
    }

    public Optional<UserEntity> findByid(Long id){

        return userRepository.findById(id);
    }

    public List<UserEntity> filterScore(int score){
        //return null;
        return userRepository.findAllByScoreGreaterThanEqual(score);
        //https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#jpa.query-methods
        //메소드 이름 관련 : queryMethod 사용참고

    }

    //queryMethod말고 직접 지정하는 방법 - 메소드 명 자유롭게 사용가능
    @Query(
            value = "select * from user as u where u.score >= :min AND score <= :max",
            nativeQuery = true
    )
    List<UserEntity> score(
            @Param(value = "min") int min,
            @Param(value = "max") int max
            //@Param(value = "") 쿼리문 변수에 자동 바인딩
    ) {
        return null;
    }

    public List<UserEntity> filterScore(int min, int max){
        return userRepository.findAllByScoreGreaterThanEqualAndScoreLessThanEqual(min, max);
    }

}
