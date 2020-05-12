import data.CashMachine;
import logic.CashMachineOperator;

public class Main {
    public static void main(String[] args) {
        CashMachine cashMachine = new CashMachine("Kamil", "Zalwert", 5000);
        CashMachineOperator cashMachineOperator = new CashMachineOperator(cashMachine);

        cashMachineOperator.runCashMachine();
    }
}
