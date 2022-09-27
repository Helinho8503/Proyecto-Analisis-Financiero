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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import utp.checkeasy.modelo.Transaccion;
import utp.checkeasy.servicios.TransaccionServicio;


@RestController
@RequestMapping("/transacciones")
public class TransaccionControlador {
    
    private TransaccionServicio servicio;

    public TransaccionControlador() {
      servicio = new TransaccionServicio();
    }
  
    @GetMapping
    @CrossOrigin("*")
    public List<Transaccion> obtenerUsuarios(@RequestParam int id, String tipo) {
      return servicio.obtenerTransaccionesXTipo(id,tipo);
    }
  
    @GetMapping("/{id}")
    @CrossOrigin("*")
    public Transaccion obtenerTransaccion(@PathVariable(name = "id") int id) {
      return servicio.obtenerTransaccion(id);
    }
  
  
    @PostMapping
    @CrossOrigin("*")
    public String crearTransaccion(@RequestBody Transaccion transaccion) {
      return servicio.crearTransaccion(transaccion);
    }
  
    @PutMapping
    @CrossOrigin("*")
    public String actualizarTransaccion(@RequestBody Transaccion transaccion) {
      return servicio.actualizarTransaccion(transaccion);
    }
  
    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public String borrarTransaccion(@PathVariable(name = "id") int id) {
      return servicio.borrarTransaccion(id);
    }
}
