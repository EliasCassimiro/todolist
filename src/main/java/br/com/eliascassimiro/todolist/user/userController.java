package br.com.eliascassimiro.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * MODIFICADOR
 * PUBLIC
 * PRIVATE
 * PROTECTED
 */
@RestController
@RequestMapping("/users")
public class userController {
    /*
     * STRING (texto)
     * INTEGER (int) NUMEROS INTEIROS
     * DOUGLE (double) NUMEROS 0.0000
     * FLOAT  (float) Numeros 0.000
     * CHAR (caracter)
     * DATE (data)
     * VOID
     */
    /*
     * BODY
    */
    @Autowired
    private iUserRepository userRepository;

    @PostMapping("/")
    public userModel create(@RequestBody userModel userModel){
       var userCreated = this.userRepository.save(userModel);
       return userCreated;
    }
}
