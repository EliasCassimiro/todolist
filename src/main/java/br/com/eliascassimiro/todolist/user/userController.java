package br.com.eliascassimiro.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

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
    public ResponseEntity create(@RequestBody userModel userModel){
        var user = this.userRepository.findByUserName(userModel.getUserName());

        if (user != null) {
            
            //MENSAGEM DE ERRO
            //STATUS CODE
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe!");
        }

        var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());
        
        userModel.setPassword(passwordHashred);
        
        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
