package com.sistema.hotel.servicios.impl;


import com.sistema.hotel.entidades.Usuario;
import com.sistema.hotel.entidades.UsuarioRol;
import com.sistema.hotel.excepciones.UsuarioFoundExcepcion;
import com.sistema.hotel.repositorios.RolRepository;
import com.sistema.hotel.repositorios.UsuarioRepository;
import com.sistema.hotel.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public  Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol>usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if (usuarioLocal!=null) {
            System.out.println("El usuario ya existe");
            throw new UsuarioFoundExcepcion("El usuario ya está presente");
        } else {
            for (UsuarioRol usuarioRol : usuarioRoles) {
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuario = usuarioRepository.save(usuario);
            return usuario;
        }
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long usuarioId) {
        return usuarioRepository.findById(usuarioId).get();
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

}
