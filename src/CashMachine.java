import data.BankAccount;
import data.Person;

public class CashMachine {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(new Person("Kamil", "Zalwert"), 3000);

        try {
            bankAccount.withdraw(3100);
        }catch(IllegalArgumentException e) {
            e.printStackTrace();
        }

        bankAccount.deposit(100);
        bankAccount.withdraw(3100);
    }
}
