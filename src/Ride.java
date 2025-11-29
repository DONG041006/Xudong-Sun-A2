import java.util.Queue;
import java.util.LinkedList;

public class Ride {
    // 3 instance variables (name, type, operator (Employee type), maximum passenger capacity (to be used in Part 5 later, defined in advance)
    private String rideName;
    private String rideType; // 如"Roller Coaster"、"Water Ride"
    private Employee operator; // 必须是Employee类型，标识是否有操作员
    private int maxRider; // Part5要求：每轮最大载客量
    private int numOfCycles; // Part5要求：运行次数（默认0）

    // Waiting queue (Part 3 requirement: Queue<Visitor>)
    private Queue<Visitor> waitingLine;
    // Cycling history (Part 4A requirement: LinkedRist<Visitor>)
    private LinkedList<Visitor> rideHistory;

    // Default Constructor (Initialize Collection and Default Values)
    public Ride() {
        this.waitingLine = new LinkedList<>(); // Queue用LinkedList实现（FIFO）
        this.rideHistory = new LinkedList<>();
        this.numOfCycles = 0; // 默认运行0次
    }

    // Constructor with parameters (initializes all variables)
    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this(); // Call the default constructor to initialize the collection
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.maxRider = maxRider;
    }

    // Getter and Setter (all variables)
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

    // Rewrite toString()
    @Override
    public String toString() {
        return "Ride{name='" + rideName + "', type='" + rideType + "', operator=" + operator + ", maxRider=" + maxRider + ", cycles=" + numOfCycles + "}";
    }
}