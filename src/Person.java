public class Person {
    //3 instance variables (name, age, contact information, in line with personnel general attributes)
    private String name;
    private int age;
    private String contactNumber;

    // default constructor
    public Person() {}

    // Constructor with parameters (initializes all instance variables)
    public Person(String name, int age, String contactNumber) {
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
    }

    // Getter and Setter (all variables must have them, encapsulation requirements)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    // Optional: Rewrite toString() for easy printing of object information (essential for subsequent debugging)
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", contactNumber='" + contactNumber + "'}";
    }
}