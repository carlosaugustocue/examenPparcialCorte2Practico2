package org.nerv.service.impl;

import org.nerv.domain.Barberia;
import org.nerv.repository.BarberiaRepository;
import org.nerv.service.BarberiaService;

import java.util.List;

public class BarberiaServiceImpl implements BarberiaService {
    private BarberiaRepository barberiaRepository;

    public BarberiaServiceImpl(BarberiaRepository barberiaRepository) {
        this.barberiaRepository = barberiaRepository;
    }

    @Override
    public void registrarBarberia(Barberia barberia) {
        barberiaRepository.guardar(barberia);
    }

    @Override
    public Barberia buscarBarberia(Long id) {
        return barberiaRepository.obtenerPorId(id);
    }

    @Override
    public List<Barberia> listarBarberias() {
        return barberiaRepository.obtenerTodos();
    }

    @Override
    public void modificarBarberia(Barberia barberia) {
        barberiaRepository.actualizar(barberia);
    }

    @Override
    public void eliminarBarberia(Long id) {
        barberiaRepository.eliminar(id);
    }
}