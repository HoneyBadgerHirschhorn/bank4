package academy.learnprogramming;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Bank {
    Customer customer = new Customer();
    Branch branch = new Branch();


    private String bankName;
    private ArrayList<Branch> branchList = new ArrayList<Branch>();

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankname) {
        this.bankName = bankname;
    }
    
    public void setBankName(){
        Scanner setBankNameScanner = new Scanner(System.in);
        System.out.println("Please enter the bank name.");
        String name = setBankNameScanner.nextLine();
        this.bankName = name;
    }

    public ArrayList<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList() {
        String name = branch.getBranchName();
        ArrayList<Customer> customerList = branch.getCustomerList();
        Branch newbranch = new Branch(name, customerList);
        branchList.add(newbranch);
    }

    public void setBranchList(ArrayList<Branch> branchList) {
        this.branchList = branchList;
    }

    public void mainMenu(){
        Scanner mainScanner = new Scanner(System.in);
        System.out.println("Please choose an option below");
        System.out.println("(1) create a new customer");
        System.out.println("(2) choose an existing customer");
        System.out.println("(3) create a new bank branch");
        System.out.println("(4) choose an existing bank branch");
        System.out.println("(5) quit this program");
        boolean isInt = mainScanner.hasNextInt();
        if (isInt){
            int choice = mainScanner.nextInt();
            switch (choice){
                case 1:
                    customer.setCustomerName();
                    customer.setTransactions();
                    assignCustomer();
                    mainScanner.nextLine();
                    break;
                case 2:
                    selectCustomer();
                    mainScanner.nextLine();
                    break;
                case 3:
                    branch.setBranchName();
                    String name = branch.getBranchName();
                    branch.createCustomerList();
                    ArrayList<Customer> customerList = branch.getCustomerList();
                    Branch newBranch = new Branch(name,customerList);
                    branchList.add(newBranch);
                    mainScanner.nextLine();
                    break;
                case 4:
                    selectBranch();
                    mainScanner.nextLine();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);

            }
            mainMenu();
        }
    }

    public void assignCustomer(){
        Scanner assignCustomerScanner = new Scanner(System.in);
        if (branchList.size() == 0){
            System.out.println("There are no branches to work with yet!, you will need to create a branch for customers first using (3) on the main menu.");
            mainMenu();
        }
        System.out.println("You've chosen to work with "+customer.getCustomerName()+"'s file.\n"+
                           "What bank branch do you want to assign them to?");
        String branchname = assignCustomerScanner.nextLine();
        for (Branch chosenBranch : getBranchList()){
            if (Objects.equals(chosenBranch.getBranchName(),branchname)){
                chosenBranch.setBranchName(chosenBranch.getBranchName());
                chosenBranch.setCustomerList(chosenBranch.getCustomerList());
                Branch tempBranch = new Branch(branch.getBranchName(),branch.getCustomerList());
                tempBranch.setCustomerList();
                chosenBranch = tempBranch;
                branchList.set(branchList.indexOf(chosenBranch),chosenBranch);
            }
        }
        for (Customer chosenCustomer : branch.getCustomerList()){
            System.out.println(chosenCustomer.getCustomerName());
        }
    }

    public void selectCustomer(){
        Scanner selectCustomerScanner = new Scanner(System.in);
        System.out.println("Which customer file do you want to work with?");
        String name = selectCustomerScanner.nextLine();
        for (Branch b1 : branchList){
                for (Customer c1 : b1.getCustomerList()){
                    if (Objects.equals(c1.getCustomerName(),name)){
                        b1.setBranchName(b1.getBranchName());
                        b1.setCustomerList(b1.getCustomerList());
                        customer.setCustomerName(c1.getCustomerName());
                        customer.setTransactions(c1.getTransactions());
                        Branch b2 = new Branch(b1.getBranchName(),b1.getCustomerList());
                        System.out.println("Do you want to add a transaction (1), change the customer name (2), or return to the main menu (3) ?");
                        boolean isInt = selectCustomerScanner.hasNextInt();
                        if (isInt){
                            int choice = selectCustomerScanner.nextInt();
                            switch (choice){
                                case 1:
                                    customer.setTransactions();
                                    Customer c2 = new Customer(customer.getCustomerName(), customer.getTransactions());
                                    b1.getCustomerList().set(b1.getCustomerList().indexOf(c1),c2);
                                    selectCustomer();
                                    selectCustomerScanner.nextLine();
                                    break;
                                case 2:
                                    customer.setCustomerName();
                                    Customer c3 = new Customer(customer.getCustomerName(), customer.getTransactions());
                                    b1.getCustomerList().set(b1.getCustomerList().indexOf(c1),c3);
                                    selectCustomer();
                                    selectCustomerScanner.nextLine();
                                    break;
                                case 3:
                                    mainMenu();
                                    selectCustomerScanner.nextLine();
                                    break;
                            }
                        }
                    }
                }
        }
    }


}
