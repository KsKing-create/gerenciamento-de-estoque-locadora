public class Dvd extends Produto {
    private String diretor;

    public Dvd(String descricao, double precoCusto, int estoqueDisponivel, String diretor) {
        super(descricao, precoCusto, estoqueDisponivel);
        this.diretor = diretor;
        calcularPrecoVenda();
    }

    @Override
    public void calcularPrecoVenda() {
        this.setPrecoVenda(this.getPrecoCusto() * 1.20);
    }

    public void calcularPrecoVenda(double cotacao) {
        this.setPrecoVenda(this.getPrecoCusto() * cotacao);
    }

    public String getDiretor() { return diretor; }
    public void setDiretor(String diretor) { this.diretor = diretor; }
}