import java.util.Arrays;
import java.util.EmptyStackException;

/** Example 8: ArrayStack trace: the array grows, then runs out */
public class ArrayStackTrace {

    static class ArrayStack<T> {
        private final static int DEFAULT_CAPACITY = 2; // constant
        private int top;                               // next free slot = number of elements
        private T[] stack;

        public ArrayStack() { this(DEFAULT_CAPACITY); }

        @SuppressWarnings("unchecked")
        public ArrayStack(int initialCapacity) {
            top = 0;
            stack = (T[]) (new Object[initialCapacity]); // generic array trick
        }

        public void push(T element) {
            if (size() == stack.length)
                expandCapacity(); // full? double the array
            stack[top] = element;
            top++;
        }

        private void expandCapacity() {
            stack = Arrays.copyOf(stack, stack.length * 2);
        }

        public T pop() throws EmptyStackException {
            if (isEmpty())
                throw new EmptyStackException(); // underflow
            top--;
            T result = stack[top];
            stack[top] = null;
            return result;
        }

        public T peek() throws EmptyStackException {
            if (isEmpty())
                throw new EmptyStackException();
            return stack[top - 1]; // look only, do not remove
        }

        public int size() { return top; }
        public boolean isEmpty() { return top == 0; }
        public int capacity() { return stack.length; } // added for the trace
    }

    public static void main(String[] args) {
        ArrayStack<String> s = new ArrayStack<>();
        s.push("A");
        s.push("B");
        System.out.println("size " + s.size() + ", capacity " + s.capacity());
        s.push("C"); // array full -> doubles to 4
        System.out.println("size " + s.size() + ", capacity " + s.capacity());
        System.out.println("peek: " + s.peek());
        System.out.println("pop:  " + s.pop());
        System.out.println("pop:  " + s.pop());
        System.out.println("pop:  " + s.pop());
        System.out.println("pop:  " + s.pop()); // stack empty -> underflow
    }
}
