import java.util.Stack;

/** Example 1: Push and print a stack */
public class PushAndPrintStack {

    public static void main(String[] args) {
            Stack<Integer> s1 = new Stack<Integer>();
            s1.push(10);
            s1.push(20);
            s1.push(30);
            System.out.println(s1.toString());
    }
}
