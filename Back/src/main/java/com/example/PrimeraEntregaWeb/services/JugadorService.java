package com.example.PrimeraEntregaWeb.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PrimeraEntregaWeb.model.Jugador;
import com.example.PrimeraEntregaWeb.model.Producto;
import com.example.PrimeraEntregaWeb.repository.JugadorRepository;
import com.example.PrimeraEntregaWeb.repository.ProductoRepository;

import io.micrometer.common.lang.NonNull;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepositorio;

    @Autowired
    private ProductoRepository productoRepository;

    public List<Jugador> listarJugadores() {
        return jugadorRepositorio.findAll();
    }

    @SuppressWarnings("null")
    public Jugador buscarJugador(@NonNull Long id) {
        return jugadorRepositorio.findById(id).orElseThrow();
    }

    public void actualizarJuagdor(Jugador jugador) {
        Jugador j = jugadorRepositorio.findById(jugador.getId()).orElseThrow();
        j.setRol(jugador.getRol());
        j.setUsuario(jugador.getUsuario());
        j.setContrasena(jugador.getContrasena());

        jugadorRepositorio.save(j);
    }

    public void guardarJugador(Jugador jugador) {
        jugadorRepositorio.save(jugador);
    }

    public void eliminarJugador(Long id) {
        jugadorRepositorio.deleteById(id);
    }

    public void comprarProducto(Long jugadorId, Long productoId, int cantidad) {
        Jugador jugador = jugadorRepositorio.findById(jugadorId)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        double costoTotal = producto.getPrecio() * cantidad;
        if (jugador.getPuntaje() >= costoTotal) {
            jugador.setPuntaje(jugador.getPuntaje() - costoTotal);
            jugadorRepositorio.save(jugador);
        } else {
            throw new RuntimeException("Fondos insuficientes para realizar la compra");
        }
    }

}
