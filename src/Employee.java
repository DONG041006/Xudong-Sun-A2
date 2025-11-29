public class Employee extends Person {
    // 2 exclusive instance variables (employee ID, responsible ride type)
    private String employeeId;
    private String responsibleRideType;

    // Default constructor (requires calling the parent class's default constructor)
    public Employee() {
        super(); // Optional, compiler automatically calls implicitly
    }

    // Constructor with parameters (initializes parent class+subclass variables)
    public Employee(String name, int age, String contactNumber, String employeeId, String responsibleRideType) {
        super(name, age, contactNumber); // Call the parent class constructor with parameters
        this.employeeId = employeeId;
        this.responsibleRideType = responsibleRideType;
    }

    // Getter and Setter (specific to subclass variables)
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getResponsibleRideType() { return responsibleRideType; }
    public void setResponsibleRideType(String responsibleRideType) { this.responsibleRideType = responsibleRideType; }

    // Rewrite toString() to include parent class information
    @Override
    public String toString() {
        return "Employee{" + super.toString() + ", employeeId='" + employeeId + "', responsibleRideType='" + responsibleRideType + "'}";
    }
}
