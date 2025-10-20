
package co.edu.poli.notesApp.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.util.Properties;


public class ConexionBD {
    
    
    // Instancia única del Singleton
    private static ConexionBD instance;    
    private static String URL;
    private static String USER;
    private static String PASSWORD;
    
    static {
        Properties props = new Properties();
        try  {
            props.load(ConexionBD.class.getClassLoader().getResourceAsStream("application.properties"));
                       
            URL = props.getProperty("spring.datasource.url");
            USER = System.getenv("userPostgres");
            PASSWORD = System.getenv("passwordPostgres");
            
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Constructor privado (patrón Singleton)
    private ConexionBD() {
        try {
            Class.forName("org.postgresql.Driver"); // carga driver una sola vez
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se encontró el driver PostgreSQL", e);
        }
    }

    // Método para obtener la instancia única
    public static synchronized ConexionBD getInstance() {
        if (instance == null) {
            instance = new ConexionBD();
        }
        return instance;
    }

    // 👉 Devuelve una conexión NUEVA cada vez que se llama
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}
