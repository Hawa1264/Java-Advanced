// Checked exceptions: Catch or Specify (README section 11)

class BankAccount {
    private double balance = 200;

    void withdraw(double a) throws Exception {          // checked
        if (a > balance) throw new Exception("Insufficient balance");
        balance -= a;
    }
}

class Student {
    private int courses;

    Student(int courses) { this.courses = courses; }

    void registerCourse(String code) throws Exception {
        if (courses >= 6) throw new Exception("Maximum 6 courses");
        courses++;
    }
}

public class CatchOrSpecify {

    // Option 2: Specify it (pass it to the caller)
    static void atm(BankAccount acc, double amount) throws Exception {
        acc.withdraw(amount);
        System.out.println("Please take your cash");
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount();

        // Option 1: Catch it (handle it here)
        try {
            acc.withdraw(500);
        } catch (Exception e) {
            System.out.println("Refused: " + e.getMessage());
        }
        System.out.println("Back to main menu");

        // Option 2: Specify it, then catch it higher up
        try {
            atm(acc, 500);
        } catch (Exception e) {
            System.out.println("Refused (via atm): " + e.getMessage());
        }

        // Student registration
        Student hodan = new Student(6);   // Hodan already has 6 courses
        try {
            hodan.registerCourse("CA314");
        } catch (Exception e) {
            System.out.println("Registration refused: " + e.getMessage());
        }
    }
}
