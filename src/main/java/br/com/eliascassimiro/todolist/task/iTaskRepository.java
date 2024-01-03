package br.com.eliascassimiro.todolist.task;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface iTaskRepository extends JpaRepository<taskModel, UUID>{
    
}
