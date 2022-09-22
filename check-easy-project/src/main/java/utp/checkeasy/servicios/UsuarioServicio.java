package utp.checkeasy.servicios;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import utp.checkeasy.modelo.Usuario;

public class UsuarioServicio {
    
    // ATRIBUTOS
  private SessionFactory factory;

  public UsuarioServicio() {
    factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();
  }

  public List<Usuario> obtenerUsuarios() {
    List<Usuario> usuarios = new ArrayList<Usuario>();
    Session session = factory.openSession();
    session.beginTransaction();
    try {
      usuarios = session.createQuery("from Usuario", Usuario.class).list();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return usuarios;
  }

  public Usuario obtenerUsuario(int id) {
    Usuario usuario = new Usuario();
    Session session = factory.openSession();
    session.beginTransaction();
    try {
      usuario = session.find(Usuario.class, id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    session.close();
    return usuario;
  }

  public String crearUsuario(Usuario usuario) {
    String message = "";
    Session session = factory.openSession();
    session.beginTransaction();
    try {
      session.persist(usuario);
      session.getTransaction().commit();
      message = "Usuario creada con éxito";
    } catch (Exception e) {
      e.printStackTrace();
      message = e.getMessage();
    }
    session.close();
    return message;
  }

  public String actualizarUsuario(Usuario usuario) {
    String message = "";
    Session session = factory.openSession();
    session.beginTransaction();
    try {
      session.merge(usuario);
      session.getTransaction().commit();
      message = "Usuario actualizada con éxito";
    } catch (Exception e) {
      e.printStackTrace();
      message = e.getMessage();
    }
    session.close();
    return message;
  }

  public String borrarUsuario(int id) {
    String message = "";
    Session session = factory.openSession();
    session.beginTransaction();
    try {
      Usuario usuario = obtenerUsuario(id);
      session.remove(usuario);
      session.getTransaction().commit();
      session.close();
      message = "Usuario eliminada con éxito";
    } catch (Exception e) {
      message = e.getMessage();
    }
    return message;
  }
}
