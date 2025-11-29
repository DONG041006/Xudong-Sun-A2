public class AssignmentTwo {
    public static void main(String[] args) {
        //You can call various part methods here to test
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
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
    public void partFourA() {
        System.out.println("=== Part 4A Cycling History Function Demonstration ===");

        // 1. Create operator object (for associating rides)
        Employee waterRideOperator = new Employee(
                "Xiao Wang",
                28,
                "13900139006",
                "EMP003",
                "Water Ride"
        );

        // 2.
        Ride thunderstormRide = new Ride(
                "暴雨漂流",
                "Water Ride",
                waterRideOperator,
                6
        );

        // 3. Create 5 tourist objects
        Visitor visitor1 = new Visitor(
                "Paul",
                20,
                "13700137001",
                "TICKET006",
                false
        );
        Visitor visitor2 = new Visitor(
                "Sherly",
                24,
                "13700137002",
                "TICKET007",
                true
        );
        Visitor visitor3 = new Visitor(
                "Ben",
                27,
                "13700137003",
                "TICKET008",
                false
        );
        Visitor visitor4 = new Visitor(
                "David",
                32,
                "13700137004",
                "TICKET009",
                true
        );
        Visitor visitor5 = new Visitor(
                "Lisa",
                19,
                "13700137005",
                "TICKET010",
                false
        );
    }
    public void partFourB() {
        System.out.println("\n=== Part 4B Cycling History Sorting Demonstration ===");
        // 1.Create a Ride object
        Ride ferrisWheel = new Ride("Ferris wheel", "Family Ride", null, 8);
        // 2.Create 5 tourists (including VIP and different age groups)
        Visitor v1 = new Visitor("Alice", 22, "13600136001", "TICKET012", true);
        Visitor v2 = new Visitor("Bob", 18, "13600136002", "TICKET013", false);
        Visitor v3 = new Visitor("Charlie", 25, "13600136003", "TICKET014", true);
        Visitor v4 = new Visitor("Diana", 20, "13600136004", "TICKET015", false);
        Visitor v5 = new Visitor("Ethan", 28, "13600136005", "TICKET016", true);
        // 3. Add to History
        ferrisWheel.addVisitorToHistory(v1);
        ferrisWheel.addVisitorToHistory(v2);
        ferrisWheel.addVisitorToHistory(v3);
        ferrisWheel.addVisitorToHistory(v4);
        ferrisWheel.addVisitorToHistory(v5);
        // 4. Print before sorting
        System.out.println("\nCycling history before sorting：");
        ferrisWheel.printRideHistory();
        // 5. Call sorting method (using custom comparator)
        System.out.println("\nSort by Execution (VIP First → Age Ascending）：");
        ferrisWheel.sortRideHistory(new VisitorComparator());
        // 6. Sort and print
        System.out.println("\nSorted cycling history：");
        ferrisWheel.printRideHistory();
    }
    public void partFive() {
        System.out.println("\n=== Part 5: Run a cycling demonstration for one round ===");
        // 1. Create operator
        Employee operator = new Employee("Xiao Bai", 35, "13500135000", "EMP002", "Family Ride");
        // 2. Create a Ride object（maxRider=3）
        Ride carousel = new Ride("merry-go-round", "Family Ride", operator, 3);
        // 3. Add 10 tourists to the queue (meeting the minimum requirement of 10)
        for (int i = 1; i <= 10; i++) {
            Visitor visitor = new Visitor("tourist" + i, 10 + i, "1340013400" + i, "TICKET0" + (17 + i), i % 3 == 0);
            carousel.addVisitorToQueue(visitor);
        }
        // 4. Print pre run queue
        System.out.println("\nPre run queue (10 people)：");
        carousel.printQueue();
        // 5.Run one round
        carousel.runOneCycle();
        // 6. Print the queue after running (7 people remaining)
        System.out.println("\nPost run queue (7 people remaining)：");
        carousel.printQueue();
        // 7. 打印骑行历史（3人）
        System.out.println("\nCycling history of this round (3 people)：");
        carousel.printRideHistory();
    }
    public void partSix() {
        System.out.println("\n=== Part6 Export cycling history to file demonstration ===");
        // 1. Create a Ride object and add 5 tourists
        Ride rollerCoaster = new Ride("Extreme roller coaster", "Roller Coaster", null, 4);
        Visitor v1 = new Visitor("Emma", 23, "13300133001", "TICKET028", true);
        Visitor v2 = new Visitor("Liam", 26, "13300133002", "TICKET029", false);
        Visitor v3 = new Visitor("Olivia", 21, "13300133003", "TICKET030", true);
        Visitor v4 = new Visitor("Noah", 29, "13300133004", "TICKET031", false);
        Visitor v5 = new Visitor("Sophia", 24, "13300133005", "TICKET032", true);
        rollerCoaster.addVisitorToHistory(v1);
        rollerCoaster.addVisitorToHistory(v2);
        rollerCoaster.addVisitorToHistory(v3);
        rollerCoaster.addVisitorToHistory(v4);
        rollerCoaster.addVisitorToHistory(v5);
        // 2. Export to CSV file
        String filePath = "rideHistory.csv";
        rollerCoaster.exportRideHistory(filePath);
    }
    public void partSeven() {}

}