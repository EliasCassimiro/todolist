package br.com.eliascassimiro.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface iUserRepository extends JpaRepository<userModel, UUID>{

    
    
}
