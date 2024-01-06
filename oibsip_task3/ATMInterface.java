import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;

public class ATMInterface {

    private String name = "";
    private String userName = "";
    private String password = "";
    private double amount = 0;
    private int userInput;

    private ArrayList<String> list;

    private String accountNumber = "";

    Scanner scanner = new Scanner(System.in);

    public ATMInterface(){

        list = new ArrayList<>();
        System.out.println("---Welcome to ATM System--");
        System.out.println();
        System.out.println("Registration - 1");
        System.out.println("Exit - 0");

        System.out.print("Enter Choice: ");
        this.userInput = scanner.nextInt();

        while (!(this.userInput == 1 || this.userInput == 0)){
            System.out.print("Invalid Choice Enter Again: ");
            this.userInput = scanner.nextInt();
        }

        if(this.userInput == 1){
            RegisterUser();
        } else {
            System.out.println("Thanks for Using this service...");
            exit(0);
        }
    }

    public void RegisterUser(){
        System.out.println("---Welcome to ATM System Registration--");
        System.out.println();
        System.out.print("---Registration Details---");
        System.out.println();

        System.out.print("Enter Your Name:  ");
        this.name = scanner.next();

        while(this.name.isEmpty()){
            System.out.print("Enter Your Name:  ");
            this.name = scanner.next();
        }

        while (this.userName.isEmpty()){
            System.out.print("Enter User Name:  ");
            this.userName = scanner.next();
        }

        while (this.password.isEmpty()){
            System.out.print("Enter Password:  ");
            this.password = scanner.next();
        }

        while (this.accountNumber.isEmpty()){
            System.out.print("Enter Account Number:  ");
            this.accountNumber = scanner.next();
        }

        if(!(this.name.isEmpty() && this.userName.isEmpty() && this.password.isEmpty() && this.accountNumber.isEmpty())){
            loginPage();
        }

    }

    public void loginPage(){
        System.out.println("---Registration Completed--");
        System.out.println();
        System.out.println("Login - 1");
        System.out.println("Exit - 0");

        System.out.print("Enter Choice: ");
        this.userInput = scanner.nextInt();

        while (!(this.userInput == 1 || this.userInput == 0)){
            System.out.print("Invalid Choice Enter Again: ");
            this.userInput = scanner.nextInt();
        }

        if(this.userInput == 1){
            Login();
        }else {
            exit(0);
        }
    }

    public void Login(){

        String enterUserName="";
        String enterPassword="";

        System.out.println("---Welcome to ATM System Login--");
        System.out.println();
        System.out.print("---Enter Login Crendentials---");
        System.out.println();

        while (enterUserName.isEmpty() || enterPassword.isEmpty()){

            System.out.print("Enter User Name: ");
            enterUserName = scanner.next().trim();

            System.out.print("Enter User Password: ");
            enterPassword = scanner.next().trim();

            if(enterUserName.isEmpty()){

                System.out.print("Enter User Name: ");
                enterUserName = scanner.next().trim();
            }
            else if(enterPassword.isEmpty()){
                System.out.print("Enter User Password: ");
                enterPassword = scanner.next().trim();
            }
        }

        if(Objects.equals(this.userName, enterUserName) && Objects.equals(this.password, enterPassword)){
            userAccount();
        }else {
            Login();
        }

    }

    public void userAccount(){
        System.out.println();
        System.out.println("---Welcome "+this.name+"---");
        System.out.println("----------------------------");

        System.out.println("Account No: "+this.accountNumber);
        System.out.println("--------------------------------");

        System.out.println("Withdraw - 1");
        System.out.println("Deposit - 2");
        System.out.println("Transfer - 3");
        System.out.println("Check Balance - 4");
        System.out.println("Transaction History - 5");
        System.out.println("Log Out - 0");

        System.out.println();
        System.out.print("Enter Choice: ");
        this.userInput = scanner.nextInt();

        while (!(this.userInput == 1 || this.userInput == 2 || this.userInput == 3 || this.userInput == 4 ||this.userInput == 5  || this.userInput == 0)){
            System.out.print("Invalid Choice Enter Again: ");
            this.userInput = scanner.nextInt();
        }

        if(this.userInput == 1){

            double withdraw = 0;

            System.out.print("Enter amount to withdraw: ");
            withdraw = scanner.nextDouble();

            while (withdraw==0 || withdraw>1000 || withdraw>this.amount){
                System.out.print("Cannot withdraw Enter again: ");
                withdraw = scanner.nextDouble();
            }

            System.out.println("Successfully withdraw "+withdraw+" from "+this.accountNumber+" Account Number...");

            String withdrawDetails = "Withdraw "+withdraw;
            list.add(withdrawDetails);

            this.amount-=withdraw;
            userAccount();

        } else if (this.userInput == 2) {
            double deposit = 0;

            System.out.print("Enter amount to Deposit: ");
            deposit = scanner.nextDouble();

            while (deposit==0 || deposit<0 ){
                System.out.print("Cannot Deposit Enter again: ");
                deposit = scanner.nextDouble();
            }

            System.out.println("Successfully Deposit "+deposit+"to "+this.accountNumber+" Account Number....");

            String depositDetails = "Deposit "+deposit;
            list.add(depositDetails);

            this.amount+=deposit;
            userAccount();
        }else if (this.userInput == 3) {

            double trans = 0;
            String toWho = "";

            while (trans==0 || toWho.isEmpty() || trans>this.amount){

                if(toWho.isEmpty()) {
                    System.out.print("Enter Name to Transfer: ");
                    toWho = scanner.next();
                }

                if(trans==0) {
                    System.out.println("Enter Transfer Amount: ");
                    trans = scanner.nextDouble();
                }

            }

            System.out.println("Successfully Transfer "+trans+" to "+toWho);

            this.amount-=trans;
            String transferDetails = "Transfer "+trans+" to "+toWho;
            list.add(transferDetails);
            userAccount();
        }else if (this.userInput == 4) {

            System.out.println("Available Balance is: "+this.amount);
            userAccount();
        }else if (this.userInput == 5) {

            for(String key : list){
                System.out.println(key);
            }
            userAccount();
        }else if (this.userInput == 0) {

            loginPage();
        }

    }

}
