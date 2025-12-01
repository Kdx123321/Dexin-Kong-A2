import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {

    @Override
    public int compare(Visitor visitor1, Visitor visitor2) {
        // 第一排序条件：按姓名排序
        int nameComparison = visitor1.getName().compareTo(visitor2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }

        // 第二排序条件：按年龄排序
        return Integer.compare(visitor1.getAge(), visitor2.getAge());
    }
}