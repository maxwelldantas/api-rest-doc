package com.github.maxwelldantas.apirestdoc.controller;

import com.github.maxwelldantas.apirestdoc.model.Usuario;
import com.github.maxwelldantas.apirestdoc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/{username}")
    public Usuario getOneUser(@PathVariable("username") String username) {
        return repository.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postUser(@RequestBody Usuario usuario) {
        repository.save(usuario);
    }

    @PutMapping
    public void putUser(@RequestBody Usuario usuario) {
        repository.save(usuario);
    }
}
