package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {//DAO - DATA ACCESS OBJECT

    public static Connection connecta(){
        String user = "root";
        String pass = "";
        String url = "jdbc:mysql://localhost:3306/lanchonetedb";
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url,user,pass);

        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao abrir o driver JDBC");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco!");
            System.err.println(e);
        }

        return conn;
    }

    public static void desconecta(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao desconectar do banco");
            System.out.println(e);
        }
    }
}
