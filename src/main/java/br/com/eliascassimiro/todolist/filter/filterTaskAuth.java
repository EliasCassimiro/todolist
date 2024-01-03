package br.com.eliascassimiro.todolist.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
public class filterTaskAuth implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        //EXECUTAR ALGUMA AÇÃO
        System.out.println("Chegou no Filtro");
        chain.doFilter(request, response);
            
    }

    
}
