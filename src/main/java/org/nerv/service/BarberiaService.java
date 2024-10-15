package org.nerv.service;

import org.nerv.domain.Barberia;
import java.util.List;

public interface BarberiaService {
    void registrarBarberia(Barberia barberia);
    Barberia buscarBarberia(Long id);
    List<Barberia> listarBarberias();
    void modificarBarberia(Barberia barberia);
    void eliminarBarberia(Long id);
}