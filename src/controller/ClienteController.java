package controller;

import model.Cliente;
import service.BD;
import service.Leitor;

import java.sql.*;
import java.util.ArrayList;

public class ClienteController {

    public static boolean insertCliente(Cliente c) {
        Connection conexao = BD.connecta();

        if(conexao == null) return false;

        String sql = "INSERT INTO cliente (nome,telefone,email,endereco) VALUES (?,?,?,?)";

        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1,c.getNome());
            statement.setInt(2, c.getTelefone());
            statement.setString(3,c.getEmail());
            statement.setString(3,c.getEndereco());

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

    public static ArrayList<Cliente> getAll(){
        Connection conexao = BD.connecta();

        try {
            Statement statement = conexao.createStatement();

            String sql = "SELECT * FROM cliente";
            ResultSet resultado = statement.executeQuery(sql);

            ArrayList<Cliente> lista = new ArrayList<>();

            while(resultado.next()){
                lista.add(new Cliente(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getInt("telefone"),
                        resultado.getString("email"),
                        resultado.getString("endereco")
                ));
            }
            BD.desconecta(conexao);
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro ao criar um statement.");
            System.out.println(e);
        }
        BD.desconecta(conexao);
        return new ArrayList<Cliente>();
    }

    public static Cliente getPorID(int id){
        Connection conexao = BD.connecta();

        try {
            Statement statement = conexao.createStatement();

            String sql = "SELECT * FROM cliente WHERE id = " + id;
            ResultSet resultado = statement.executeQuery(sql);
            if(resultado.next()){
                Cliente c = new Cliente(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getInt("telefone"),
                        resultado.getString("email"),
                        resultado.getString("endereco")
                );
                BD.desconecta(conexao);
                return c;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao criar um statement.");
            System.out.println(e);
        }
        BD.desconecta(conexao);
        return null;
    }

    public static void imprime(Cliente c){
        System.out.println("Id: "           + c.getId());
        System.out.println("Nome: "         + c.getNome());
        System.out.println("Telefone: "    + c.getTelefone());
        System.out.println("Endereco: "        + c.getEndereco());
    }

    public static String toString(Cliente c){
        String cliente =
                "Id: "              + c.getId()             + "\n" +
                "Nome: "            + c.getNome()           + "\n" +
                "Telefone: "        + c.getTelefone()       + "\n" +
                "E-mail: "          + c.getEmail()          + "\n" +
                "Endereço: "        + c.getEndereco();

        return cliente;
    }

    public static boolean deletePorId(int id){
        System.out.println("Realmente deseja apagar o id: " + id + "?");
        System.out.print("Digite (S) para sim, ou qualquer coisa para não: ");
        if(Leitor.texto().toLowerCase() != "s"){
            return false;
        }

        Connection conexao = BD.connecta();

        if(conexao == null) return false;

        String sql = "DELETE FROM produto WHERE id = ?";

        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1,id);

            statement.execute();
            BD.desconecta(conexao);
            return true;
        } catch (SQLException e) {
            System.out.println("Erro durante a exclusão");
            System.out.println(e);
        }
        BD.desconecta(conexao);
        return false;
    }

    public static boolean updtCliente(Cliente c){
        System.out.println("Realmente deseja atualizar para :");
        System.out.println("Nome: "         + c.getNome());
        System.out.println("Telefone: "     + c.getTelefone());
        System.out.println("E-mail: "       + c.getEmail());
        System.out.println("Endereço: "     + c.getEndereco());
        System.out.print("Digite (S) para sim, ou qualquer coisa para não: ");
        if(Leitor.texto().toLowerCase() != "s"){
            return false;
        }

        Connection conexao = BD.connecta();

        if(conexao == null) return false;

        String sql =    "UPDATE cliente "   +
                        "SET nome = ?, "    +
                        "telefone = ?, "    +
                        "email = ? "        +
                        "endereco = ?"      +
                        "WHERE id = ?";
        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, c.getNome());
            statement.setInt(2,c.getTelefone());
            statement.setString(3,c.getEmail());
            statement.setString(4,c.getEndereco());

            statement.execute();
            BD.desconecta(conexao);
            return true;
        } catch (SQLException e) {
            System.out.println("Erro durante oa atualização");
            System.out.println(e);
        }
        BD.desconecta(conexao);
        return false;
    }
    
}
