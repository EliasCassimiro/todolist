package br.com.eliascassimiro.todolist.task;

import java.util.List;
import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;

public interface iTaskRepository extends JpaRepository<taskModel, UUID>{
    List<taskModel>findByIdUser(UUID idUser);

}
