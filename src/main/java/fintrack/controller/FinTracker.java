package fintrack.controller;

import fintrack.model.Transacao;
import java.util.ArrayList;
import java.util.List;

public class FinTracker {
    private List<Transacao> transacoes; // Uso de ArrayList [2]

    public FinTracker() {
        this.transacoes = new ArrayList<>();
    }

    public void adicionarTransacao(Transacao t) {
        transacoes.add(t);
        System.out.println("Transação adicionada com sucesso!");
    }

    public void listarTransacoes() {
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
            return;
        }
        for (int i = 0; i < transacoes.size(); i++) {
            System.out.println(i + " - " + transacoes.get(i));
        }
    }

    public void removerTransacao(int indice) {
        if (indice >= 0 && indice < transacoes.size()) {
            transacoes.remove(indice);
            System.out.println("Transação removida!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public double calcularSaldoTotal() {
        double saldo = 0;
        for (Transacao t : transacoes) {
            if (t.isEhReceita()) {
                saldo += t.getValor();
            } else {
                saldo -= t.getValor();
            }
        }
        return saldo;
    }
}
