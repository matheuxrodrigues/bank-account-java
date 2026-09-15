package bankaccount.domain;

import bankaccount.exception.InsufficientBalanceException;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;

    public Account() {
        this.balance = BigDecimal.ZERO;
    }

    @Override
    public String toString() {
        return "SALDO: " + balance;
    }

    public void deposit(BigDecimal depositAmount) {
        if (depositAmount == null || depositAmount.signum() <= 0) {
            throw new IllegalArgumentException("VALOR INVÁLIDO");
        }

        balance = balance.add(depositAmount);
    }

    public void withdraw(BigDecimal withdrawalAmount) {
        if (withdrawalAmount == null || withdrawalAmount.signum() <= 0) {
            throw new IllegalArgumentException("VALOR INVÁLIDO");
        }

        if (withdrawalAmount.compareTo(balance) > 0) {
            throw new InsufficientBalanceException("SALDO INSUFICIENTE");
        }

        balance = balance.subtract(withdrawalAmount);
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
