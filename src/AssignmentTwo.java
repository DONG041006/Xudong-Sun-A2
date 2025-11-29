public class AssignmentTwo {
    public static void main(String[] args) {
        //You can call various part methods here to test
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        // assignment.partFourA();
        // assignment.partFourB();
        // assignment.partFive();
        // assignment.partSix();
        // assignment.partSeven();
    }

    // Part 3 Demonstration Method
    public void partThree() {
        System.out.println("=== Part 3 Waiting Queue Demonstration ===");
        // 1. Create an Operator (Employee object)
        Employee operator = new Employee("Xiao Li", 30, "13800138000", "EMP001", "Roller Coaster");
        // 2. Create a Ride object
        Ride rollerCoaster = new Ride("Thunder roller coaster", "Roller Coaster", operator, 4);
        // 3. Create 5 tourists (meet the minimum requirement of 5)
        Visitor v1 = new Visitor("Jack", 25, "13900139001", "TICKET001", true);
        Visitor v2 = new Visitor("Sharon", 22, "13900139002", "TICKET002", false);
        Visitor v3 = new Visitor("Benny", 30, "13900139003", "TICKET003", true);
        Visitor v4 = new Visitor("Leo", 18, "13900139004", "TICKET004", false);
        Visitor v5 = new Visitor("Lucy", 28, "13900139005", "TICKET005", true);
        // 4. Add tourists to the queue
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);
        // 5.Print queue
        System.out.println("\nQueue after adding 5 tourists：");
        rollerCoaster.printQueue();
        // 6. Remove 1 tourist
        System.out.println("\nRemove the first tourist from the queue：");
        rollerCoaster.removeVisitorFromQueue();
        // 7. Print queue again
        System.out.println("\nRemoved queue：");
        rollerCoaster.printQueue();
    }

    // Other part methods occupy space (gradually implemented in the future)
    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}