import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Collections;

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
    // === Part 4B: 排序方法 ===
    public void sortRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println(" 历史记录为空，无需排序");
            return;
        }

        System.out.println(" 正在对历史记录进行排序...");
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println(" 历史记录排序完成");
    }
    // === Part 5: 运行游乐设施周期 ===
    @Override
    public void runOneCycle() {
        System.out.println("\n === 开始运行 " + rideName + " 的一个周期 ===");

        // 检查是否有操作员
        if (operator == null) {
            System.out.println(" 运行失败：没有分配操作员！");
            return;
        }

        // 检查等待队列是否为空
        if (waitingQueue.isEmpty()) {
            System.out.println(" 运行失败：等待队列为空，没有访客可以乘坐！");
            return;
        }

        // 计算本次可以乘坐的访客数量
        int ridersThisCycle = Math.min(maxRider, waitingQueue.size());
        System.out.println(" 本次周期可以乘坐 " + ridersThisCycle + " 个访客");

        // 从队列中移除访客并添加到历史记录
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor rider = waitingQueue.poll();
            if (rider != null) {
                rideHistory.add(rider);
                System.out.println(" 访客 " + rider.getName() + " 已完成乘坐并添加到历史记录");
            }
        }

        // 更新周期计数
        numOfCycles++;
        System.out.println(" 周期计数更新：第 " + numOfCycles + " 次运行完成");

        // 显示剩余等待人数
        System.out.println(" 剩余等待访客：" + waitingQueue.size() + " 人");
        System.out.println(" " + rideName + " 周期运行完成 ===\n");
    }
}