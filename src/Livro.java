public class Livro extends Produto {
    private String autor;

    public Livro(String descricao, double precoCusto, int estoqueDisponivel, String autor) {
        super(descricao, precoCusto, estoqueDisponivel);
        this.autor = autor;
        calcularPrecoVenda();
    }

    @Override
    public void calcularPrecoVenda() {
        this.setPrecoVenda(this.getPrecoCusto() * 1.15);
    }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
}