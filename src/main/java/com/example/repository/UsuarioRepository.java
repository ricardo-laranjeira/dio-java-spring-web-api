package com.example.repository;

import com.example.handler.CampoObrigatorioException;
import com.example.model.Ususario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    public void save(Ususario usuario){
        if(usuario.getLogin()==null){
            throw new CampoObrigatorioException("login");
        }
        if(usuario.getPassword()==null){
            throw new CampoObrigatorioException("password");
        }

        if(usuario.getId()==null)
            System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        else
            System.out.println("UPDATE - Recebendo o usuário na camada de repositório");

        System.out.println(usuario);
    }
    public void deleteById(Integer id){
        System.out.printf("DELETE/id - Recebendo o id: %d para excluir um usuário%n", id);
        System.out.println(id);
    }
    public List<Ususario> findAll(){
        System.out.println("LIST - Listando os usários do sistema");
        List<Ususario> usuarios = new ArrayList<>();
        usuarios.add(new Ususario("admin","password"));
        usuarios.add(new Ususario("teste","masterpass"));
        return usuarios;
    }
    public Ususario findById(Integer id){
        System.out.printf("FIND/id - Recebendo o id: %d para localizar um usuário%n", id);
        return new Ususario("admin","password");
    }

    public Ususario findByUsername(String username){
        System.out.printf("FIND/username - Recebendo o usernamae: %s para localizar um usuário%n", username);
        return new Ususario("admin","password");
    }
}
