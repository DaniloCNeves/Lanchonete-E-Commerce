package view;

import controller.ClienteController;
import service.Leitor;

import java.util.ArrayList;

public class Cliente {

    public static void cadastrarClientes(){
        System.out.println("\n\nCadastrar Clientes");
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        String nome, email, endereco;
        int telefone;

        System.out.print("Nome: ");
        nome = Leitor.texto();

        System.out.print("Telefone: ");
        telefone = Leitor.inteiros();

        System.out.print("E-mail: ");
        email = Leitor.texto();

        System.out.printf("Endereço: ");
        endereco = Leitor.texto();

        ClienteController.insertCliente(new model.Cliente(nome, telefone, email, endereco));
    }

    public static void consultarClientes(){

        System.out.println("\n\nClientes Cadastrados:");
        System.out.println("========================");
        System.out.println("(1) Todos os Clientes");
        System.out.println("Escolha uma opção, ou digite qualquer coisa para voltar: ");

        int op = Leitor.inteiros();

        switch(op){
            case 1: todosClientes(); break;
            default:
                System.out.println("\n\nVoltando ao início...\n\n");
                break;
        }
    }

    public static void updateCliente(){
        System.out.println("\n\n=============================");
        System.out.println("----------LISTA DE CLIENTES----------");
        todosClientes();
        System.out.print("\n\nQual ID deseja atualizar? ");

        int id = Leitor.inteiros();
        model.Cliente c = ClienteController.getPorID(id);

        if(c == null){
            System.out.println("\n\nID não encontrado.\n");
        }else{
            System.out.println("Nome atual: " + c.getNome());
            System.out.print("Informe um novo nome, ou tecle enter: ");
            String nome = Leitor.texto();
            if(nome != ""){
                c.setNome(nome);
            }

            System.out.println("Telefone atual: " + c.getTelefone());
            System.out.print("Informe um novo telefone, ou tecle enter: ");
            int telefone = Leitor.inteiros();
            if(telefone != 0){
                c.setTelefone(telefone);
            }

            System.out.println("E-mail atual: " + c.getEmail());
            System.out.print("Informe um novo e-mail, ou tecle enter: ");
            String email = Leitor.texto();
            if(email != ""){
                c.setEmail(email);
            }

            System.out.println("Endereço atual: " + c.getEndereco());
            System.out.println("Informe um novo endereço, ou tecle enter: ");
            String endereco = Leitor.texto();
            if (endereco != ""){
                c.setEndereco(endereco);
            }

            if(ClienteController.updtCliente(c)){
                System.out.println("\n\nCliente Atualizado!");
            }else{
                System.out.println("\n\nErro ao atualizar.");
            }
        }
    }

    public static void excluirCliente(){
        System.out.println("\n\nObserve os cadastrados abaixo:");

        todosClientes();

        System.out.println("===================================");
        System.out.println("===================================\n\n");
        System.out.print("Qual id deseja exluir? ");

        int id = Leitor.inteiros();

        if(ClienteController.deletePorId(id)){
            System.out.println("Id: '" + id + "' excluído com sucesso!");
        } else {
            System.out.println("Deu ruim ao tentar apagar!");
        }
    }

    private static void todosClientes(){

        ArrayList<model.Cliente> lista = ClienteController.getAll();

        for(model.Cliente c : lista){
            System.out.println("ID: "           + c.getId());
            System.out.println("Nome: "         + c.getNome());
            System.out.println("Telefone: "    + c.getTelefone());
            System.out.println("E-mail: "        + c.getEmail());
            System.out.println("Endereço: "     + c.getEndereco());
            System.out.println("----------------------------------------");
        }

        if(lista.isEmpty()){
            System.out.println("Nenhum cliente cadastrado");
        }
    }
}
