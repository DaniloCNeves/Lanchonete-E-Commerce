package model;

public class VendaProduto {
    private int id;
    private int idVenda;
    private int idProduto;
    private float precoUnitario;
    private float quandidade;

    public VendaProduto() {
    }

    public VendaProduto(int id, int idVenda, int idProduto, float precoUnitario, float quandidade) {
        this.id = id;
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.precoUnitario = precoUnitario;
        this.quandidade = quandidade;
    }

    public VendaProduto(int idVenda, int idProduto, float precoUnitario, float quandidade) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.precoUnitario = precoUnitario;
        this.quandidade = quandidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public float getQuandidade() {
        return quandidade;
    }

    public void setQuandidade(float quandidade) {
        this.quandidade = quandidade;
    }
}