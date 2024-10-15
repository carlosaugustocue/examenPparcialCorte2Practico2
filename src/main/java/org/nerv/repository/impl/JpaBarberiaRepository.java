package org.nerv.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.nerv.domain.Barberia;
import org.nerv.repository.BarberiaRepository;

import java.util.List;

public class JpaBarberiaRepository implements BarberiaRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("barberiaPU");

    @Override
    public void guardar(Barberia barberia) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(barberia);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Barberia obtenerPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Barberia barberia = em.find(Barberia.class, id);
        em.close();
        return barberia;
    }

    @Override
    public List<Barberia> obtenerTodos() {
        EntityManager em = emf.createEntityManager();
        List<Barberia> barberias = em.createQuery("from Barberia", Barberia.class).getResultList();
        em.close();
        return barberias;
    }

    @Override
    public void actualizar(Barberia barberia) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(barberia);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Barberia barberia = em.find(Barberia.class, id);
        if (barberia != null) {
            em.remove(barberia);
        }
        em.getTransaction().commit();
        em.close();
    }
}
