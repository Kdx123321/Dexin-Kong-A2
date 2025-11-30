public class Employee extends Person {
    // 实例变量 - 至少2个
    private String employeeId;
    private String department;

    // 1. 默认构造器
    public Employee() {
        super(); // 调用父类的默认构造器
        this.employeeId = "E000";
        this.department = "General";
    }

    // 2. 参数化构造器
    public Employee(String name, int age, String email,
                    String employeeId, String department) {
        super(name, age, email); // 调用父类的参数化构造器
        this.employeeId = employeeId;
        this.department = department;
    }

    // 3. Getter方法
    public String getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    // 4. Setter方法
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}