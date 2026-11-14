package praktika17.task01;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();      // создаём пустой список

        int choice = -1;
        while (choice != 0) {
            System.out.println();
            System.out.println("===== Картотека студентов =====");
            System.out.println("1 - добавить студента");
            System.out.println("2 - удалить студента по номеру");
            System.out.println("3 - показать студента по номеру");
            System.out.println("4 - показать всех студентов");
            System.out.println("5 - очистить список");
            System.out.println("6 - проверить, пуст ли список");
            System.out.println("0 - выход");
            choice = readInt(sc, "Ваш выбор: ");

            switch (choice) {
                case 1: {
                    Student s = new Student();
                    s.read(sc);
                    list.add(s);
                    System.out.println("Студент добавлен.");
                    break;
                }
                case 2: {
                    int n = readInt(sc, "Номер студента: ");
                    if (list.remove(n)) {
                        System.out.println("Студент удалён.");
                    } else {
                        System.out.println("Студента с таким номером нет.");
                    }
                    break;
                }
                case 3: {
                    int n = readInt(sc, "Номер студента: ");
                    if (!list.printElement(n)) {
                        System.out.println("Студента с таким номером нет.");
                    }
                    break;
                }
                case 4:
                    list.printAll();
                    break;
                case 5:
                    list.clear();
                    System.out.println("Список очищен.");
                    break;
                case 6:
                    if (list.isEmpty()) {
                        System.out.println("Список пуст.");
                    } else {
                        System.out.println("В списке студентов: " + list.size());
                    }
                    break;
                case 0:
                    System.out.println("Выход.");
                    break;
                default:
                    System.out.println("Нет такого пункта меню.");
            }
        }
    }

    static int readInt(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Введите целое число: ");
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }
}