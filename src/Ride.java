import java.util.Queue;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ride implements RideInterface {
    // 3 instance variables (name, type, operator (Employee type), maximum passenger capacity (to be used in Part 5 later, defined in advance)
    private String rideName;
    private String rideType;
    private Employee operator;
    private int maxRider; // Requirement 5: Maximum passenger capacity per round
    private int numOfCycles; // Requirement for Part 5: Number of runs (default 0)

    // Waiting queue (Part 3 requirement: Queue<Visitor>)
    private Queue<Visitor> waitingLine;
    // Cycling history (Part 4A requirement: LinkedRist<Visitor>)
    private LinkedList<Visitor> rideHistory;

    //Default Constructor (Initialize Collection and Default Values)
    public Ride() {
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.numOfCycles = 0;
    }

    // Constructor with parameters (initializes all variables)
    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this(); // Call the default constructor to initialize the collection
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.maxRider = maxRider;
    }

    // Getter和Setter（所有变量）
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public String getRideType() { return rideType; }
    public void setRideType(String rideType) { this.rideType = rideType; }
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) { this.maxRider = maxRider; }
    public int getNumOfCycles() { return numOfCycles; }
    public void setNumOfCycles(int numOfCycles) { this.numOfCycles = numOfCycles; }
    public Queue<Visitor> getWaitingLine() { return waitingLine; }
    public LinkedList<Visitor> getRideHistory() { return rideHistory; }
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.add(visitor);
            System.out.println("Successfully added tourist" + visitor.getName() + "to" + rideName + "queue");
        } else {
            System.out.println("Error: The tourist object is empty and cannot be added to the queue");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!waitingLine.isEmpty()) {
            Visitor removed = waitingLine.poll();
            System.out.println("Successfully removed the first tourist from the queue：" + removed.getName());
        } else {
            System.out.println("error：" + rideName + "The queue is empty, unable to remove tourists");
        }
    }

    @Override
    public void printQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println(rideName + "There are currently no waiting tourists");
            return;
        }
        System.out.println(rideName + "waiting queue：");
        int index = 1;
        for (Visitor visitor : waitingLine) {
            System.out.println(index + ". " + visitor);
            index++;
        }
    }

    // -------------------------- Implementation of Part 4 Interface Method --------------------------
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("Successfully added tourist" + visitor.getName() + "to" + rideName + "history");
        } else {
            System.out.println("Error: The tourist object is empty and cannot be added to the history");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Tourist object is empty, unable to query");
            return false;
        }
        // Search by ticket ID (uniquely identify tourist)
        for (Visitor v : rideHistory) {
            if (v.getTicketId().equals(visitor.getTicketId())) {
                System.out.println("Query result: Tourists" + visitor.getName() + "have traveled before" + rideName);
                return true;
            }
        }
        System.out.println("Query result: Tourists" + visitor.getName() + "Never ridden before" + rideName);
        return false;
    }

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println(rideName + "Accumulated number of passengers：" + count);
        return count;
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println(rideName + "No ride history available at the moment");
            return;
        }
        System.out.println(rideName + "Riding history（together" + rideHistory.size() + "person）：");

        java.util.Iterator<Visitor> iterator = rideHistory.iterator();
        int index = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(index + ". " + visitor);
            index++;
        }
    }

    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (comparator == null) {
            System.out.println("Error: Sorter is empty, unable to sort");
            return;
        }
        if (rideHistory.isEmpty()) {
            System.out.println(rideName + "No cycling history available, no sorting required");
            return;
        }
        Collections.sort(rideHistory, comparator);
        System.out.println(rideName + "Cycling history sorting completed");
    }

    // -------------------------- Part5Interface method implementation --------------------------
    @Override
    public void runOneCycle() {
        System.out.println("\n=== execute" + rideName + "One cycle of cycling ===");
        // 1. Verify if there is an operator present
        if (operator == null) {
            System.out.println("error：" + rideName + "Unallocated operator, unable to run");
            return;
        }
        // 2. Verify if the queue is empty
        if (waitingLine.isEmpty()) {
            System.out.println("error：" + rideName + "No waiting tourists, unable to operate");
            return;
        }
        // 3. Calculate the number of passengers that can be carried in this round
        int ridersThisCycle = Math.min(maxRider, waitingLine.size());
        System.out.println("The number of people that can be carried in this round：" + ridersThisCycle);
        // 4. Remove tourists from the queue and add them to the history
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor rider = waitingLine.poll();
            addVisitorToHistory(rider);
        }
        // 5. Update the number of runs
        numOfCycles++;
        System.out.println("Successfully run" + rideName + "No." + numOfCycles + "wheel");
    }
    public void exportRideHistory(String filePath) {
        if (rideHistory.isEmpty()) {
            System.out.println(rideName + "No cycling history available, no need to export");
            return;
        }
        // exception handling
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // write header
            writer.write("Name, age, contact information, ticket ID, VIP status");
            writer.newLine();
            // Write data for each tourist
            for (Visitor visitor : rideHistory) {
                String line = String.format("%s,%d,%s,%s,%b",
                        visitor.getName(),
                        visitor.getAge(),
                        visitor.getContactNumber(),
                        visitor.getTicketId(),
                        visitor.isVip()
                );
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Successfully exported" + rideName + "Cycling history to：" + filePath);
        } catch (IOException e) {
            System.err.println("Error: Exporting file failed! Reason:" + e.getMessage());
        }
    }
    public void importRideHistory(String filePath) {
        // exception handling
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true; // 跳过表头
            int importedCount = 0;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                // Split CSV fields
                String[] fields = line.split(",");
                if (fields.length != 5) {
                    System.out.println("Warning: Skip invalid data rows：" + line);
                    continue;
                }
                // parse field
                String name = fields[0];
                int age = Integer.parseInt(fields[1]);
                String contact = fields[2];
                String ticketId = fields[3];
                boolean isVip = Boolean.parseBoolean(fields[4]);
                // Create tourist objects and add them to history
                Visitor visitor = new Visitor(name, age, contact, ticketId, isVip);
                addVisitorToHistory(visitor);
                importedCount++;
            }
            System.out.println("Successfully imported" + importedCount + "Cycling history data");
        } catch (IOException e) {
            System.err.println("Error: Import file failed! Reason:" + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error: Data format error (age must be a number)! Reason:" + e.getMessage());
        }
    }
    // Rewrite toString()
    @Override
    public String toString() {
        return "Ride{name='" + rideName + "', type='" + rideType + "', operator=" + operator + ", maxRider=" + maxRider + ", cycles=" + numOfCycles + "}";
    }
}