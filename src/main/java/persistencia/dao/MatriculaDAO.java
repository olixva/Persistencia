package persistencia.dao;

import java.util.List;

import persistencia.dto.MatriculaDTO;

public interface MatriculaDAO {
    
    public void crear (MatriculaDTO matricula);
    public void actualizar (MatriculaDTO matricula);
    public void eliminar (MatriculaDTO matricula);
    public MatriculaDTO buscar (int idMatricula);
    public List<MatriculaDTO> buscarAll (int nre);
}
