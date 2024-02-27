package com.github.maxwelldantas.apirestdoc.repository;

import com.github.maxwelldantas.apirestdoc.handler.CampoObrigatorioException;
import com.github.maxwelldantas.apirestdoc.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    public static final String PASSWORD = "password";

    public void save(Usuario usuario) {
        if (usuario.getLogin() == null) {
            throw new CampoObrigatorioException("login");
        }
        if (usuario.getPassword() == null) {
            throw new CampoObrigatorioException(PASSWORD);
        }

        if (usuario.getId() == null) {
            System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        } else {
            System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
        }

        System.out.println(usuario);
    }

    public void deleteById(Integer id) {
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
        System.out.println(id);
    }

    public List<Usuario> findAll() {
        System.out.println("LIST - Listando os usários do sistema");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("gleyson", PASSWORD));
        usuarios.add(new Usuario("frank", "masterpass"));
        return usuarios;
    }

    public Usuario findById(Integer id) {
        System.out.println(String.format("FIND/id - Recebendo o id: %d para localizar um usuário", id));
        return new Usuario("gleyson", PASSWORD);
    }

    public Usuario findByUsername(String username) {
        System.out.println(String.format("FIND/username - Recebendo o usernamae: %s para localizar um usuário", username));
        return new Usuario("gleyson", PASSWORD);
    }
}
