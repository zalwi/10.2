package data;

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
        if(amount > balance) throw new IllegalArgumentException("Brak wymaganych środków na koncie");
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
