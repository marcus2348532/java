import java.util.Scanner;

class Employee {
    int emp_id;
    String emp_name, emp_designation;

    Employee(int e_id, String e_name, String e_des) {
        emp_id = e_id;
        emp_name = e_name;
        emp_designation = e_des;
    }

    public void calculateBonus() {
        // Your existing code here
    }
}

class HourlyEmployee extends Employee {
    double w_earnings = 0;

    HourlyEmployee(int e_id, String e_name, String e_des) {
        super(e_id, e_name, e_des);
    }

    public void cal1(double hourlyRate, int hoursWorked) {
        w_earnings = hourlyRate * hoursWorked;
        System.out.println("Employee ID:  " + emp_id);
        System.out.println("Employee Name:  " + emp_name);
        System.out.println("Employee Designation:  " + emp_designation);
        System.out.println("Weekly earnings:  " + w_earnings);
    }
}

class SalariedEmployee extends Employee {
    double monthlySalary;
    double w_salary;

    SalariedEmployee(int e_id, String e_name, String e_des) {
        super(e_id, e_name, e_des);
    }

    public void cal2(double monthlySalary) {
        w_salary = monthlySalary / 4;
        System.out.println("Employee ID:  " + emp_id);
        System.out.println("Employee Name:  " + emp_name);
        System.out.println("Employee Designation:  " + emp_designation);
        System.out.println("Weekly earnings:  " + w_salary);
    }
}

class ExecutiveEmployee extends Employee {
    double bonusPercentage;

    ExecutiveEmployee(int e_id, String e_name, String e_des) {
        super(e_id, e_name, e_des);
    }

    public void calculateBonus(double monthlySalary) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Bonus Percentage: ");
        bonusPercentage = scanner.nextDouble();
        double m_bonus = (monthlySalary * (bonusPercentage / 100));
        System.out.println("Employee Monthly Salary: " + monthlySalary);
        System.out.println("Bonus Percentage: " + bonusPercentage);
        System.out.println("Monthly Bonus: " + m_bonus);
    }
}

class Payroll {
    public static void main(String[] args) {
        double w_e;
        Scanner scanner = new Scanner(System.in);

        System.out.println("ENTER ID OF EMPLOYEE: ");
        int e_id = scanner.nextInt();

        System.out.println("ENTER NAME OF EMPLOYEE: ");
        String e_name = scanner.next(); // Use next() for reading strings

        System.out.println("ENTER DESIGNATION OF EMPLOYEE: ");
        String e_des = scanner.next(); // Use next() for reading strings

        System.out.println("ENTER HOURLY RATE OF EMPLOYEE: ");
        double hourlyRate = scanner.nextDouble();

        System.out.println("ENTER WORKING HOURS OF EMPLOYEE: ");
        int hoursWorked = scanner.nextInt();

        System.out.println("ENTER MONTHLY SALARY OF EMPLOYEE: ");
        double monthlySalary = scanner.nextDouble();

        HourlyEmployee b = new HourlyEmployee(e_id, e_name, e_des);
        b.cal1(hourlyRate, hoursWorked);

        SalariedEmployee c = new SalariedEmployee(e_id, e_name, e_des);
        c.cal2(monthlySalary);

        ExecutiveEmployee v = new ExecutiveEmployee(e_id, e_name, e_des);
        v.calculateBonus(monthlySalary);
    }
}