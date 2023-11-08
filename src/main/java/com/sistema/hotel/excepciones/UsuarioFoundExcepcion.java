package com.sistema.hotel.excepciones;

public class UsuarioFoundExcepcion extends Exception{

    public UsuarioFoundExcepcion(){
        super("El usuario con ese username ya existe en la base de datos, intente con otro username");
    }

    public UsuarioFoundExcepcion(String mensaje){
        super(mensaje);
    }
}
