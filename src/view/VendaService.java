package view;

import controller.VendaController;
import model.Venda;
import service.Leitor;

public class VendaService {
    public static void cadastrar(){
        System.out.println("==========================================");
        System.out.println("===============NOVA VENDA=================");
        System.out.println("==========================================");

        Venda v = new Venda();
        System.out.println("\nInforme o id do Cliente: ");
        v.setIdCliente(Leitor.inteiros());

        System.out.println("É entrega? (s) Sim (n) Não");
        v.setEntrega(Leitor.texto().toLowerCase().equals("s")? true : false);

        if (VendaController.insertVenda(v)){
            System.out.println("\n\nVenda Cadastrada!");
        } else {
            System.out.println("\n\nErro ao cadastrar a venda!");
        }
    }
}
