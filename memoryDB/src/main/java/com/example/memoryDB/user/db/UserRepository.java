package com.example.memoryDB.user.db;

import com.example.memoryDB.db.SimpleDataRepository;
import com.example.memoryDB.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public List<UserEntity> findAllByScoreGreaterThanEqual(int score);

    List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);


}
