import java.util.Scanner;

class BankAccount2 {
    private double balance;

    public BankAccount2(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private BankAccount2 bankAccount;
    private Scanner scanner;

    public ATM(BankAccount2 bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("===== ATM Menu =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.println("Your account balance is: " + bankAccount.getBalance() + " Rs");
    }

    private void deposit() {
        System.out.print("Enter the amount you want to deposit: ");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
        System.out.println("Deposit successful. Your updated balance is: " + bankAccount.getBalance() + " Rs");
    }

    private void withdraw() {
        System.out.print("Enter the amount you want to withdraw: ");
        double amount = scanner.nextDouble();
        boolean success = bankAccount.withdraw(amount);
        if (success) {
            System.out.println("Withdrawal successful. Your updated balance is: " + bankAccount.getBalance() + " Rs");
        } else {
            System.out.println("Insufficient balance. Please try again with a lower amount.");
        }
    }
}

public class BankAccount {
    public static void main(String[] args) {
        double initialBalance = 0.0; 
        BankAccount2 bankAccount = new BankAccount2(initialBalance);
        ATM atm = new ATM(bankAccount);
        atm.start();
    }
}