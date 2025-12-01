package AssignmentTwo;

public class Visitor extends Person {
    private String ticketNumber;
    private String membershipType;

    public Visitor() {}
    public Visitor(String name, int age, String address, String ticketNumber, String membershipType) {
        super(name, age, address);
        this.ticketNumber = ticketNumber;
        this.membershipType = membershipType;
    }

    public String getTicketNumber() { return ticketNumber; }
    public void setTicketNumber(String ticketNumber) { this.ticketNumber = ticketNumber; }
    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String membershipType) { this.membershipType = membershipType; }
}