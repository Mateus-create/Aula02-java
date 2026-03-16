import java.util.Scanner;

public class CalculadoraLojaPlantas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Calcular Preço Total");
        System.out.println("2 - Calcular Troco");
        System.out.print("Escolha: ");

        int opcao = sc.nextInt();

        if (opcao == 1) {

            System.out.print("Quantidade de plantas: ");
            int qtd = sc.nextInt();

            System.out.print("Preço unitário: ");
            double preco = sc.nextDouble();

            double total = qtd * preco;

            System.out.println("Total: R$ " + total);

        } else if (opcao == 2) {

            System.out.print("Valor pago: ");
            double pago = sc.nextDouble();

            System.out.print("Valor da compra: ");
            double compra = sc.nextDouble();

            double troco = pago - compra;

            System.out.println("Troco: R$ " + troco);

        } else {

            System.out.println("Opção inválida");

        }

        sc.close();
    }
}