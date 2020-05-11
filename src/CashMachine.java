import data.BankAccount;
import data.Person;
import logic.NegativeBalanceException;
import logic.WithdrawLimitException;

public class CashMachine {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(new Person("Kamil", "Zalwert"), 3000);
        //sprobuj utworzyć konto bez osoby
        try {
            BankAccount nullPersonAccount = new BankAccount(null, 0);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        //sprobuj wypłacić ponad stan konta
        try {
            bankAccount.withdraw(3100);
        } catch (WithdrawLimitException | NegativeBalanceException e) {
            e.printStackTrace();
        }
        //dodaj 100zł
        bankAccount.deposit(100);
        //wypłać wszystko
        try {
            bankAccount.withdraw(3100);
        } catch (WithdrawLimitException | NegativeBalanceException e) {
            e.printStackTrace();
        }
    }
}
