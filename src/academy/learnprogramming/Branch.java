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
