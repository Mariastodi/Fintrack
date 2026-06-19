package fintrack.app;

import fintrack.controller.FinTracker;
import fintrack.model.Transacao;
import fintrack.model.TransacaoMensal;
import fintrack.exceptions.EntradaInvalidaException;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FinTracker tracker = new FinTracker();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            try {
                System.out.println("\n===== FINTRACK - O INIMIGO DO SERASA =====");
                System.out.println("1. Adicionar nova transação");
                System.out.println("2. Listar transações");
                System.out.println("3. Mostrar saldo atual");
                System.out.println("4. Remover transação");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");

                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Descrição: ");
                        String desc = scanner.nextLine();
                        System.out.print("Valor: ");
                        double valor = Double.parseDouble(scanner.nextLine());
                        System.out.print("É receita? (s/n): ");
                        boolean ehReceita = scanner.nextLine().equalsIgnoreCase("s");
                        System.out.print("É mensal/fixa? (s/n): ");
                        boolean ehMensal = scanner.nextLine().equalsIgnoreCase("s");

                        if (valor < 0) throw new EntradaInvalidaException("O valor não pode ser negativo.");

                        Transacao nova;
                        if (ehMensal) {
                            nova = new TransacaoMensal(desc, valor, ehReceita, LocalDate.now());
                        } else {
                            nova = new Transacao(desc, valor, ehReceita, LocalDate.now());
                        }
                        tracker.adicionarTransacao(nova);
                        break;

                    case 2:
                        tracker.listarTransacoes();
                        break;

                    case 3:
                        System.out.printf("Saldo Atual: R$ %.2f\n", tracker.calcularSaldoTotal());
                        break;

                    case 4:
                        tracker.listarTransacoes();
                        System.out.print("Digite o índice para remover: ");
                        int idx = Integer.parseInt(scanner.nextLine());
                        tracker.removerTransacao(idx);
                        break;

                    case 5:
                        System.out.println("Encerrando sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.err.println("Erro: Por favor, insira um número válido.");
            } catch (EntradaInvalidaException e) {
                System.err.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
