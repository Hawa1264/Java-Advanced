/** Example 10: Linked list: traverse the chain */
public class TraverseLinkedList {

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

    public static void main(String[] args) {
            // Build: head -> 17 -> 92 -> 63 -> 45 -> null
            Node<Integer> head = new Node<>(17);
            Node<Integer> n2 = new Node<>(92);
            Node<Integer> n3 = new Node<>(63);
            Node<Integer> n4 = new Node<>(45);
            head.setNext(n2);
            n2.setNext(n3);
            n3.setNext(n4); // n4.next stays null = end of list

            Node<Integer> current = head;
            while (current != null) {
                System.out.println(current.getElement());
                current = current.getNext();
            }
    }
}
