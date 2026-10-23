// finally: always runs (README section 15)

import java.io.IOException;
import java.io.PrintWriter;

class BankAccount {
    private double balance;

    BankAccount(double balance) { this.balance = balance; }

    void withdraw(double a) throws Exception {
        if (a > balance) throw new Exception("Insufficient balance");
        balance -= a;
    }
}

public class FinallyDemo {

    static void atm(BankAccount acc, String input) {
        try {
            int amount = Integer.parseInt(input);
            acc.withdraw(amount);
            System.out.println("Please take your cash");
        } catch (NumberFormatException e) {
            System.out.println("Digits only, please");
        } catch (Exception e) {
            System.out.println("Refused: " + e.getMessage());
        } finally {
            System.out.println("Card returned");    // always
        }
    }

    static String check(int age) {
        try {
            if (age < 18) return "Too young";
            return "Welcome";
        } finally {
            System.out.println("Check finished");   // still prints after return
        }
    }

    public static void main(String[] args) {
        System.out.println("--- ATM, balance 200 ---");
        for (String in : new String[] {"100", "500", "50o"}) {
            atm(new BankAccount(200), in);
        }

        System.out.println("--- Closing a file ---");
        PrintWriter out = null;
        try {
            out = new PrintWriter("out.txt");
            out.println("hello");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if (out != null) out.close();   // file always gets closed
            System.out.println("File closed");
        }

        System.out.println("--- finally even after return ---");
        System.out.println(check(15));
    }
}
