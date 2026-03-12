package com.senai.aprendendoJPA.service;

import com.senai.aprendendoJPA.model.Usuario;
import com.senai.aprendendoJPA.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodosUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorId(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não existe!"));
    }

    public Usuario atualizarUsuarioPorID(Long id, Usuario usuario){
        Usuario usuarioSalvo = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não existe!"));

        usuarioSalvo.setNome(usuario.getNome());

        return usuarioRepository.save(usuarioSalvo);
    }

    public void deletarUsuarioPorId(Long id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        }
        throw new RuntimeException("Usuário não existe!");
    }
}
