public class Visitor extends Person {
    //2 exclusive instance variables (ticket ID, VIP status)
    private String ticketId;
    private boolean isVip;

    // default constructor
    public Visitor() { super(); }

    // Constructor with parameters
    public Visitor(String name, int age, String contactNumber, String ticketId, boolean isVip) {
        super(name, age, contactNumber);
        this.ticketId = ticketId;
        this.isVip = isVip;
    }

    //Getter and Setter
    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }
    public boolean isVip() { return isVip; }
    public void setVip(boolean vip) { isVip = vip; }

    //Rewrite toString()
    @Override
    public String toString() {
        return "Visitor{" + super.toString() + ", ticketId='" + ticketId + "', isVip=" + isVip + "'}";
    }
}
