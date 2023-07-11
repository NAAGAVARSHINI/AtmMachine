import java.util.Scanner;

class InsufientException extends Exception{
    public InsufientException(String errorMessage){
        super(errorMessage);
    }
}

class InvalidAmountException extends Exception{
    public InvalidAmountException(String errorMessage){
        super(errorMessage);
    }
}
class Balance {
    private double accountBalance = 15000;

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}

class Atm{
    Balance bank = new Balance();

    double balance = bank.getAccountBalance();
    public void deposit(double amount) throws InvalidAmountException{
        if(amount<=0){
            throw new InvalidAmountException("You have entered Invalid amount");
        }
        balance+=amount;
        System.out.println("Amount Deposited Successfully \n New Balance: "+ balance);
    }

    public void withdraw(double amount) throws InsufientException, InvalidAmountException {

        if(amount<=0 ){
            throw new InsufientException("Account balance is insuffient ");
        }else if(amount > balance){
            throw new InvalidAmountException("You have entered invalid amount");
        }
        balance-=amount;
        System.out.println(" Amount Withdrawn Successfully \n New Balance: "+ balance);
    }
}

public class AtmMachine {
    public static void main(String[] args) {

        Atm atm = new Atm();

        Scanner sc= new Scanner(System.in);

        while(true){
            System.out.println("\n\nEnter 1 to Deposit: \nEnter 2 to withdraw: \nEnter 3 to view the balance: \nEnter 4 to exit");
            int choice= sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the Amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    try {
                        atm.deposit(depositAmount);
                    } catch (InvalidAmountException exception) {
                        System.out.println("Error: " + exception.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Enter the Amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    try {
                        atm.withdraw(withdrawAmount);
                    } catch (InsufientException exception1) {
                        System.out.println("Error" + exception1.getMessage());
                    } catch (InvalidAmountException exception2) {
                        System.out.println("Invalid amount " + exception2.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Current Balance is Rs: "+ atm.balance);
                    break;
                case 4:
                    System.exit(0);

            }
        }


    }
}