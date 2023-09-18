package persistencia.dto;

import java.io.Serializable;

public class MatriculaDTO implements Serializable {
    private int idMatricula;
    private int nreEstudiante;
    private String curso;

    public MatriculaDTO(int nreEstudiante, String curso) {
        this.nreEstudiante = nreEstudiante;
        this.curso = curso;
    }

    public MatriculaDTO() {
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public int getNreEstudiante() {
        return nreEstudiante;
    }

    public void setNreEstudiante(int nreEstudiante) {
        this.nreEstudiante = nreEstudiante;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "MatriculaDTO [idMatricula=" + idMatricula + ", nreEstudiante=" + nreEstudiante + ", curso=" + curso
                + "]";
    }
}
