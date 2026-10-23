// Extra 2: Employees and pay (README section 6)

abstract class Employee {
    protected String name;

    Employee(String name) { this.name = name; }

    abstract double monthlyPay();

    void printPayslip() {
        System.out.println(name + ": $" + monthlyPay());
    }
}

class FullTimeEmployee extends Employee {
    private double salary;

    FullTimeEmployee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    double monthlyPay() { return salary / 12; }
}

class PartTimeEmployee extends Employee {
    private int hours;
    private double rate;

    PartTimeEmployee(String name, int hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double monthlyPay() { return hours * rate; }
}

public class EmployeePayDemo {
    public static void main(String[] args) {
        Employee a = new FullTimeEmployee("Amina", 36000);
        Employee h = new PartTimeEmployee("Hodan", 80, 15);
        a.printPayslip();   // Amina: $3000.0
        h.printPayslip();   // Hodan: $1200.0
    }
}
