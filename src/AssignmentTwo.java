public class AssignmentTwo {
    public static void main(String[] args) {
        System.out.println("主题公园管理系统启动...");

        // 测试基础类是否正常工作
        testBasicClasses();
    // 测试Part 2接口功能
    testInterfaceImplementation();
    // 测试Part 3队列功能
    partThree();
        // 测试Part 4A历史记录功能
        partFourA();
        // 测试Part 4B排序功能
        partFourB();
        // 测试Part 5运行周期功能
        partFive();
        // 测试Part 6文件写入功能
        partSix();
}
    // 测试基础类的方法
    public static void testBasicClasses() {
        System.out.println("=== 测试基础类 ===");

        // 测试Employee类
        Employee emp1 = new Employee("张三", 28, "zhang@park.com", "EMP001", "游乐设施部");
        System.out.println("员工: " + emp1.getName() + ", 部门: " + emp1.getDepartment());

        // 测试Visitor类
        Visitor vis1 = new Visitor("李四", 25, "li@email.com", "VIS001", "日票");
        System.out.println("访客: " + vis1.getName() + ", 票型: " + vis1.getTicketType());

        // 测试Ride类
        Ride ride1 = new Ride("雷霆过山车", "过山车", emp1,2);
        System.out.println("设施: " + ride1.getRideName() + ", 操作员: " + ride1.getOperator().getName());

        System.out.println("=== 基础类测试完成 ===");
    }
    // 测试接口实现
    public static void testInterfaceImplementation() {
        System.out.println("=== 测试Part 2接口实现 ===");

        // 创建员工和游乐设施
        Employee operator = new Employee("王操作员", 30, "wang@park.com", "EMP002", "运营部");
        Ride rollerCoaster = new Ride("极速飞车", "过山车", operator,2);

        // 创建访客
        Visitor visitor1 = new Visitor("测试访客1", 20, "test1@email.com", "TEST001", "日票");

        // 测试接口方法（目前只是占位符）
        System.out.println("测试接口方法调用:");
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.runOneCycle();

        System.out.println("=== 接口测试完成 ===\n");
    }

    // === Part 3 演示方法 ===
    public static void partThree() {
        System.out.println(" === Part 3 队列功能演示 ===");

        // 创建员工和游乐设施
        Employee operator = new Employee("赵操作员", 32, "zhao@park.com", "EMP003", "过山车部");
        Ride rollerCoaster = new Ride("疯狂过山车", "过山车", operator, 2);

        // 创建5个访客
        Visitor visitor1 = new Visitor("张三", 22, "zhang@email.com", "V001", "日票");
        Visitor visitor2 = new Visitor("李四", 25, "li@email.com", "V002", "季票");
        Visitor visitor3 = new Visitor("王五", 30, "wang@email.com", "V003", "日票");
        Visitor visitor4 = new Visitor("赵六", 18, "zhao@email.com", "V004", "学生票");
        Visitor visitor5 = new Visitor("钱七", 35, "qian@email.com", "V005", "VIP票");

        System.out.println("1. 添加5个访客到队列:");
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        System.out.println("\n2. 打印当前队列:");
        rollerCoaster.printQueue();

        System.out.println("\n3. 移除一个访客:");
        rollerCoaster.removeVisitorFromQueue();

        System.out.println("\n4. 打印移除后的队列:");
        rollerCoaster.printQueue();

        System.out.println("=== Part 3 演示完成 ===\n");
    }

    // === Part 4A 演示方法 ===
    public static void partFourA() {
        System.out.println("📋 === Part 4A 历史记录功能演示 ===");

        // 创建员工和游乐设施
        Employee operator = new Employee("孙操作员", 29, "sun@park.com", "EMP004", "水上设施部");
        Ride waterRide = new Ride("激流勇进", "水上设施", operator, 4);

        // 创建5个访客
        Visitor visitor1 = new Visitor("刘一", 20, "liu@email.com", "V101", "日票");
        Visitor visitor2 = new Visitor("陈二", 22, "chen@email.com", "V102", "季票");
        Visitor visitor3 = new Visitor("张三", 25, "zhang3@email.com", "V103", "日票");
        Visitor visitor4 = new Visitor("李四", 19, "li4@email.com", "V104", "学生票");
        Visitor visitor5 = new Visitor("王五", 30, "wang5@email.com", "V105", "VIP票");

        System.out.println("1. 添加5个访客到历史记录:");
        waterRide.addVisitorToHistory(visitor1);
        waterRide.addVisitorToHistory(visitor2);
        waterRide.addVisitorToHistory(visitor3);
        waterRide.addVisitorToHistory(visitor4);
        waterRide.addVisitorToHistory(visitor5);

        System.out.println("\n2. 检查访客是否在历史记录中:");
        waterRide.checkVisitorFromHistory(visitor3);  // 应该在
        waterRide.checkVisitorFromHistory(new Visitor("不存在的访客", 0, "none@email.com", "V999", "日票"));  // 应该不在

        System.out.println("\n3. 打印历史记录中的访客数量:");
        waterRide.numberOfVisitors();

        System.out.println("\n4. 打印完整的历史记录（使用Iterator）:");
        waterRide.printRideHistory();

        System.out.println("=== Part 4A 演示完成 ===\n");
    }

    // === Part 4B 演示方法 ===
    public static void partFourB() {
        System.out.println("🔢 === Part 4B 排序功能演示 ===");

        // 创建员工和游乐设施
        Employee operator = new Employee("周操作员", 27, "zhou@park.com", "EMP005", "旋转设施部");
        Ride ferrisWheel = new Ride("摩天轮", "观景设施", operator, 6);

        // 创建5个访客
        Visitor visitor1 = new Visitor("王五", 30, "wang5@email.com", "V201", "VIP票");
        Visitor visitor2 = new Visitor("张三", 25, "zhang3@email.com", "V202", "日票");
        Visitor visitor3 = new Visitor("李四", 19, "li4@email.com", "V203", "学生票");
        Visitor visitor4 = new Visitor("陈二", 22, "chen2@email.com", "V204", "季票");
        Visitor visitor5 = new Visitor("刘一", 20, "liu1@email.com", "V205", "日票");

        System.out.println("1. 添加5个访客到历史记录:");
        ferrisWheel.addVisitorToHistory(visitor1);
        ferrisWheel.addVisitorToHistory(visitor2);
        ferrisWheel.addVisitorToHistory(visitor3);
        ferrisWheel.addVisitorToHistory(visitor4);
        ferrisWheel.addVisitorToHistory(visitor5);

        System.out.println("\n2. 打印排序前的历史记录:");
        ferrisWheel.printRideHistory();

        System.out.println("\n3. 对历史记录进行排序:");
        ferrisWheel.sortRideHistory();

        System.out.println("\n4. 打印排序后的历史记录:");
        ferrisWheel.printRideHistory();

        System.out.println("=== Part 4B 演示完成 ===\n");
    }
    // === Part 5 演示方法 ===
    public static void partFive() {
        System.out.println(" === Part 5 运行游乐设施周期演示 ===");

        // 创建员工和游乐设施（maxRider = 3）
        Employee operator = new Employee("吴操作员", 31, "wu@park.com", "EMP006", "过山车部");
        Ride rollerCoaster = new Ride("超级过山车", "过山车", operator, 3);

        // 创建10个访客
        System.out.println("1. 创建10个访客并添加到等待队列:");
        for (int i = 1; i <= 10; i++) {
            Visitor visitor = new Visitor("访客" + i, 20 + i, "visitor" + i + "@email.com",
                    "V" + (300 + i), i % 2 == 0 ? "日票" : "季票");
            rollerCoaster.addVisitorToQueue(visitor);
        }

        System.out.println("\n2. 打印运行前的等待队列:");
        rollerCoaster.printQueue();

        System.out.println("\n3. 运行第一个周期（maxRider = 3）:");
        rollerCoaster.runOneCycle();

        System.out.println("\n4. 打印运行后的等待队列:");
        rollerCoaster.printQueue();

        System.out.println("\n5. 打印历史记录（刚刚乘坐的3个访客）:");
        rollerCoaster.printRideHistory();

        System.out.println("\n6. 运行第二个周期:");
        rollerCoaster.runOneCycle();

        System.out.println("\n7. 打印第二次运行后的等待队列:");
        rollerCoaster.printQueue();

        System.out.println("\n8. 打印完整的历史记录（总共6个访客）:");
        rollerCoaster.printRideHistory();

        System.out.println("\n9. 测试无操作员情况:");
        Ride noOperatorRide = new Ride("无人设施", "测试设施", null, 2);
        noOperatorRide.runOneCycle();

        System.out.println("\n10. 测试空队列情况:");
        Ride emptyRide = new Ride("空队列设施", "测试设施", operator, 2);
        emptyRide.runOneCycle();

        System.out.println("=== Part 5 演示完成 ===\n");
    }
    // === Part 6 演示方法 ===
    public static void partSix() {
        System.out.println("=== Part 6 文件写入功能演示 ===");

        // 创建员工和游乐设施
        Employee operator = new Employee("郑操作员", 33, "zheng@park.com", "EMP007", "过山车部");
        Ride rollerCoaster = new Ride("云霄飞车", "过山车", operator, 4);

        // 创建5个访客并添加到历史记录
        System.out.println("1. 创建5个访客并添加到历史记录:");
        Visitor visitor1 = new Visitor("导出访客1", 21, "export1@email.com", "EX001", "日票");
        Visitor visitor2 = new Visitor("导出访客2", 24, "export2@email.com", "EX002", "季票");
        Visitor visitor3 = new Visitor("导出访客3", 27, "export3@email.com", "EX003", "VIP票");
        Visitor visitor4 = new Visitor("导出访客4", 19, "export4@email.com", "EX004", "学生票");
        Visitor visitor5 = new Visitor("导出访客5", 32, "export5@email.com", "EX005", "日票");

        rollerCoaster.addVisitorToHistory(visitor1);
        rollerCoaster.addVisitorToHistory(visitor2);
        rollerCoaster.addVisitorToHistory(visitor3);
        rollerCoaster.addVisitorToHistory(visitor4);
        rollerCoaster.addVisitorToHistory(visitor5);

        System.out.println("\n2. 打印历史记录内容:");
        rollerCoaster.printRideHistory();

        System.out.println("\n3. 导出历史记录到文件:");
        String filename = "ride_history_export.csv";
        rollerCoaster.exportRideHistory(filename);

        System.out.println("\n4. 测试空历史记录导出:");
        Ride emptyRide = new Ride("空设施", "测试设施", operator, 2);
        emptyRide.exportRideHistory("empty_history.csv");

        System.out.println("=== Part 6 演示完成 ===\n");
    }

    // 后续部分的占位符方法
    public void partSeven() {}
}