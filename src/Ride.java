import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

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
        this.waitingQueue = new LinkedList<>();    // 初始化队列
        this.rideHistory = new LinkedList<>();     // 初始化链表
    }

    // 参数化构造器 - 修复：添加 this();
    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this();
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
    // === Part 6: 文件导出方法 ===
    public void exportRideHistory(String filename) {
        System.out.println("\n === 开始导出历史记录到文件: " + filename + " ===");

        if (rideHistory.isEmpty()) {
            System.out.println(" 导出失败：历史记录为空，没有数据可导出");
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // 写入文件头（可选）
            writer.println("# " + rideName + " 历史记录导出");
            writer.println("# 导出时间: " + java.time.LocalDateTime.now());
            writer.println("# 总访客数: " + rideHistory.size());
            writer.println("# 格式: 姓名,年龄,邮箱,访客ID,票型");

            // 写入每个访客的数据
            for (Visitor visitor : rideHistory) {
                String line = String.format("%s,%d,%s,%s,%s",
                        visitor.getName(),
                        visitor.getAge(),
                        visitor.getEmail(),
                        visitor.getVisitorId(),
                        visitor.getTicketType());
                writer.println(line);
            }

            System.out.println(" 成功导出 " + rideHistory.size() + " 个访客记录到文件: " + filename);
            System.out.println(" 文件路径: " + new java.io.File(filename).getAbsolutePath());

        } catch (IOException e) {
            System.out.println(" 导出失败：文件写入错误 - " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(" 导出失败：发生未知错误 - " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println(" 文件导出完成 ===\n");
    }
    // === Part 7: 文件导入方法 ===
    public void importRideHistory(String filename) {
        System.out.println("\n === 开始从文件导入历史记录: " + filename + " ===");

        File file = new File(filename);
        if (!file.exists()) {
            System.out.println(" 导入失败：文件不存在 - " + filename);
            return;
        }

        if (!file.canRead()) {
            System.out.println(" 导入失败：文件无法读取 - " + filename);
            return;
        }

        int importedCount = 0;
        int skippedCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                // 跳过空行和注释行
                if (line.trim().isEmpty() || line.trim().startsWith("#")) {
                    continue;
                }

                // 解析CSV行
                try {
                    String[] parts = line.split(",");
                    if (parts.length == 5) {
                        String name = parts[0].trim();
                        int age = Integer.parseInt(parts[1].trim());
                        String email = parts[2].trim();
                        String visitorId = parts[3].trim();
                        String ticketType = parts[4].trim();

                        // 创建Visitor对象
                        Visitor visitor = new Visitor(name, age, email, visitorId, ticketType);

                        // 添加到历史记录（避免重复）
                        if (!rideHistory.contains(visitor)) {
                            rideHistory.add(visitor);
                            importedCount++;
                            System.out.println(" 导入访客: " + name + " (ID: " + visitorId + ")");
                        } else {
                            skippedCount++;
                            System.out.println(" 跳过重复访客: " + name);
                        }
                    } else {
                        System.out.println(" 第 " + lineNumber + " 行格式错误，跳过: " + line);
                        skippedCount++;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("  第 " + lineNumber + " 行年龄格式错误，跳过: " + line);
                    skippedCount++;
                } catch (Exception e) {
                    System.out.println("  第 " + lineNumber + " 行解析错误，跳过: " + line);
                    skippedCount++;
                }
            }

            System.out.println(" 文件导入完成");
            System.out.println(" 导入统计:");
            System.out.println("   - 成功导入: " + importedCount + " 个访客");
            System.out.println("   - 跳过记录: " + skippedCount + " 行");
            System.out.println("   - 历史记录总数: " + rideHistory.size() + " 个访客");

        } catch (IOException e) {
            System.out.println(" 导入失败：文件读取错误 - " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(" 导入失败：发生未知错误 - " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println(" 文件导入完成 ===\n");
    }
}
