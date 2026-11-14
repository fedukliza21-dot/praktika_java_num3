package praktika09.task03;

public class MergeTest {
    public static void main(String[] args) {
        Student[] group1 = {
                new Student(1042, "Иванов", 4.3),
                new Student(1007, "Петрова", 4.9),
                new Student(1031, "Сидоров", 3.8),
                new Student(1015, "Кузнецова", 4.6)
        };
        Student[] group2 = {
                new Student(1050, "Орлов", 4.6),
                new Student(1023, "Смирнов", 4.1),
                new Student(1002, "Волкова", 4.8)
        };

        System.out.println("Первый список:");
        print(group1);
        System.out.println("\nВторой список:");
        print(group2);

        Student[] all = MergeStudents.mergeLists(group1, group2);

        System.out.println("\nОбъединённый отсортированный список (по iDNumber):");
        print(all);
    }

    static void print(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}
