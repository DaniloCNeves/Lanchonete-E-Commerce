package controller;

import model.Venda;
import service.BD;

import java.sql.*;
import java.util.ArrayList;

public class VendaController {

    public static boolean insertVenda(Venda v) {
        Connection conexao = BD.connecta();

        if(conexao == null) return false;

        String sql = "INSERT INTO venda (idCliente,entrega) VALUES (?,?)";

        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1,v.getIdCliente());
//            statement.setDate(2,new Date(v.getDataVenda().getTime()));
            statement.setBoolean(2,v.isEntrega());

            statement.execute();
            BD.desconecta(conexao);
            return true;
        } catch (SQLException e) {
            System.out.println("Erro durante o cadastro");
            System.out.println(e);
        }
        BD.desconecta(conexao);
        return false;
    }

    public static ArrayList<Venda> getAll(){
        Connection conexao = BD.connecta();

        try {
            Statement statement = conexao.createStatement();

            String sql = "SELECT venda.id           AS venda" +
                                "venda.idCliente    AS idCliente" +
                                "cliente.nome       AS nomeCliente" +
                                "venda.dataVenda    AS davaVenda" +
                                "venda.entrega      AS entrega" +
                        " FROM venda INNER JOIN cliente " +
                        " ON venda.idCliente";
            ResultSet resultado = statement.executeQuery(sql);

            ArrayList<Venda> lista = new ArrayList<Venda>();

            while(resultado.next()){
                lista.add(new Venda(
                        resultado.getInt("id"),
                        resultado.getInt("idCliente"),
                        resultado.getDate("dataVenda"),
                        resultado.getBoolean("entrega")
                ));
            }
            BD.desconecta(conexao);
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro ao criar um statement.");
            System.out.println(e);
        }
        BD.desconecta(conexao);
        return new ArrayList<Venda>();
    }

    public static Venda getPorID(int id){
        Connection conexao = BD.connecta();

        try {
            Statement statement = conexao.createStatement();

            String sql = "SELECT * FROM venda WHERE id = " + id;
            ResultSet resultado = statement.executeQuery(sql);
            if(resultado.next()){
                Venda v = new Venda(
                        resultado.getInt("id"),
                        resultado.getInt("idCliente"),
                        resultado.getTime("dataVenda"),
                        resultado.getBoolean("entrega")
                );
                BD.desconecta(conexao);
                return v;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao criar um statement.");
            System.out.println(e);
        }
        BD.desconecta(conexao);
        return null;
    }

    public static int getUltimoID(){
        Connection conexao = BD.connecta();

        try {
            Statement statement = conexao.createStatement();

            String sql = "SELECT MAX(id) as id FROM venda";
            ResultSet resultado = statement.executeQuery(sql);
            if(resultado.next()){
                int id = resultado.getInt("id");
                BD.desconecta(conexao);
                return id;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao criar um statement.");
            System.out.println(e);
        }
        BD.desconecta(conexao);
        return 0;
    }


    public static void imprime(Venda v){
        System.out.println("Venda nº: "         + v.getId());
        System.out.println("Id do Cliente: "    + v.getIdCliente());
        System.out.println("Data da Venda: "    + v.getDataVenda());
        System.out.println("Entrega: "          + v.isEntrega());
    }
}
