//6.Write a program to implement MVC Design Pattern for Employee object
// Model: Employee class
class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

// View: EmployeeView class
class EmployeeView {
    public void displayEmployeeDetails(String name, int salary) {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("Salary: Rs." + salary + "/-");
    }
}

// Controller: EmployeeController class
class EmployeeController {
    private Employee model;
    private EmployeeView view;

    public EmployeeController(Employee model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }

    public void setEmployeeName(String name) {
        model.setName(name);
    }

    public String getEmployeeName() {
        return model.getName();
    }

    public void setEmployeeSalary(int salary) {
        model.setSalary(salary);
    }

    public int getEmployeeSalary() {
        return model.getSalary();
    }

    public void updateView() {
        view.displayEmployeeDetails(model.getName(), model.getSalary());
    }
}

public class Lab6MVCDesignPatternEmployee {
    public static void main(String[] args) {
        // Create an Employee object
        Employee employee = new Employee("Nischal Shrestha", 5000);

        // Create the corresponding view
        EmployeeView employeeView = new EmployeeView();

        // Create the controller and associate the model and view
        EmployeeController employeeController = new EmployeeController(employee, employeeView);

        // Update the model
        employeeController.setEmployeeName("Nischal Shrestha");
        employeeController.setEmployeeSalary(4000);

        // Update the view
        employeeController.updateView();
    }
}
