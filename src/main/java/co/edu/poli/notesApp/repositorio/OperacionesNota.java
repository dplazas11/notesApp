/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.poli.notesApp.repositorio;

import co.edu.poli.notesApp.modelo.Nota;
import co.edu.poli.notesApp.servicio.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperacionesNota implements Operacion<Nota> {

    @Override
    public String insertar(Nota nota) {
        String sql = "INSERT INTO notas (titulo, descripcion, contenido, fecha, usuario_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nota.getTitulo());
            ps.setString(2, nota.getDescripcion());
            ps.setString(3, nota.getContenido());
            ps.setDate(4, Date.valueOf(nota.getFecha()));
            ps.setString(5, nota.getId());

            ps.executeUpdate();
            return "Nota creada correctamente.";

        } catch (SQLException e) {

            return "Error al crear la nota:" + e.getMessage();
        }
    }

    @Override
    public String eliminar(String id) {
        String sql = "DELETE FROM notas WHERE id = ?";
        try (Connection conn = ConexionBD.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.executeUpdate();
            return "Se ha eliminado la nota correctamente";

        } catch (SQLException e) {

            return "Error al eliminar la nota:" + e.getMessage();
        }
    }

    @Override
    public String actualizar(Nota nota) {
        String sql = "UPDATE notas SET titulo = ?, descripcion = ?, contenido = ?, fecha = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nota.getTitulo());
            ps.setString(2, nota.getDescripcion());
            ps.setString(3, nota.getContenido());
            ps.setDate(4, Date.valueOf(nota.getFecha()));
            ps.setString(5, nota.getId());

            ps.executeUpdate();
            return "Se ha actualizado la nota correctamente.";

        } catch (SQLException e) {

            return "Error al actualizar la nota: " + e.getMessage();
        }
    }

    @Override
    public Nota selectId(String notaId) {
        Nota notaBuscada = null;

        String sqlBase = "SELECT * FROM notas WHERE pasaporteid = ?";

        try (Connection conn = ConexionBD.getInstance().getConnection()) {
            // Primero buscamos en la tabla base
            try (PreparedStatement pstmt = conn.prepareStatement(sqlBase)) {
                pstmt.setString(1, notaId);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    String id = rs.getString("notaid");
                    String fecha = rs.getString("fecha");
                    String titulo = rs.getString("titulo");
                    String descripcion = rs.getString("descripcion");
                    String contenido = rs.getString("contenido");

                    notaBuscada = new Nota(id, titulo, descripcion, contenido, fecha);
                    return notaBuscada;

                }
            }
        } catch (SQLException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }

        return notaBuscada;

    }

    @Override
    public ArrayList<Nota> selectAll() {
        String sql = "SELECT * FROM notas ORDER BY fecha DESC";
        ArrayList<Nota> notas = new ArrayList<>();

        try (Connection conn = ConexionBD.getInstance().getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String Notasid = rs.getString("notasid");
                String fecha_creacion = rs.getString("fecha_creacion");
                String titulo = rs.getString("titular");
                String descripcion = rs.getString("pais");
                String contenido = rs.getString("mision");

                Nota nota_creada = new Nota(Notasid, titulo, descripcion, contenido, fecha_creacion);

                notas.add(nota_creada);

            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }

        return notas;

    }
}
