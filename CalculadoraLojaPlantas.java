import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Venda {
    int quantidade;
    double valorTotal;
    double desconto;

    public Venda(int quantidade, double valorTotal, double desconto) {
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
    }

    public void mostrarVenda() {
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Valor da venda: R$ " + valorTotal);
        System.out.println("Desconto aplicado: R$ " + desconto);
        System.out.println("--------------------------");
    }
}

public class CalculadoraLojaPlantas {

    static List<Venda> registroVendas = new ArrayList<>();

    public static double calcularValorTotal(int quantidade, double precoUnitario) {

        double total = quantidade * precoUnitario;
        double desconto = 0;

        if (quantidade > 10) {
            desconto = total * 0.05;
            total = total - desconto;
        }

        registroVendas.add(new Venda(quantidade, total, desconto));

        return total;
    }

    public static double calcularTroco(double valorPago, double valorCompra) {
        return valorPago - valorCompra;
    }

    public static void mostrarRegistroVendas() {

        if (registroVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
            return;
        }

        for (Venda venda : registroVendas) {
            venda.mostrarVenda();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {

            System.out.println("\n=== Sistema Loja Dona Gabrielinha ===");
            System.out.println("[1] Calcular valor da compra");
            System.out.println("[2] Calcular troco");
            System.out.println("[3] Ver registro de vendas");
            System.out.println("[4] Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:

                    System.out.print("Quantidade de plantas: ");
                    int quantidade = scanner.nextInt();

                    System.out.print("Preço unitário: ");
                    double preco = scanner.nextDouble();

                    double total = calcularValorTotal(quantidade, preco);

                    System.out.println("Valor final da compra: R$ " + total);
                    break;

                case 2:

                    System.out.print("Valor pago pelo cliente: ");
                    double valorPago = scanner.nextDouble();

                    System.out.print("Valor da compra: ");
                    double valorCompra = scanner.nextDouble();

                    double troco = calcularTroco(valorPago, valorCompra);

                    System.out.println("Troco: R$ " + troco);
                    break;

                case 3:
                    mostrarRegistroVendas();
                    break;

                case 4:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
