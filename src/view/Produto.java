package view;

import controller.ProdutoController;
import service.Leitor;

import java.util.ArrayList;

public class Produto {
    public static void cadastrarProdutos(){
        System.out.println("\n\nCadastrar Produtos");
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        String nome, descricao;
        double preco;

        System.out.print("Informe o nome: ");
        nome = Leitor.texto();

        System.out.print("Descrição: ");
        descricao = Leitor.texto();

        System.out.print("Preço: ");
        preco = Leitor.doubleDecimais();

        ProdutoController.insertProduto(new model.Produto(nome, descricao,preco));

    }

    public static void excluirProdutos(){
        System.out.println("\n\nObserve os cadastrados abaixo:");

        todosProdutos();

        System.out.println("===================================");
        System.out.println("===================================\n\n");
        System.out.print("Qual id deseja exluir? ");

        int id = Leitor.inteiros();

        if(ProdutoController.deletePorId(id)){
            System.out.println("Id: '" + id + "' excluído com sucesso!");
        } else {
            System.out.println("Deu ruim ao tentar apagar!");
        }
    }

    public static void consultarProduto(){

        System.out.println("\n\nProdutos Cadastradas!");
        System.out.println("========================");
        System.out.println("(1) Todos os Produtos");
        System.out.println("Escolha uma opção, ou digite qualquer coisa para voltar: ");

        int op = Leitor.inteiros();

        switch(op){
            case 1: todosProdutos(); break;
            default:
                System.out.println("\n\nVoltando ao início...\n\n");
                break;
        }

    }

    public static void todosProdutos(){

        ArrayList<model.Produto> lista = ProdutoController.getAll();

        for(model.Produto p : lista){
            System.out.println("ID: "           + p.getId());
            System.out.println("Nome: "         + p.getNome());
            System.out.println("Descrição: "    + p.getDescricao());
            System.out.println("Preço: "        + p.getPreco());
            System.out.println("----------------------------------------");
        }

        if(lista.isEmpty()){
            System.out.println("Nenhum produto cadastrado");
        }
    }

    public static void updateProduto(){
        System.out.println("\n\n=============================");
        System.out.println("----------LISTA DE PRODUTOS----------");
        todosProdutos();
        System.out.print("\n\nQual ID deseja atualizar? ");

        int id = Leitor.inteiros();
        model.Produto p = ProdutoController.getPorID(id);

        if(p == null){
            System.out.println("\n\nID não encontrado.\n");
        }else{
            System.out.println("Nome atual: " + p.getNome());
            System.out.print("Informe um novo nome, ou tecle enter: ");
            String nome = Leitor.texto();
            if(nome != ""){
                p.setNome(nome);
            }

            System.out.println("Descrição atual: " + p.getDescricao());
            System.out.print("Informe uma nova descrição, ou tecle enter: ");
            String descricao = Leitor.texto();
            if(descricao != ""){
                p.setDescricao(descricao);
            }

            System.out.println("Preço atual: " + p.getPreco());
            System.out.print("Informe um novo preço, ou tecle enter: ");
            double preco = Leitor.doubleDecimais();
            if(preco != 0){
                p.setPreco(preco);
            }

            if(ProdutoController.updtProduto(p)){
                System.out.println("\n\nProduto Atualizado!");
            }else{
                System.out.println("\n\nErro ao atualizar.");
            }
        }
    }
}
