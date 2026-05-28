import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        List<Produto> listaProdutos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Cadastrar um Livro ou um DVD");
            System.out.println("2. Listar produtos");
            System.out.println("3. Simular venda");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("O que deseja cadastrar? (1 - Livro / 2 - DVD): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer

                    System.out.print("Descrição: ");
                    String desc = scanner.nextLine();
                    System.out.print("Preço de Custo: ");
                    double custo = scanner.nextDouble();
                    System.out.print("Estoque Inicial: ");
                    int estoque = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer

                    if (tipo == 1) {
                        System.out.print("Autor do Livro: ");
                        String autor = scanner.nextLine();
                        Livro novoLivro = new Livro(desc, custo, estoque, autor);
                        listaProdutos.add(novoLivro);
                        System.out.println("Livro cadastrado com sucesso!");
                    } else if (tipo == 2) {
                        System.out.print("Diretor do DVD: ");
                        String diretor = scanner.nextLine();
                        System.out.print("Cotação do Dólar para o preço: ");
                        double cotacao = scanner.nextDouble();

                        Dvd novoDvd = new Dvd(desc, custo, estoque, diretor);
                        novoDvd.calcularPrecoVenda(cotacao);
                        listaProdutos.add(novoDvd);
                        System.out.println("DVD cadastrado com sucesso!");
                    } else {
                        System.out.println("Tipo inválido!");
                    }
                    break;

                case 2:
                    if (listaProdutos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        for (int i = 0; i < listaProdutos.size(); i++) {
                            Produto p = listaProdutos.get(i);
                            System.out.printf("[%d] %s | Preço Venda: R$ %.2f | Estoque: %d%n", i, p.getDescricao(), p.getPrecoVenda(), p.getEstoqueDisponivel());                        }
                    }
                    break;

                case 3:
                    if (listaProdutos.isEmpty()) {
                        System.out.println("Nenhum produto para vender.");
                        break;
                    }
                    System.out.print("Digite o índice do produto (0, 1, etc): ");
                    int indice = scanner.nextInt();
                    System.out.print("Digite a quantidade: ");
                    int qtd = scanner.nextInt();

                    if (indice >= 0 && indice < listaProdutos.size()) {
                        try {
                            listaProdutos.get(indice).vender(qtd);
                        } catch (EstoqueInsuficienteException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Índice inválido!");
                    }
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}