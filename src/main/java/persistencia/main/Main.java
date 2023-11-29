package persistencia.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

import persistencia.dto.AlumnoDTO;
import persistencia.dto.MatriculaDTO;
import persistencia.impl.AlumnoJPAImpl;
import persistencia.impl.AlumnoMySqlImpl;

public class Main {
    public static void main(String[] args) {

        //AlumnoDTO alumno1 = new AlumnoDTO(1111, 190);
        //AlumnoJPAImpl alumno = new AlumnoJPAImpl();
        //alumno.crear(alumno1);

        // AlumnoDTO alumno2 = new AlumnoDTO(123, 18);
        // AlumnoMySqlImpl alumnoDAO = new AlumnoMySqlImpl();
        // alumnoDAO.crear(alumno1);
        // alumnoDAO.crear(alumno2);

        // for (AlumnoDTO alumno : alumnoDAO.buscar()) {
        //     System.out.println(alumno.toString());
        // }

        // alumnoDAO.eliminar(alumno2);
        // alumno1.setEdad(19);
        // alumnoDAO.actualizar(alumno1);

        // for (AlumnoDTO alumno : alumnoDAO.buscar()) {
        //     System.out.println(alumno.toString());
        // }

        try {
            FileOutputStream fout = new FileOutputStream("prueba.dat");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            
            MatriculaDTO matricula1 = new MatriculaDTO(1, "curso");
            MatriculaDTO matricula2 = new MatriculaDTO(2, "curso2");
            
            out.writeObject(matricula1);
            out.writeObject(matricula2);

            FileInputStream fin = new FileInputStream("prueba");
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    
    
    
    }
}
