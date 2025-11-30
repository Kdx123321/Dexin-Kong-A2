import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private Employee operator;
    private int maxRider;
    private int numOfCycles;
    // Part 3: 添加队列集合
    private Queue<Visitor> waitingQueue;
    private LinkedList<Visitor> rideHistory;
    // 默认构造器
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "General";
        this.operator = null;
        this.maxRider = 1;
        this.numOfCycles = 0;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // 参数化构造器
    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.maxRider = maxRider;
    }

    // Getter方法
    public String getRideName() {
        return rideName;
    }

    public String getRideType() {
        return rideType;
    }

    public Employee getOperator() {
        return operator;
    }
    public int getMaxRider() {
        return maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }
    // Setter方法
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }
    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }
    // === Part 3: 队列方法实现 ===
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingQueue.add(visitor);
            System.out.println(" 成功将访客 " + visitor.getName() + " 添加到等待队列");
        } else {
            System.out.println(" 添加失败：访客对象为空");
        }
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        Visitor visitor = waitingQueue.poll();
        if (visitor != null) {
            System.out.println(" 成功从队列移除访客: " + visitor.getName());
        } else {
            System.out.println(" 队列为空，无法移除访客");
        }
        return visitor;
    }

    @Override
    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println(" 等待队列为空");
            return;
        }

        System.out.println("=== " + rideName + " 等待队列 ===");
        int position = 1;
        for (Visitor visitor : waitingQueue) {
            System.out.println(position + ". " + visitor.getName() +
                    " (ID: " + visitor.getVisitorId() +
                    ", 票型: " + visitor.getTicketType() + ")");
            position++;
        }
        System.out.println("总计: " + waitingQueue.size() + " 人在等待");
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        System.out.println("addVisitorToHistory方法待实现");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        System.out.println("checkVisitorFromHistory方法待实现");
        return false;
    }

    @Override
    public int numberOfVisitors() {
        System.out.println("numberOfVisitors方法待实现");
        return 0;
    }

    @Override
    public void printRideHistory() {
        System.out.println("printRideHistory方法待实现");
    }

    @Override
    public void runOneCycle() {
        System.out.println("runOneCycle方法待实现");
    }
}


