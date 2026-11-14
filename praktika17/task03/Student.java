package praktika17.task03;
import java.util.Scanner;

// Элемент картотеки: студент
public class Student {
    private String surname;
    private int age;
    private String group;

    public Student() {
    }

    public Student(String surname, int age, String group) {
        this.surname = surname;
        this.age = age;
        this.group = group;
    }

    // а) считать атрибуты объекта с консоли
    public void read(Scanner sc) {
        System.out.print("Фамилия: ");
        surname = sc.nextLine();

        System.out.print("Возраст: ");
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Введите целое число: ");
        }
        age = sc.nextInt();
        sc.nextLine();          // забираем остаток строки после числа

        System.out.print("Группа: ");
        group = sc.nextLine();
    }

    // б) вывести атрибуты на экран
    public void print() {
        System.out.println("Фамилия: " + surname + ", возраст: " + age + ", группа: " + group);
    }
}
