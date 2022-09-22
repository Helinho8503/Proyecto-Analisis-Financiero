package utp.checkeasy.servicios;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import utp.checkeasy.modelo.Transaccion;

public class TransaccionServicio {
    
    // ATRIBUTOS
  private SessionFactory factory;

  public TransaccionServicio() {
    factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(Transaccion.class)
        .buildSessionFactory();
  }

  public List<Transaccion> obtenerTransaccionesXTipo(String tipo) {
    List<Transaccion> transacciones = new ArrayList<Transaccion>();
    Session session = factory.openSession();
    session.beginTransaction();
    try {
      transacciones = session.createQuery("from Transaccion where tipo = :n", Transaccion.class)
      .setParameter("n", tipo).list();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return transacciones;
  }

  public Transaccion obtenerTransaccion(int id) {
    Transaccion transaccion = new Transaccion();
    Session session = factory.openSession();
    session.beginTransaction();
    try {
        transaccion = session.find(Transaccion.class, id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    session.close();
    return transaccion;
  }

  public String crearTransaccion(Transaccion transaccion) {
    String message = "";
    Session session = factory.openSession();
    session.beginTransaction();
    try {
      session.persist(transaccion);
      session.getTransaction().commit();
      message = "Transacción creada con éxito";
    } catch (Exception e) {
      e.printStackTrace();
      message = e.getMessage();
    }
    session.close();
    return message;
  }

  public String actualizarTransaccion(Transaccion transaccion) {
    String message = "";
    Session session = factory.openSession();
    session.beginTransaction();
    try {
      session.merge(transaccion);
      session.getTransaction().commit();
      message = "Transaccion actualizada con éxito";
    } catch (Exception e) {
      e.printStackTrace();
      message = e.getMessage();
    }
    session.close();
    return message;
  }

  public String borrarTransaccion(int id) {
    String message = "";
    Session session = factory.openSession();
    session.beginTransaction();
    try {
      Transaccion transaccion = obtenerTransaccion(id);
      session.remove(transaccion);
      session.getTransaction().commit();
      session.close();
      message = "Transacción eliminada con éxito";
    } catch (Exception e) {
      message = e.getMessage();
    }
    return message;
  }

}
