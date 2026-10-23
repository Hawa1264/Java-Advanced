// Unchecked exceptions: fix the bug, don't catch it (README sections 10 and 12)

public class FixTheBug {
    public static void main(String[] args) {

        // Divide by 0
        int totalMarks = 240;
        int courses = 0;
        int avg = 0;
        if (courses > 0) avg = totalMarks / courses;
        else System.out.println("No courses yet");

        // null object
        String s = null;   // stands in for a Student that was never selected
        if (s != null) System.out.println(s.length());
        else System.out.println("No student selected");

        // Typed "50o": comes from outside, so we catch it
        String input = "50o";
        int amount = 0;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Digits only, please");
        }

        // Error: the JVM runs out of stack (never catch this, fix the cause)
        try {
            recurse(1);
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError: a method that calls itself forever");
        }
    }

    static void recurse(int n) {
        recurse(n + 1);   // calls itself forever
    }
}
