package academy.learnprogramming;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {

    private String customerName;
    private ArrayList<Double> transactions = new ArrayList<Double>();


    public Customer() {
    }

    public Customer(String customerName, ArrayList<Double> transactions) {
        this.customerName = customerName;
        this.transactions = transactions;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerName(){
        Scanner setNameScanner = new Scanner(System.in);
        System.out.println("Please enter the customer name.");
        String name = setNameScanner.nextLine();
        this.customerName = name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void setTransactions(){
        Scanner setTransactionsScanner = new Scanner(System.in);
        System.out.println("Please enter a transaction or press any non-numerical key to quit");
        boolean isnInt = setTransactionsScanner.hasNextInt();
        if (isnInt){
            double entry = setTransactionsScanner.nextInt();
            transactions.add(entry);
            setTransactions();
        }
        if (!isnInt){
            System.out.println("You've chosen to not enter a transaction.");
        }
    }

    public void setTransactions(ArrayList<Double> transactions) {
        this.transactions = transactions;
    }
}
