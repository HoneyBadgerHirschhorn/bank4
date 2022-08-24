package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Scanner;

public class Branch {

    Customer customer = new Customer();
    private String branchName;
    private ArrayList<Customer> customerList = new ArrayList<Customer>();

    public Branch(String branchName, ArrayList<Customer> customerList) {
        this.branchName = branchName;
        this.customerList = customerList;
    }

    public Branch() {
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(){
        Scanner setBranchNameScanner = new Scanner(System.in);
        System.out.println("Please enter the bank branch name.");
        String name = setBranchNameScanner.nextLine();
        this.branchName = name;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void createCustomerList(){
        Scanner createCustomerListScanner = new Scanner(System.in);
        System.out.println("Please enter a name for the first customer on the list.");
        String name = createCustomerListScanner.nextLine();
        customer.setCustomerName(name);
        System.out.println("Please enter an initial transaction.");
        boolean isInt = createCustomerListScanner.hasNextInt();
        if (isInt) {
            double transaction = createCustomerListScanner.nextDouble();
            customer.getTransactions().add(transaction);
            Customer newCustomer = new Customer(name,customer.getTransactions());
            System.out.println("A new file with an initial transaction of "+transaction+" has been entered for "+ newCustomer.getCustomerName()+" a member of "+ getBranchName()+ "bank branch.");
        }
        if (!isInt){
            System.out.println("You did not enter a valid number, please try again.");
            createCustomerList();
        }
    }

    public void setCustomerList() {
        String name = customer.getCustomerName();
        ArrayList<Double> transactions = customer.getTransactions();
        Customer newCustomer = new Customer(name, transactions);
        customerList.add(newCustomer);
    }



    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
}
