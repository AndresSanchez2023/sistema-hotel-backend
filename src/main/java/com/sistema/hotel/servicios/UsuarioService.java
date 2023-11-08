package com.sistema.hotel.servicios;

import com.sistema.hotel.entidades.Usuario;
import com.sistema.hotel.entidades.UsuarioRol;



import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception ;

    public Usuario obtenerUsuario(String Username);

    public void eliminarUsuario(Long usuarioId);

}
