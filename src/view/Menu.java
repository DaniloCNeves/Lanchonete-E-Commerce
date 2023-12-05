package view;

import controller.ClienteController;
import controller.ProdutoController;
import controller.VendaController;
import controller.VendaProdutoController;
import model.Venda;
import model.VendaProduto;
import service.Leitor;

import java.util.ArrayList;

public class Menu {

    public static void inicio(){
        while(0==0){
            System.out.println("=============================");
            System.out.println("=====SISTEMA DE LANCHONETE=====");
            System.out.println("=============================");
            System.out.println("(0) #SAIR#");
            System.out.println("(1) Cadastrar");
            System.out.println("(2) Consultar");
            System.out.println("(3) Excluir");
            System.out.println("(4) Editar");
            System.out.println("(5) VENDER");
            System.out.println("Escolha uma opção: ");
            int op = Leitor.inteiros();

            switch (op){
                case 0:
                    System.out.println("\n\nSaindo.... fui!");
                    System.exit(22);
                    break;

                case 1:
                    cadastrar();
                    break;

                case 2:
                    consultar();
                    break;

                case 3:
                    excluir();
                    break;

                case 4:
                    editar();
                    break;

                case 5:
                    vender();
                    break;
                default:
                    System.out.println("\n\nOpção inválida!\n\n");
            }
        }
    }

    private static void cadastrar(){
        System.out.println("\n\n+++++++++++++++++++++++");
        System.out.println("++++++++CADASTRAR+++++++++++++");
        System.out.println("+++++++++++++++++++++++++");
        System.out.println("(1)PRODUTOS");
        System.out.println("(2)CLIENTES");
        System.out.print("Informe a opção: ");
        int op = Leitor.inteiros();

        switch(op){
            case 1:
                Produto.cadastrarProdutos();
                break;
            case 2:
                Cliente.cadastrarClientes();
                break;
            default:
                System.out.println("\n\nOpção inválida");
                break;
        }
    }

    private static void consultar(){
        System.out.println("\n\n===========================");
        System.out.println("==========CADASTRAR============");
        System.out.println("===============================");
        System.out.println("(1)PRODUTOS");
        System.out.println("(2)CLIENTES");
        System.out.print("Informe a opção: ");
        int op = Leitor.inteiros();

        switch(op){
            case 1:
                Produto.consultarProduto();
                break;
            case 2:
                Cliente.consultarClientes();
                break;
            default:
                System.out.println("\n\nOpção inválida");
                break;
        }
    }

    private static void editar(){
        System.out.println("\n\n----------------------");
        System.out.println("--------EDITAR--------");
        System.out.println("----------------------");
        System.out.println("(1)PRODUTOS");
        System.out.println("(2)CLIENTES");
        System.out.print("Informe a opção: ");
        int op = Leitor.inteiros();

        switch(op){
            case 1:
                Produto.updateProduto();
                break;
            case 2:
                Cliente.updateCliente();
                break;
            default:
                System.out.println("\n\nOpção inválida");
                break;
        }
    }

    private static void excluir(){
        System.out.println("\n\n----------------------");
        System.out.println("--------EXCLUIR--------");
        System.out.println("----------------------");
        System.out.println("(1)PRODUTOS");
        System.out.println("(2)CLIENTES");
        System.out.print("Informe a opção: ");
        int op = Leitor.inteiros();

        switch(op){
            case 1:
                Produto.excluirProdutos();
                break;
            case 2:
                Cliente.excluirCliente();
                break;
            default:
                System.out.println("\n\nOpção inválida");
                break;
        }
    }

    private static void vender(){
        VendaService.cadastrar();

        while(0==0){
            VendaProdutoService.cadastrar(VendaController.getUltimoID());

            System.out.println("\n\nDeseja cadastrar mais um produto?");
            System.out.println("(s) ou (n)");

            if (!Leitor.texto().toLowerCase().equals("s")){
                System.out.println("\nEncerrando a venda...");
                break;
            }
        }
    }
}

/*
DEVER DE CASA

Altere o modelo de venda para que receba o id do cliente e o nome do cliente.
Altere o modelo de venda produto para que receba o id e nome do produto.

Os métodos de impressão nos controllers devem exibir os nomes ao invés do id;
 */