# Sistema de Conta Bancária (Java)

Projeto simples em Java para praticar tratamento de exceções (`try`/`catch`) e separação de responsabilidades entre as camadas do sistema.

## O que o projeto faz

Simula, via menu no console, as operações básicas de uma conta bancária:

- Depositar
- Sacar
- Consultar saldo

## O que pratiquei

- Criação de uma exceção própria (`InsufficientBalanceException`), lançada quando o valor do saque é maior que o saldo disponível.
- Separação entre quem lança o erro e quem decide como mostrar ele pro usuário: a classe `Account` só lança as exceções, sem saber nada sobre o console. Quem captura e exibe a mensagem é a `App`, que é a camada mais próxima da interação com o usuário — a `Main` fica só como ponto de entrada do programa.
- Uso do `BigDecimal` para representar o saldo, evitando os erros de arredondamento que o `double` pode causar com valores monetários.
- Validações básicas, impedindo depósitos e saques com valores negativos ou zero.

## Estrutura

```
bankaccount/
├── domain/
│   └── Account.java
├── exception/
│   └── InsufficientBalanceException.java
├── App.java
└── Main.java
```

## Como rodar

```
javac -d out $(find src -name "*.java")
java -cp out bankaccount.Main
```

## Próximos passos

- Adicionar testes automatizados para as regras da `Account`.
- Criar uma camada de `Service`, caso o projeto cresça (por exemplo, pra guardar um histórico de transações).