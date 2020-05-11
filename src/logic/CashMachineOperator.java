package logic;

import data.CashMachine;
import java.util.Scanner;

public class CashMachineOperator {
    private CashMachine cashMachine;

    public CashMachineOperator(CashMachine cashMachine) {
        this.cashMachine = cashMachine;
    }

    public void runCashMachine(){
        boolean loop=true;
        Scanner scanner = new Scanner(System.in);
        do{
            clearScreen();
            System.out.println("Wybierz opcję:\n" +
                                "1. Wypłata środków\n" +
                                "2. Wpłata środków\n" +
                                "3. Stan konta\n" +
                                "0. Koniec");

            String userChoice = scanner.nextLine();

            switch(userChoice){
                case "1" -> {
                    System.out.println("Podaj kwotę do wypłaty");
                    String amountString = scanner.nextLine();
                    if (isDoubleNumber(amountString)) {
                        cashMachine.tryWithdrawMoney(Double.parseDouble(amountString));
                    }
                }
                case "2" -> {
                    System.out.println("Podaj kwotę do wpłaty");
                    String amountString = scanner.nextLine();
                    if (isDoubleNumber(amountString)) {
                        cashMachine.tryDepositMoney(Double.parseDouble(amountString));
                    }
                }
                case "3" -> {cashMachine.readAccountBalance();}
                case "0" ->
                        {loop=false;}
                default ->
                        {showInformationBeforeNextLoop("Podano zły numer!");}
            };
            //loop=false;
        }while(loop);
    }

    private boolean isDoubleNumber(String amount){
        try {
            double amountFromString = Double.parseDouble(amount);
        }catch(NumberFormatException e){
            showInformationBeforeNextLoop("Podany ciąg nie jest liczbą zmiennoprzecinkową");
            return false;
        }
        return true;
    }

    public void showInformationBeforeNextLoop(String message){
        System.out.println(message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clearScreen(){
//        https://stackoverflow.com/questions/2979383/java-clear-the-console
//        ale nie dziala w środowisku
//        https://stackoverflow.com/questions/46242330/clearing-console-in-intellij-idea
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("------------------------------");
    }
}
