package utp.checkeasy.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import utp.checkeasy.modelo.Usuario;
import utp.checkeasy.servicios.UsuarioServicio;



@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    private UsuarioServicio servicio;

    public UsuarioControlador() {
      servicio = new UsuarioServicio();
    }
  
    @GetMapping
    @CrossOrigin("*")
    public List<Usuario> obtenerUsuarios() {
      return servicio.obtenerUsuarios();
    }
  
    @GetMapping("/{id}")
    @CrossOrigin("*")
    public Usuario obtenerUsuario(@PathVariable(name = "id") int id) {
      return servicio.obtenerUsuario(id);
    }
  
  
    @PostMapping
    @CrossOrigin("*")
    public String crearUsuario(@RequestBody Usuario usuario) {
      return servicio.crearUsuario(usuario);
    }
  
    @PutMapping
    @CrossOrigin("*")
    public String actualizarUsuario(@RequestBody Usuario usuario) {
      return servicio.actualizarUsuario(usuario);
    }
  
    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public String borrarUsuario(@PathVariable(name = "id") int id) {
      return servicio.borrarUsuario(id);
    }

}
