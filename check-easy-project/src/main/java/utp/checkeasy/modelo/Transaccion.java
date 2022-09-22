package utp.checkeasy.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "transacciones")
public class Transaccion {
    
    @Id
    private int id_transaccion;
    private int id_usuario;
    private String razon;
    private float monto;
    private String tipo;

    public Transaccion() {
    }

    // CONSTRUCTOR
  public Transaccion(int id_usuario, String razon, float monto, String tipo) {
    this.id_usuario = id_usuario;
    this.razon = razon;
    this.monto = monto;
    this.tipo = tipo;
  }

  @Override
  public String toString() {
    String info = "------------------------------\n";
    info += "Id: " + id_transaccion;
    info += "Id usuario: " + id_usuario;
    info += "\nRazón: " + razon;
    info += "\nMonto: " + monto;
    info += "\nTipo: " + tipo;
    info += "\n------------------------------\n";

    return info;
  }

// CONSULTORES
public int getId_transaccion() {
    return id_transaccion;
}

public int getId_usuario() {
    return id_usuario;
}

public String getRazon() {
    return razon;
}

public float getMonto() {
    return monto;
}

public String getTipo() {
    return tipo;
}

// MODIFICADORES
public void setId_usuario(int id_usuario) {
    this.id_usuario = id_usuario;
}

public void setRazon(String razon) {
    this.razon = razon;
}

public void setMonto(float monto) {
    this.monto = monto;
}

public void setTipo(String tipo) {
    this.tipo = tipo;
}
  
}
