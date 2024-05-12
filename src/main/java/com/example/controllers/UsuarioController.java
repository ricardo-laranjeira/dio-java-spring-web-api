package com.example.controllers;

import com.example.model.Ususario;
import com.example.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping()
    public List<Ususario> list(){
        return repository.findAll();
    }

    @GetMapping("/{username}")
    public Ususario find(@PathVariable("username") String username){
        return repository.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

    @PostMapping()
    public void save(@RequestBody Ususario usuario){
        repository.save(usuario);
    }

    @PutMapping()
    public void update(@RequestBody Ususario usuario){
        repository.save(usuario);
    }
}
