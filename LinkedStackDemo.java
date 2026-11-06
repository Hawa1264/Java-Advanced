import java.util.EmptyStackException;

/** Example 12: Node and LinkedStack: full implementation */
public class LinkedStackDemo {

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

    public static void main(String[] args) {
            // Full implementation is Node and LinkedStack above; quick sanity check:
            LinkedStack<Integer> s = new LinkedStack<>();
            s.push(1);
            s.push(2);
            s.push(3);
            System.out.println("peek: " + s.peek() + ", size: " + s.size()
                    + ", isEmpty: " + s.isEmpty());
    }
}
