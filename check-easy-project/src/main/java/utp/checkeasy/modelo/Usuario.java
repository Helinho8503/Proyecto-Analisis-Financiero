package utp.checkeasy.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "usuarios")
public class Usuario {

    @Id
    private int id;
    private String nombres;
    private String apellidos;
    private String email;
    private String clave;

    public Usuario() {
    }

    // CONSTRUCTOR
  public Usuario(String nombres, String apellidos, String email, String clave) {
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.email = email;
    this.clave = clave;
  }

  @Override
  public String toString() {
    String info = "------------------------------\n";
    info += "Id: " + id;
    info += "\nNombres: " + nombres;
    info += "\nApellidos: " + apellidos;
    info += "\nEmail: " + email;
    info += "\n------------------------------\n";

    return info;
  }

// CONSULTORES
public int getId() {
    return id;
}

public String getNombres() {
    return nombres;
}

public String getApellidos() {
    return apellidos;
}

public String getEmail() {
    return email;
}

public String getClave() {
    return clave;
}

// MODIFICADORES
public void setNombres(String nombres) {
    this.nombres = nombres;
}

public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
}

public void setEmail(String email) {
    this.email = email;
}

public void setClave(String clave) {
    this.clave = clave;
}

 
}
