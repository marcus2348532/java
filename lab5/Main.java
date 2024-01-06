//Q1

interface BankInterface {
    double getBalance();
    double getInterestRate();
}

class BankA implements BankInterface {
    private double balance = 10000;

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.0;
    }
}

class BankB implements BankInterface {
    private double balance = 150000;

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.4;
    }
}

class BankC implements BankInterface {
    private double balance = 200000;

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.9;
    }
}

public class Main {
    public static void main(String[] args) {
        BankInterface bankA = new BankA();
        BankInterface bankB = new BankB();
        BankInterface bankC = new BankC();

        displayBankDetails(bankA, "Bank A");
        displayBankDetails(bankB, "Bank B");
        displayBankDetails(bankC, "Bank C");
    }

    public static void displayBankDetails(BankInterface bank, String bankName) {
        System.out.println(bankName + " Balance: " + bank.getBalance());
        System.out.println(bankName + " Interest Rate: " + bank.getInterestRate() + "%");
        System.out.println();
    }
}

