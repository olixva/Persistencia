package persistencia.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.PropertiesUtilSingleton;
import persistencia.dao.AlumnoDAO;
import persistencia.dto.AlumnoDTO;

public class AlumnoMySqlImpl implements AlumnoDAO {

    @Override
    public void crear(AlumnoDTO alumno) {
        String query = "INSERT INTO ALUMNO () VALUES (?,?);";

        try (
                Connection conn = DriverManager.getConnection(
                        PropertiesUtilSingleton.getInstance().getconnectionString(),
                        PropertiesUtilSingleton.getInstance().getdatabaseUser(),
                        PropertiesUtilSingleton.getInstance().getdatabasePass());
                PreparedStatement preparedStmt = conn.prepareStatement(query)) {

            preparedStmt.setInt(1, alumno.getnre());
            preparedStmt.setInt(2, alumno.getEdad());

            preparedStmt.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(AlumnoDTO alumno) {
        String query = "UPDATE ALUMNO SET edad=? WHERE nre=?;";

        try (
                Connection conn = DriverManager.getConnection(
                        PropertiesUtilSingleton.getInstance().getconnectionString(),
                        PropertiesUtilSingleton.getInstance().getdatabaseUser(),
                        PropertiesUtilSingleton.getInstance().getdatabasePass());
                PreparedStatement preparedStmt = conn.prepareStatement(query)) {

            preparedStmt.setInt(1, alumno.getEdad());
            preparedStmt.setInt(2, alumno.getnre());

            preparedStmt.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(AlumnoDTO alumno) {
        String query = "DELETE FROM ALUMNO WHERE nre=?";
        try (
                Connection conn = DriverManager.getConnection(
                        PropertiesUtilSingleton.getInstance().getconnectionString(),
                        PropertiesUtilSingleton.getInstance().getdatabaseUser(),
                        PropertiesUtilSingleton.getInstance().getdatabasePass());
                PreparedStatement preparedStmt = conn.prepareStatement(query)) {

            preparedStmt.setInt(1, alumno.getnre());

            preparedStmt.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public AlumnoDTO buscar(AlumnoDTO nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public List<AlumnoDTO> buscar() {
        String query = "SELECT * FROM ALUMNO;";
        List<AlumnoDTO> alumnos = new ArrayList<>();

        try (
                Connection conn = DriverManager.getConnection(
                        PropertiesUtilSingleton.getInstance().getconnectionString(),
                        PropertiesUtilSingleton.getInstance().getdatabaseUser(),
                        PropertiesUtilSingleton.getInstance().getdatabasePass());
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                ResultSet rs = preparedStmt.executeQuery()) {

            while (rs.next()) {
                alumnos.add(new AlumnoDTO(rs.getInt("nre"), rs.getInt("edad")));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return alumnos;
    }

}
