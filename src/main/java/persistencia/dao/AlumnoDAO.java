package persistencia.dao;

import java.util.List;

import persistencia.dto.AlumnoDTO;

public interface AlumnoDAO {
    
    public void crear (AlumnoDTO alumno);
    public void actualizar (AlumnoDTO alumno);
    public void eliminar (AlumnoDTO alumno);
    public AlumnoDTO buscar (AlumnoDTO nombre);
    public List<AlumnoDTO> buscar();
}
