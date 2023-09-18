package persistencia.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import persistencia.PropertiesUtilSingleton;
import persistencia.dao.MatriculaDAO;
import persistencia.dto.MatriculaDTO;

public class MatriculaMysqlImpl implements MatriculaDAO {

    @Override
    public void crear(MatriculaDTO matricula) {
        String query = "INSERT INTO MATRICULA () VALUES (?,?);";

        try (
                Connection conn = DriverManager.getConnection(
                        PropertiesUtilSingleton.getInstance().getconnectionString(),
                        PropertiesUtilSingleton.getInstance().getdatabaseUser(),
                        PropertiesUtilSingleton.getInstance().getdatabasePass());
                PreparedStatement preparedStmt = conn.prepareStatement(query)) {

            preparedStmt.setInt(1, matricula.getNreEstudiante());
            preparedStmt.setString(2, matricula.getCurso());

            matricula.setIdMatricula(preparedStmt.executeUpdate());

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(MatriculaDTO matricula) {
        String query = "UPDATE MATRICULA SET CURSO=? WHERE NRE=?;";
        try (
                Connection conn = DriverManager.getConnection(
                        PropertiesUtilSingleton.getInstance().getconnectionString(),
                        PropertiesUtilSingleton.getInstance().getdatabaseUser(),
                        PropertiesUtilSingleton.getInstance().getdatabasePass());
                PreparedStatement preparedStmt = conn.prepareStatement(query)) {

            preparedStmt.setString(1, matricula.getCurso());
            preparedStmt.setInt(2, matricula.getNreEstudiante());

            preparedStmt.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(MatriculaDTO matricula) {
        String query = "DELETE FROM MATRICULA WHERE IDMATRICULA=?;";

        try (
                Connection conn = DriverManager.getConnection(
                        PropertiesUtilSingleton.getInstance().getconnectionString(),
                        PropertiesUtilSingleton.getInstance().getdatabaseUser(),
                        PropertiesUtilSingleton.getInstance().getdatabasePass());
                PreparedStatement preparedStmt = conn.prepareStatement(query)) {

            preparedStmt.setInt(1, matricula.getIdMatricula());

            preparedStmt.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public MatriculaDTO buscar(int idMatricula) {
        String query = "SELECT * FROM MATRICULA WHERE IDMATRICULA=?;";
        MatriculaDTO matricula = new MatriculaDTO();

        try (
                Connection conn = DriverManager.getConnection(
                        PropertiesUtilSingleton.getInstance().getconnectionString(),
                        PropertiesUtilSingleton.getInstance().getdatabaseUser(),
                        PropertiesUtilSingleton.getInstance().getdatabasePass());
                PreparedStatement preparedStmt = conn.prepareStatement(query)) {

            preparedStmt.setInt(1, idMatricula);

            ResultSet rs = preparedStmt.executeQuery();

            matricula.setIdMatricula(rs.getInt("IDMATRICULA"));
            matricula.setNreEstudiante(rs.getInt("NRE"));
            matricula.setCurso(rs.getString("CURSO"));

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return matricula;
    }

    @Override
    public List<MatriculaDTO> buscarAll(int nre) {
        String query = "INSERT INTO MATRICULA () VALUES (?,?);";
        return null;

        // try (
        //         Connection conn = DriverManager.getConnection(
        //                 PropertiesUtilSingleton.getInstance().getconnectionString(),
        //                 PropertiesUtilSingleton.getInstance().getdatabaseUser(),
        //                 PropertiesUtilSingleton.getInstance().getdatabasePass());
        //         PreparedStatement preparedStmt = conn.prepareStatement(query)) {

        //     preparedStmt.setInt(1, matricula.getNreEstudiante());
        //     preparedStmt.setString(2, matricula.getCurso());

        //     matricula.setIdMatricula(preparedStmt.execute());

        // } catch (SQLException e) {

        //     e.printStackTrace();
        // }
    }

}
