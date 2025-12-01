import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

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

    // === Part 4A: 历史记录方法实现 ===
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            if (!rideHistory.contains(visitor)) {
                rideHistory.add(visitor);
                System.out.println("✅ 成功将访客 " + visitor.getName() + " 添加到游乐设施历史记录");
            } else {
                System.out.println("ℹ️  访客 " + visitor.getName() + " 已在历史记录中");
            }
        } else {
            System.out.println("❌ 添加失败：访客对象为空");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor != null) {
            boolean exists = rideHistory.contains(visitor);
            if (exists) {
                System.out.println("✅ 访客 " + visitor.getName() + " 在历史记录中");
            } else {
                System.out.println("❌ 访客 " + visitor.getName() + " 不在历史记录中");
            }
            return exists;
        } else {
            System.out.println("❌ 检查失败：访客对象为空");
            return false;
        }
    }

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("📊 历史记录中总共有 " + count + " 个访客");
        return count;
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("📝 游乐设施历史记录为空");
            return;
        }

        System.out.println("=== 📋 " + rideName + " 游乐设施历史记录 ===");
        Iterator<Visitor> iterator = rideHistory.iterator();  // 使用Iterator
        int position = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(position + ". " + visitor.getName() +
                    " (ID: " + visitor.getVisitorId() +
                    ", 年龄: " + visitor.getAge() +
                    ", 票型: " + visitor.getTicketType() + ")");
            position++;
        }
        System.out.println("总计: " + rideHistory.size() + " 个访客体验过此设施");
    }

    @Override
    public void runOneCycle() {
        System.out.println("runOneCycle方法待实现");
    }
}


