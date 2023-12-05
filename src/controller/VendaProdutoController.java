package controller;

import model.VendaProduto;
import service.BD;

import java.sql.*;
import java.util.ArrayList;

public class VendaProdutoController {

    public static boolean insertVendaProduto(VendaProduto p) {
        Connection conexao = BD.connecta();

        if(conexao == null) return false;

        String sql = "INSERT INTO venda_produto (idVenda, idProduto, precoUnitario, quantidade) VALUES (?,?,?,?)";

        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1,p.getIdVenda());
            statement.setInt(2,p.getIdProduto());
            statement.setFloat(3,p.getPrecoUnitario());
            statement.setFloat(4,p.getQuandidade());

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

    public static ArrayList<VendaProduto> getAll(){
        Connection conexao = BD.connecta();

        try {
            Statement statement = conexao.createStatement();

            String sql = "SELECT * FROM venda_produto";
            ResultSet resultado = statement.executeQuery(sql);

            ArrayList<VendaProduto> lista = new ArrayList<>();

            while(resultado.next()){
                lista.add(new VendaProduto(
                        resultado.getInt("id"),
                        resultado.getInt("idVenda"),
                        resultado.getInt("idProduto"),
                        resultado.getFloat("precoUnitario"),
                        resultado.getFloat("quantidade")
                ));
            }
            BD.desconecta(conexao);
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro ao criar um statement.");
            System.out.println(e);
        }
        BD.desconecta(conexao);
        return new ArrayList<VendaProduto>();
    }

    public static VendaProduto getPorID(int id){
        Connection conexao = BD.connecta();

        try {
            Statement statement = conexao.createStatement();

            String sql = "SELECT * FROM venda_produto WHERE id = " + id;
            ResultSet resultado = statement.executeQuery(sql);
            if(resultado.next()){
                VendaProduto p = new VendaProduto(
                        resultado.getInt("id"),
                        resultado.getInt("idVenda"),
                        resultado.getInt("idProduto"),
                        resultado.getFloat("precoUnitario"),
                        resultado.getFloat("quantidade")
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

    public static void imprime(VendaProduto p){
        System.out.println("Cód. do Produto: "  + p.getIdProduto());
        System.out.println("Preço Unitário: "   + p.getPrecoUnitario());
        System.out.println("Quantidade: "       + p.getQuandidade());
        System.out.println("Subtotal: "         + (p.getPrecoUnitario()*p.getQuandidade()));
    }
}