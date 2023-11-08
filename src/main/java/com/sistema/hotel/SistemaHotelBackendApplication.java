package com.sistema.hotel;

import com.sistema.hotel.entidades.Rol;
import com.sistema.hotel.entidades.Usuario;
import com.sistema.hotel.entidades.UsuarioRol;
import com.sistema.hotel.excepciones.UsuarioFoundExcepcion;
import com.sistema.hotel.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SistemaHotelBackendApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SistemaHotelBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			/*
			try{
				Usuario usuario = new Usuario();
				usuario.setNombre("Andres");
				usuario.setApellido("Sanchez");
				usuario.setUsername("Andres");
				usuario.setPassword(bCryptPasswordEncoder.encode("12345"));
				usuario.setEmail("A1@gmail.com");
				usuario.setTelefono("3116143784");
				usuario.setDireccion("av 17");
				usuario.setPerfil("foto.png");

				Rol rol = new Rol();
				rol.setRolId(1L);
				rol.setNombre("ADMIN");

				Set<UsuarioRol> usuarioRoles = new HashSet<>();
				UsuarioRol usuarioRol = new UsuarioRol();
				usuarioRol.setRol(rol);
				usuarioRol.setUsuario(usuario);
				usuarioRoles.add(usuarioRol);

				Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);
				System.out.println(usuarioGuardado.getUsername());
			}catch(UsuarioFoundExcepcion excepcion){
				excepcion.printStackTrace();
			}*/
	}
}
