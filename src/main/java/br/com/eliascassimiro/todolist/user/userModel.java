package br.com.eliascassimiro.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

//Adiciona os getters e setters
@Data
@Entity(name="tbUsers")
public class userModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String userName;
    private String name;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
