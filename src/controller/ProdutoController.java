package controller;

import model.Produto;
import service.BD;
import service.Leitor;

import java.sql.*;
import java.util.ArrayList;

public class ProdutoController {

    public static boolean insertProduto(Produto p) {
        Connection conexao = BD.connecta();

        if(conexao == null) return false;

        String sql = "INSERT INTO produto (nome,descricao,preco) VALUES (?,?,?)";

        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1,p.getNome());
            statement.setString(2, p.getDescricao());
            statement.setDouble(3,p.getPreco());

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

    public static ArrayList<Produto> getAll(){
        Connection conexao = BD.connecta();

        try {
            Statement statement = conexao.createStatement();

            String sql = "SELECT * FROM produto";
            ResultSet resultado = statement.executeQuery(sql);

            ArrayList<Produto> lista = new ArrayList<Produto>();

            while(resultado.next()){
                lista.add(new Produto(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                       resultado.getString("descricao"),
                        resultado.getDouble("preco")
                ));
            }
            BD.desconecta(conexao);
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro ao criar um statement.");
            System.out.println(e);
        }
        BD.desconecta(conexao);
        return new ArrayList<Produto>();
    }

    public static Produto getPorID(int id){
        Connection conexao = BD.connecta();

        try {
            Statement statement = conexao.createStatement();

            String sql = "SELECT * FROM produto WHERE id = " + id;
            ResultSet resultado = statement.executeQuery(sql);
            if(resultado.next()){
                Produto p = new Produto(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("descricao"),
                        resultado.getDouble("preco")
                );
                BD.desconecta(conexao);
                return p;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao criar um statement.");
            System.out.println(e);
        }
        BD.desconecta(conexao);
        return null;
    }

    public static void imprime(Produto p){
        System.out.println("Id: "           + p.getId());
        System.out.println("Nome: "         + p.getNome());
        System.out.println("Descrição: "    + p.getDescricao());
        System.out.println("Preço: "        + p.getPreco());
    }

    public static String toString(Produto p){
        String produto =
                "Id: "              + p.getId()             + "\n" +
                "Nome: "            + p.getNome()           + "\n" +
                "Descrição: "       + p.getDescricao()      + "\n" +
                "Preço: "           + p.getPreco();

        return produto;
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

    public static boolean updtProduto(Produto p){
        System.out.println("Realmente deseja atualizar para :");
        System.out.println("Nome: "         + p.getNome());
        System.out.println("Descrição: "    + p.getDescricao());
        System.out.println("Preço: "        + p.getPreco());
        System.out.print("Digite (S) para sim, ou qualquer coisa para não: ");
        if(Leitor.texto().toLowerCase() != "s"){
            return false;
        }

        Connection conexao = BD.connecta();

        if(conexao == null) return false;

        String sql = "UPDATE produto " +
                "SET nome = ?, " +
                "descricao = ?, " +
                "preco = ? " +
                "WHERE id = ?";
        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, p.getNome());
            statement.setString(2,p.getDescricao());
            statement.setDouble(3,p.getPreco());
            statement.setInt(4,p.getId());

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
