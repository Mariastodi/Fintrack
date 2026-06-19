```markdown
# FinTrack - Inimigo do serasa

O **FinTrack** é um sistema de controle de finanças pessoais desenvolvido em Java na versão console.
Este projeto foi criado para aplicar conceitos fundamentais de Programação Orientada a Objetos
e estruturas de controle.

## Funcionalidades:
Nesta versão inicial, o sistema permite:
* Cadastrar entradas - receitas e saídas - despesas.
* Listar todas as transações realizadas.
* Exibir o saldo atual total.
* Remover uma transação da lista.

## Tecnologias e Conceitos Aplicados
* Linguagem: Java puro.
* POO: Encapsulamento, Herança e Polimorfismo.
* Estruturas: ArrayList para armazenamento em memória e Scanner para entrada de dados.
* Tratamento de Exceções: Uso de blocos try/catch para segurança do sistema.

## Estrutura de Pacotes
O código está organizado da seguinte forma:
* `fintrack.app`: Classe principal com o menu interativo.
* `fintrack.controller`: Lógica de gerenciamento - FinTracker.
* `fintrack.model`: Classes base - `Transacao` e subclasses - `TransacaoMensal`.
* `fintrack.exceptions`: Exceções personalizadas.


