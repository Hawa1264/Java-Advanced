// Don't use an empty catch (README section 13)

public class EmptyCatchDemo {
    static double balance = 200;

    static void deposit(double a) { balance += a; }

    public static void main(String[] args) {

        System.out.println("--- BAD: empty catch hides the problem ---");
        try {
            int amount = Integer.parseInt("1oo");   // letters o
            deposit(amount);
        } catch (NumberFormatException e) {
            // nothing here
        }
        System.out.println("Deposit complete. Thank you!");   // a lie!
        System.out.println("Balance: " + balance);

        System.out.println("--- GOOD: tell the user ---");
        try {
            int amount = Integer.parseInt("1oo");
            deposit(amount);
            System.out.println("Deposit complete.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Nothing was deposited.");
        }
        System.out.println("Balance: " + balance);
    }
}
