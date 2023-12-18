package com.example.memoryDB.Book.db.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "book")
public class BookEntity{

    @Id //primary key이기 때문에 Id지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //db에 위임하도록 지정
    private Long id;
    private String name;
    private String category;
    private BigDecimal amount;
}
