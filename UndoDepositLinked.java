import java.util.EmptyStackException;

/** Example 14: Bank example with LinkedStack */
public class UndoDepositLinked {

    static class Node<T> {
        private T element;
        private Node<T> next;

        public Node() { element = null; next = null; }
        public Node(T element) { this.element = element; next = null; }

        public Node<T> getNext() { return next; }
        public void setNext(Node<T> next) { this.next = next; }
        public T getElement() { return element; }
        public void setElement(T element) { this.element = element; }
    }

    static class LinkedStack<T> {
        private int count;
        private Node<T> top;

        public LinkedStack() {
            count = 0;
            top = null;
        }

        public void push(T element) {
            Node<T> temp = new Node<>(element); // 1. new node
            temp.setNext(top);                  // 2. link it to old top FIRST
            top = temp;                         // 3. then move top
            count++;
        }

        public T pop() throws EmptyStackException {
            if (isEmpty())
                throw new EmptyStackException();
            T result = top.getElement();
            top = top.getNext(); // old top is now unreferenced
            count--;
            return result;
        }

        public T peek() throws EmptyStackException {
            if (isEmpty())
                throw new EmptyStackException();
            return top.getElement();
        }

        public boolean isEmpty() { return count == 0; }
        public int size() { return count; }
    }

    static class BankAccount {
        private double balance;
        // the only change: LinkedStack instead of Stack
        private LinkedStack<Double> history = new LinkedStack<>();

        public BankAccount(double balance) { this.balance = balance; }

        public void deposit(double amount) {
            balance = balance + amount;
            history.push(amount);
            System.out.println("Deposit " + amount + " -> balance " + balance);
        }

        public void undoLastDeposit() {
            if (history.isEmpty()) {
                System.out.println("Nothing to undo");
                return;
            }
            double last = history.pop();
            balance = balance - last;
            System.out.println("Undo " + last + " -> balance " + balance);
        }
    }

    public static void main(String[] args) {
            BankAccount acc = new BankAccount(100);
            acc.deposit(50);
            acc.deposit(20);
            acc.deposit(30);
            acc.undoLastDeposit();
            acc.undoLastDeposit();
    }
}
