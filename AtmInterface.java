import java.util.*;

public class AtmInterface {
    static Scanner sc = new Scanner(System.in);
    private long amount = 0;
    private int pinNumber = 6113;

    public AtmInterface(long balance) {
        amount = balance;
    }

    public void setPin() {
        System.out.println("Enter old pin");
        int oldPin = sc.nextInt();
        if (oldPin == pinNumber) {
            System.out.println("Enter new pin number");
            int newPin = sc.nextInt();
            pinNumber = newPin;
        } else {
            System.out.println("you entered wrong pin number");
        }
        System.out.println("your pin successfully changed");
    }

    public void withdraw(long amount) {
        System.out.println("Enter your pin number");
        int pin = sc.nextInt();
        if (pin == pinNumber) {
            if (this.amount < amount) {
                System.out.println("You don't have sufficient balance");
            } else {
                this.amount -= amount;
                System.out.println("your remaining account balance is-" + this.amount);
            }
        } else {
            System.out.println("Your pin is wrong");
        }
    }

    public void deposite(long amount) {
        System.out.println("Enter your pin number");
        int pin = sc.nextInt();
        if (pin == pinNumber) {
            this.amount += amount;
            System.out.println("account balance-" + this.amount);
        } else {
            System.out.println("Your pin is wrong");
        }
    }

    public long checkBalance() {
        System.out.println("Enter your pin number");
        int pin = sc.nextInt();
        if (pin == pinNumber) {
            return this.amount;
        } else {
            System.out.println("Your pin is wrong");

        }
        return amount;
    }

    public static void main(String[] args) {
        AtmInterface object1 = new AtmInterface(5000l);
        BankAccount object = new BankAccount("Mohammad kasaf Siddique", 123456789l, 9719936609l,
                "mohammadkasaf6@gmail.com", "22/02/2001",
                "Hathras");

        System.out.println("Customer Name-" + object.getCustomerName());
        System.out.println();

        System.out.println("Account Number-" + object.getAccountNumber());
        System.out.println();

        System.out.println("Phone Number-" + object.getPhoneNumber());
        System.out.println();

        System.out.println("Email-" + object.getEmail());
        System.out.println();

        System.out.println("Date of birth-" + object.getDOB());
        System.out.println();

        System.out.println("Address-" + object.getAddress());
        System.out.println();

        System.out.println("for calling Atm interface methods we use switch case");
        System.out.println();
        System.out.println("1-for withdraw");
        System.out.println();
        System.out.println("2-for deposite");
        System.out.println();
        System.out.println("3-for balance enquiry");
        System.out.println();
        System.out.println("4-for set new pin");
        System.out.println();
        System.out.println("Enter number from 1 to 4 to call Atm methods");
        int userInput = sc.nextInt();

        switch (userInput) {
            case 1:
                System.out.println("Enter amount you want to withdraw");
                object1.withdraw(sc.nextLong());
                break;
            case 2:
                System.out.println("enter amount you want to deposite");
                object1.deposite(sc.nextLong());
                break;
            case 3:
                System.out.println("your account balance is-" + object1.checkBalance());
                break;
            case 4:
                object1.setPin();
                break;
            default:
                System.out.println("you enter wrong userInput");
                ;
                System.out.println("please try again");
                break;
        }

    }
}

class BankAccount extends AtmInterface {
    private String customerName;
    private long accountNumber;
    private long phoneNumber;
    private String email;
    private String dob;
    private String address;
    private long accountBalance;

    public BankAccount(String name, long number, long phone, String email, String dob, String address) {
        super(0);
        this.customerName = name;
        this.accountNumber = number;
        this.phoneNumber = phone;
        this.email = email;
        this.dob = dob;
        this.address = address;
    }

    public String getCustomerName() {
        return customerName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getDOB() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public long getAccountBalance() {
        accountBalance = super.checkBalance();
        return accountBalance;
    }
}