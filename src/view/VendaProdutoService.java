package view;

import controller.VendaProdutoController;
import model.VendaProduto;
import service.Leitor;

public class VendaProdutoService {
    public static void cadastrar(int idVenda){

        VendaProduto v = new VendaProduto();
        v.setIdVenda(idVenda);
        System.out.println("\nInforme o id do Produto: ");
        v.setIdProduto(Leitor.inteiros());

        System.out.println("Quantidade: ");
        v.setQuandidade(Leitor.decimais());

        if (VendaProdutoController.insertVendaProduto(v)){
            System.out.println("\n\nProduto adicionado à venda!");
        } else {
            System.out.println("\n\nErro ao lançar o produto na venda!");
        }
    }
}
