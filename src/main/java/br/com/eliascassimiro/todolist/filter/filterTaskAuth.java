package br.com.eliascassimiro.todolist.filter;
 
import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.eliascassimiro.todolist.user.iUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class filterTaskAuth extends OncePerRequestFilter{

    @Autowired
    private iUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        
        var servletPath = request.getServletPath();
        if (servletPath.equals("/tasks/")) {

            //EXECUTAR ALGUMA AÇÃO

            //PEGAR AUTENTICAÇÃO (USUARIO E SENHA)

            var authorization =  request.getHeader("Authorization");

            var authEncoded = authorization.substring("Basic".length()).trim();

            byte[] authDecode = Base64.getDecoder().decode(authEncoded);
        
            var authString = new String(authDecode);
            
            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];

            //VALIDAR USUARIO

            var user = this.userRepository.findByUserName(username);
            if(user == null){
                response.sendError(401);
            } else {
            //VALIDAR SENHA

                var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                if(passwordVerify.verified){
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(401);
                }
                //SEGUE VIAGEM
                //filterChain.doFilter(request, response);
            } 
        } else {
        filterChain.doFilter(request, response);
        }
    } 
}
