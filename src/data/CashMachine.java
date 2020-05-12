package data;

import data.BankAccount;
import data.Person;
import logic.NegativeBalanceException;
import logic.WithdrawLimitException;

public class CashMachine {

    private BankAccount bankAccount;

    public CashMachine(String firstName, String lastName, double balance) {
        this.bankAccount = new BankAccount(new Person(firstName, lastName), balance);
    }

    public void tryWithdrawMoney(double amount) {
        try {
            bankAccount.withdraw(amount);
        } catch (WithdrawLimitException | NegativeBalanceException e) {
            System.out.println(e.getMessage());;
        }
    }

    public void tryDepositMoney(double amount) {
        bankAccount.deposit(amount);
    }

    public void readAccountBalance(){
        System.out.println("Stan konta = " + bankAccount.getBalance());
    }

}
