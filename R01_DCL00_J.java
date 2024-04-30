package main;

public class AccountManager {

    private final int balance;
    private static final int deposit = getDeposit();
    
    private static int getDeposit() {
        return (int) (Math.random() * 100);
    }
    
    private static AccountManager instance = null; 
    
    private AccountManager() { 
        balance = deposit - 10; 
    }
    
    public static AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }
    
    public static void main(String[] args) {
        AccountManager account = AccountManager.getInstance();
        System.out.println("The account balance is: " + account.getBalance());
    }

    public int getBalance() {
        return balance;
    }
}