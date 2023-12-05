package model;

import java.util.Date;

public class Venda {
    private int id;
    private int idCliente;
    private Date dataVenda;
    private boolean entrega;

    public Venda() {
    }

    public Venda(int id, int idCliente, Date dataVenda, boolean entrega) {
        this.id = id;
        this.idCliente = idCliente;
        this.dataVenda = dataVenda;
        this.entrega = entrega;
    }

    public Venda(int idCliente, Date dataVenda, boolean entrega) {
        this.idCliente = idCliente;
        this.dataVenda = dataVenda;
        this.entrega = entrega;
    }

    public Venda(int id, int idVenda, int idProduto, float precoUnitario, float quantidade) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataVenda () {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public boolean isEntrega() {
        return entrega;
    }

    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }
}
