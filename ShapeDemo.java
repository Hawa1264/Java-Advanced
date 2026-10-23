// Extra 1: Shapes and area (README section 6)

abstract class Shape {
    private String name;

    Shape(String name) { this.name = name; }

    abstract double area();                  // each shape knows its own formula

    void describe() {                        // shared
        System.out.println(name + " has area " + area());
    }
}

class Rectangle extends Shape {
    private double width, height;

    Rectangle(double w, double h) {
        super("Rectangle");
        width = w;
        height = h;
    }

    @Override
    double area() { return width * height; }
}

class Circle extends Shape {
    private double radius;

    Circle(double r) {
        super("Circle");
        radius = r;
    }

    @Override
    double area() { return Math.PI * radius * radius; }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Shape[] shapes = { new Rectangle(4, 5), new Circle(1) };
        for (Shape s : shapes) {
            s.describe();
        }
    }
}
