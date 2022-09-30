package one.digitalinnovation.cloudparking.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Hidden
public class HelloWord {

    @GetMapping
    public String helloword(){
        return "Olá Mundo. Desafio Quebéc";
    }
}
