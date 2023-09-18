package persistencia.dto;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="alumno", schema="Persistencia")
public class AlumnoDTO {
    
    @Id
    @Basic(optional = false)
    @Column (name = "nre")
    private int nre;
    
    @Column (name = "edad")
    private int edad;
    
    
    public AlumnoDTO(int nre, int edad) {
        this.nre = nre;
        this.edad = edad;
    }
    
    public int getnre() {
        return nre;
    }
    public void setnre(int nre) {
        this.nre = nre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "AlumnoDTO [nre=" + nre + ", edad=" + edad + "]";
    }

    
}
