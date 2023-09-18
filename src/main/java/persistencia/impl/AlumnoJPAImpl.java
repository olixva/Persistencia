package persistencia.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import persistencia.dao.AlumnoDAO;
import persistencia.dto.AlumnoDTO;

public class AlumnoJPAImpl implements AlumnoDAO{

    @PersistenceContext (unitName = "Persistencia")
    EntityManager em;

    
    public AlumnoJPAImpl() {
        em = Persistence.createEntityManagerFactory("Persistencia").createEntityManager();
    }

    @Override
    public void crear(AlumnoDTO alumno) {
        em.getTransaction().begin();
        try {
            em.persist(alumno);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void actualizar(AlumnoDTO alumno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public void eliminar(AlumnoDTO alumno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public AlumnoDTO buscar(AlumnoDTO nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public List<AlumnoDTO> buscar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }
    
}
