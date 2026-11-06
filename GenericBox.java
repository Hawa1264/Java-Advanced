/** Example 3: Generics: one class, many types */
public class GenericBox {

    static class Box<T> {
        private T item;
        public void set(T item) { this.item = item; }
        public T get() { return item; }
    }

    public static void main(String[] args) {
            Box<Integer> box1 = new Box<Integer>(); // only Integers
            box1.set(25);
            int age = box1.get(); // no cast needed

            Box<String> box2 = new Box<String>(); // only Strings
            box2.set("Ali");
            String name = box2.get();

            // box1.set("Ali"); // COMPILE ERROR: String is not an Integer
            System.out.println("box1 holds " + age);
            System.out.println("box2 holds " + name);
    }
}
