public class AssignmentTwo {
    public static void main(String[] args) {
        System.out.println("主题公园管理系统启动...");

        // 测试基础类是否正常工作
        testBasicClasses();
    // 测试Part 2接口功能
    testInterfaceImplementation();

    // 测试Part 3队列功能
    partThree();
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

    // 后续部分的占位符方法
    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}