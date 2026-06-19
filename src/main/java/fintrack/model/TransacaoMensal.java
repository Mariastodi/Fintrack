package fintrack.model;

import java.time.LocalDate;

public class TransacaoMensal extends Transacao {
    public TransacaoMensal(String descricao, double valor, boolean ehReceita, LocalDate data) {
        super(descricao + " (Recorrente)", valor, ehReceita, data);
    }
}
