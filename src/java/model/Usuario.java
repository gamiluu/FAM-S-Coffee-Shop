package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class Usuario {
    
    private int id;
    private String nombre, email, contrasena, tipo;
    

    public Usuario(String nombre, String email, String contrasena) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
    }

    public Usuario(String nombre, String email, String contrasena, String tipo) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    public Usuario(int id, String nombre, String email, String contrasena, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public static String toArrayJSon(ArrayList<Usuario> usuarios) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(usuarios);

        return resp;
    }
    
}

/*
DROP TABLE USUARIOS;

CREATE TABLE USUARIOS(
	ID_USUARIO INT,
	NOMBRE VARCHAR(70),
        EMAIL VARCHAR(100),
        CONTRASENA VARCHAR(50),
	TIPO VARCHAR(20),
        PRIMARY KEY(ID_USUARIO)
);



INSERT INTO USUARIOS(ID_USUARIO, NOMBRE, EMAIL, CONTRASENA, TIPO)
VALUES (1, 'Natalia', 'Natalia', 'Natalia', 'staff');

INSERT INTO USUARIOS(ID_USUARIO, NOMBRE, EMAIL, CONTRASENA, TIPO)
VALUES (2, 'Sonia', 'Sonia', 'Sonia', 'staff');

INSERT INTO USUARIOS(ID_USUARIO, NOMBRE, EMAIL, CONTRASENA, TIPO)
VALUES (3, 'Jorge', 'jalquezar04@gmail.com', 'Jorge123', 'usuario');

*/