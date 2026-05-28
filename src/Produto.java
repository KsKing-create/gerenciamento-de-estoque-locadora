public abstract class Produto {
    private String descricao;
    private double precoCusto;
    private double precoVenda;
    private int estoqueDisponivel;

    public Produto(String descricao, double precoCusto, int estoqueDisponivel) {
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.estoqueDisponivel = estoqueDisponivel;
    }

    public abstract void calcularPrecoVenda();

    public void vender(int qtd) throws EstoqueInsuficienteException {
        if (qtd > this.estoqueDisponivel) {
            throw new EstoqueInsuficienteException("Erro: Estoque insuficiente! Disponível: " + this.estoqueDisponivel);
        }
        this.estoqueDisponivel -= qtd;
        System.out.println("Venda realizada com sucesso!");
    }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public double getPrecoCusto() { return precoCusto; }
    public void setPrecoCusto(double precoCusto) { this.precoCusto = precoCusto; }
    public double getPrecoVenda() { return precoVenda; }
    public void setPrecoVenda(double precoVenda) { this.precoVenda = precoVenda; }
    public int getEstoqueDisponivel() { return estoqueDisponivel; }
    public void setEstoqueDisponivel(int estoqueDisponivel) { this.estoqueDisponivel = estoqueDisponivel; }
}