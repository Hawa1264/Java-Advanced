// throw: deposit, setGpa, setAge (README section 16)

class BankAccount {
    private double balance;

    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be more than 0");
        }
        balance += amount;
        System.out.println("Deposited " + amount);
    }
}

class Student {
    private String name;
    private double gpa;
    private int age;

    Student(String name) { this.name = name; }

    void setGpa(double gpa) {
        if (gpa < 0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }
        this.gpa = gpa;
        System.out.println(name + "'s GPA set to " + gpa);
    }

    void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be 0-150, got " + age);
        }
        this.age = age;
        System.out.println(name + "'s age set to " + age);
    }
}

public class ThrowDemo {
    public static void main(String[] args) {
        System.out.println("--- deposit ---");
        BankAccount acc = new BankAccount();
        try {
            acc.deposit(100);   // OK
            acc.deposit(-50);   // throws
            acc.deposit(20);    // skipped!
        } catch (IllegalArgumentException e) {
            System.out.println("Refused: " + e.getMessage());
        }

        System.out.println("--- setGpa ---");
        Student amina = new Student("Amina");
        try {
            amina.setGpa(3.6);
            amina.setGpa(4.5);   // throws
            amina.setGpa(2.0);   // skipped
        } catch (IllegalArgumentException e) {
            System.out.println("Refused: " + e.getMessage());
        }

        System.out.println("--- setAge ---");
        try {
            amina.setAge(20);
            amina.setAge(200);   // throws
        } catch (IllegalArgumentException e) {
            System.out.println("Refused: " + e.getMessage());
        }
    }
}
