package br.com.eliascassimiro.todolist.filter;
 
import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class filterTaskAuth extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        
        //EXECUTAR ALGUMA AÇÃO
        /*System.out.println("Chegou no Filtro");
        chain.doFilter(request, response);*/

        //PEGAR AUTENTICAÇÃO (USUARIO E SENHA)

        var authorization =  request.getHeader("Authorization");

        var authEncoded = authorization.substring("Basic".length()).trim();

        byte[] authDecode = Base64.getDecoder().decode(authEncoded);
       
        var authString = new String(authDecode);
        
        String[] credentials = authString.split(":");
        String username = credentials[0];
        String password = credentials[1];

        System.out.println("Authorization");
        System.out.println(username);
        System.out.println(password);

        //VALIDAR USUARIO
        //VALIDAR SENHA
        //SEGUE VIAGEM
        filterChain.doFilter(request, response);
            
    }
    
}
