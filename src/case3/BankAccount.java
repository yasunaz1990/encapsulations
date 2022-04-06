package case3;

import java.util.Date;

public class BankAccount {
    // ------------------- Fields ------------------- //
    public String fullName;
    public String address;
    public long accountNumber;
    public double currentBalance;
    public boolean isAccountActive;
    public String[] transactionHistory;
    public int tranIdx = 0;

    // ------------------- Constructor(s) -------------------//
    public BankAccount(String fullName) {
        this.fullName = fullName;
        address = "";
        accountNumber = generateAccountNumber();
        currentBalance = 0.0;
        isAccountActive = true;
        transactionHistory = new String[100];
    }

    public BankAccount(String name, String fullAddress) {
        fullName = name;
        this.address = fullAddress;
        accountNumber = generateAccountNumber();
        currentBalance = 0.0;
        isAccountActive = true;
        transactionHistory = new String[100];
    }

    // ------------------- Methods -------------------//
    // Helper Method
    // Capability:  Generate random 6 digit account number
    public long generateAccountNumber() {
        long generated = (long)(Math.random() * 10_000_000) + 90_000_000;
        return generated;
    }


    public void setName(String name) {
        if(name.length() == 0 || name == null || name.equals("")) {
            String msgToProgrammer = "Name cannot be empty or null";
            throw new IllegalArgumentException(msgToProgrammer);
        }
        this.fullName = name;
    }

    public String getName() {
        return this.fullName;
    }

    public void setAddress(String fullAddress) {
        if(!fullAddress.contains("USA")) {
            String msg1 = "Sorry, BankAccount object should only used ";
            String msg2 = "to represent user located in USA";
            String msgToProgrammer = msg1 + msg2;
            throw new IllegalArgumentException(msgToProgrammer);
        }
        this.address = fullAddress;
    }

    public void printBankAccountUserInfo() {
        StringBuilder strb = new StringBuilder();
        strb.append("\n==========User Information================\n")
                .append("User Name: " + this.fullName + "\n")
                .append("User Addr: " + getShortAddress() + "\n")
                .append("Account Ending: "+ getShortAccountNumber() +"\n")
                .append("Current Account Balance:  $" + this.currentBalance + "\n")
                .append("Acount is Active : " + isAccountActive )
                .append("==========================================");

        System.out.println( strb.toString() );
    }

    public String getShortAddress() {
        // only return their city and country
        String[] addressPart = address.split(",");
        String userShortAddrs = addressPart[1] + addressPart[2];
        return userShortAddrs;
    }

    public String getShortAccountNumber() {
        String accountNum = String.valueOf(this.accountNumber);
        return accountNum.substring(3);
    }


    public void deposit(double amount) {
        if(amount <= 0) {
            String msgToProgrammer = "deposit amount cannot be negative or zero";
            throw new IllegalArgumentException(msgToProgrammer);
        }
        this.currentBalance += amount;

        // bookkeeping operation
        String transactionMessage = "DEPOSIT  MADE ON: ";
        Date date = new Date();
        String currentDate = date.toString();
        transactionMessage += currentDate;
        transactionMessage += " with the ammount:  +$" + this.currentBalance;
        this.transactionHistory[tranIdx] = transactionMessage;
        tranIdx++;
    }


    public void transactionLog(String tranType){
        String transactionMessage="";
        if(tranType.equalsIgnoreCase("Deposit")) {
            transactionMessage = "DEPOSIT  MADE ON: ";
        }else if(tranType.equalsIgnoreCase("Withdrawl")){

        }
        Date date = new Date();
        String currentDate = date.toString();
        transactionMessage += currentDate;
        transactionMessage += " with the ammount:  $" + this.currentBalance;
        this.transactionHistory[tranIdx] = transactionMessage;
        tranIdx++;
    }

    public void withdraw(double amount) {
        if(amount > currentBalance) {
            String msgToProgrammer = "User cannot withdraw more than their current balance";
            throw new IllegalArgumentException(msgToProgrammer);
        }
        this.currentBalance -= amount;

        // book keeping operation
        // book keeping operation
        String transactionMessage = "WITHDRAW MADE ON: ";
        Date date = new Date();
        String currentDate = date.toString();
        transactionMessage += currentDate;
        transactionMessage += " with the ammount:  -$" + this.currentBalance;
        this.transactionHistory[tranIdx] = transactionMessage;
        tranIdx++;
    }

    public void showTransactionHistory(){
        System.out.println("=========== Transaction History  ===============");
        for(String transaction:  transactionHistory) {
            if(transaction == null) {
                continue;  // we don't care for null values
            }
            System.out.println(transaction);
        }
    }
}
