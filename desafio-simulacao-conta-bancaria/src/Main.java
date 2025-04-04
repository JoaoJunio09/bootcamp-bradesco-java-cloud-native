import entities.Cliente;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cliente cliente = null;

        System.out.println("Entre com os dados:");

        while (true) {
            System.out.print("Menu >> 1-Cadastrar Cliente | 2-Visualizar saldo  | 3-Depósito | 4-Saque | 5-Fechar >> ");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Idade: ");
                    Integer idade = sc.nextInt();
                    System.out.print("Informe o saldo inicial: ");
                    Double saldoInicial = sc.nextDouble();
                    cliente = new Cliente(1, nome, idade, saldoInicial);
                    break;
                case 2:
                    if (cliente == null)  {
                        System.out.println("ERROR >> Cadastre um Cliente para visualizar o saldo!");
                        break;
                    }
                    System.out.println("$== SALDO NO VALOR DE ==$");
                    System.out.println(cliente.getSaldo());
                    break;
                case 3:
                    if (cliente == null)  {
                        System.out.println("ERROR >> Cadastre um Cliente para realizar um Depósito!");
                        break;
                    }
                    System.out.print("Valor do Depósito: ");
                    Double valorDeposito = sc.nextDouble();
                    System.out.println("---------------");
                    System.out.println("$== SALDO ATUALIZADO NO VALOR DE ==$");
                    System.out.println(cliente.depositarDinheiro(valorDeposito));
                    break;
                case 4:
                    if (cliente == null)  {
                        System.out.println("ERROR >> Cadastre um Cliente para realizar um Saque!");
                        break;
                    }
                    System.out.print("Valor do Saque: ");
                    Double valorSaque = sc.nextDouble();
                    System.out.println("---------------");
                    System.out.println("$== SALDO ATUALIZADO NO VALOR DE ==$");
                    System.out.println(cliente.sacarDinheiro(valorSaque));
                    break;
                case 5:
                    sc.close();
                default:
                    System.out.println("ERROR >> Informe uma opção do menu válida!");
            }
        }
    }
}