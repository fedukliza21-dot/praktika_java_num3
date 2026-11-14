package praktika17.task01;

// Односвязный список студентов
public class StudentList {
    private Node head;   // первый узел
    private int size;

    // а) создание пустого списка
    public StudentList() {
        head = null;
        size = 0;
    }

    // ж) проверка на пустоту
    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    // б) добавление элемента в конец списка
    public void add(Student s) {
        Node node = new Node(s);
        if (head == null) {
            head = node;
        } else {
            Node cur = head;
            while (cur.next != null) {      // идём до последнего узла
                cur = cur.next;
            }
            cur.next = node;
        }
        size++;
    }

    // в) удаление элемента по номеру (нумерация с 1)
    public boolean remove(int index) {
        if (index < 1 || index > size) {
            return false;
        }
        if (index == 1) {
            head = head.next;               // удаляем первый: голова сдвигается
        } else {
            Node prev = head;
            for (int i = 1; i < index - 1; i++) {
                prev = prev.next;           // выходим на узел перед удаляемым
            }
            prev.next = prev.next.next;     // перепрыгиваем через удаляемый
        }
        size--;
        return true;
    }

    // г) вывод одного элемента по номеру
    public boolean printElement(int index) {
        if (index < 1 || index > size) {
            return false;
        }
        Node cur = head;
        for (int i = 1; i < index; i++) {
            cur = cur.next;
        }
        System.out.print(index + ") ");
        cur.data.print();
        return true;
    }

    // вывод всех элементов
    public void printAll() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        Node cur = head;
        int number = 1;
        while (cur != null) {
            System.out.print(number + ") ");
            cur.data.print();
            cur = cur.next;
            number++;
        }
    }

    // д) очистка списка
    public void clear() {
        head = null;
        size = 0;
    }
}