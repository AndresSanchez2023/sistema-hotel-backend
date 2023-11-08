package com.sistema.hotel.servicios.impl;

import com.sistema.hotel.entidades.Usuario;
import com.sistema.hotel.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired(required = true)
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if(usuario==null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        Usuario usuario1 = usuario;
        return usuario1;
    }
}
