package data;

import logic.NegativeBalanceException;
import logic.WithdrawLimitException;

public class BankAccount {
    private Person person;
    private double balance;

    public BankAccount(Person person, double balance) {
        if(person == null) throw new NullPointerException("Nie można utworzyć konta bez przypisanej osoby");
        this.person = person;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
        System.out.println(this.toString());
    }

    public void withdraw(double amount){
        if(amount > balance) throw new NegativeBalanceException("Niewystarczająca ilość wymaganych środków na koncie, brakuje " + (balance-amount) + "zł");
        if(amount > 1000) throw new WithdrawLimitException("Kwota jednorazowej wypłaty(1000zł) przekroczona o " + (amount-1000) + "zł");
        balance -= amount;
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "person=" + person +
                ", balance=" + balance +
                '}';
    }
}
