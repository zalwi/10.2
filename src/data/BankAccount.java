package data;

import logic.NegativeBalanceException;
import logic.WithdrawLimitException;

public class BankAccount {
    static final int WITHRAW_LIMIT=1000;
    private Person person;
    private double balance;

    public BankAccount(Person person, double balance) {
        if(person == null) throw new NullPointerException("Nie można utworzyć konta bez przypisanej osoby");
        this.person = person;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
        System.out.println("Stan konta po wpłacie= " + getBalance());
    }

    public void withdraw(double amount){
        if(amount > balance) throw new NegativeBalanceException("Niewystarczająca ilość wymaganych środków na koncie, brakuje " + (balance-amount) + "zł");
        if(amount > WITHRAW_LIMIT) throw new WithdrawLimitException("Kwota jednorazowej wypłaty("+WITHRAW_LIMIT+"zł) przekroczona o " + (amount-WITHRAW_LIMIT) + "zł");
        balance -= amount;
        System.out.println("Stan konta po wypłacie= " + getBalance());
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "person=" + person +
                ", balance=" + balance +
                '}';
    }
}
