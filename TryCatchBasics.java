// try and catch: ATM, exception object, parent catch, marks, array index (README section 9)

public class TryCatchBasics {
    public static void main(String[] args) {

        System.out.println("--- ATM, handled ---");
        String input = "50o";   // letter o, not zero
        try {
            int amount = Integer.parseInt(input);              // 1. error occurs
            System.out.println("Withdrawing " + amount);       //    skipped
        } catch (NumberFormatException e) {                    // 2. goes to catch
            System.out.println("Please enter digits only");    // 3. tell the user
        }
        System.out.println("Back to main menu");               // 4. program continues

        System.out.println("--- Using the exception object e ---");
        try {
            int amount = Integer.parseInt("50o");
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount: " + e.getMessage());
        }

        System.out.println("--- A parent type also catches ---");
        try {
            int amount = Integer.parseInt("50o");
        } catch (Exception e) {   // Exception is the parent of NumberFormatException
            System.out.println("Caught by Exception: " + e.getMessage());
        }

        System.out.println("--- Student marks ---");
        for (String marksInput : new String[] {"8o", "80"}) {
            try {
                int marks = Integer.parseInt(marksInput);
                System.out.println("Marks saved: " + marks);
            } catch (NumberFormatException e) {
                System.out.println("Marks must be a number");
            }
            System.out.println("Back to student menu");
        }

        System.out.println("--- Array index ---");
        int[] scores = {70, 85, 90};
        try {
            System.out.println(scores[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There is no score at that position");
        }
    }
}
