public class Visitor extends Person {
    private String visitorId;
    private String ticketType;

    // 默认构造器
    public Visitor() {
        super();
        this.visitorId = "V000";
        this.ticketType = "General";
    }

    // 参数化构造器
    public Visitor(String name, int age, String email,
                   String visitorId, String ticketType) {
        super(name, age, email);
        this.visitorId = visitorId;
        this.ticketType = ticketType;
    }

    // Getter方法
    public String getVisitorId() {
        return visitorId;
    }

    public String getTicketType() {
        return ticketType;
    }

    // Setter方法
    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
}