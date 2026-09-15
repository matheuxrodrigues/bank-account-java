package bankaccount;

import bankaccount.domain.Account;
import bankaccount.exception.InsufficientBalanceException;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class App {
    private Account account;
    private Scanner scanner;

    public App() {
        this.account = new Account();
        this.scanner = new Scanner(System.in).useLocale(Locale.US);
    }

    public void run() {

        int option;

        do {
            System.out.println("==============================");
            menu();
            option = scanner.nextInt();

            switch (option) {
                case 1 -> makeDeposit();
                case 2 -> makeWithdrawal();
                case 3 -> checkBalance();
                case 0 -> System.out.println("ATÉ LOGO!");
                default -> System.out.println("ESCOLHA UMA OPÇÃO VÁLIDA!");
            }

        } while (option != 0);
    }

    public void menu() {
        System.out.println("[1] - DEPOSITAR");
        System.out.println("[2] - SACAR");
        System.out.println("[3] - CONSULTAR SALDO");
        System.out.println("[0] - SAIR");
        System.out.print("------> ");
    }

    public void makeDeposit() {
        try {
            System.out.print("VALOR DO DEPOSITO: ");
            BigDecimal depositAmount = scanner.nextBigDecimal();

            account.deposit(depositAmount);
            System.out.println("==============================");
            System.out.println("DEPÓSITO REALIZADO COM SUCESSO!");

        } catch (IllegalArgumentException e) {
            System.out.println("==============================");
            System.out.println(e.getMessage());
        }
    }

    public void makeWithdrawal() {
        try {
            System.out.print("VALOR DO SAQUE: ");
            BigDecimal withdrawalAmount = scanner.nextBigDecimal();

            account.withdraw(withdrawalAmount);
            System.out.println("==============================");
            System.out.println("SAQUE REALIZADO COM SUCESSO");

        } catch (IllegalArgumentException | InsufficientBalanceException e) {
            System.out.println("==============================");
            System.out.println(e.getMessage());
        }
    }

    public void checkBalance() {
        System.out.println("==============================");
        System.out.println("SALDO DISPONÍVEL: " + account.getBalance());
    }
}
