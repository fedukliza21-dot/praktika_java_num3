package praktika17.task02;

// Двусвязный список студентов
public class StudentList {
    private Node head;   // первый узел
    private Node tail;   // последний узел
    private int size;

    // а) создание пустого списка
    public StudentList() {
        head = null;
        tail = null;
        size = 0;
    }

    // ж) проверка на пустоту
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // б) добавление в конец: благодаря tail не нужно обходить весь список
    public void add(Student s) {
        Node node = new Node(s);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    // Узел по номеру (с 1): идём с ближайшего конца
    private Node getNode(int index) {
        Node cur;
        if (index <= size / 2) {
            cur = head;
            for (int i = 1; i < index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = size; i > index; i--) {
                cur = cur.prev;
            }
        }
        return cur;
    }

    // в) удаление по номеру (нумерация с 1)
    public boolean remove(int index) {
        if (index < 1 || index > size) {
            return false;
        }
        Node node = getNode(index);

        if (node.prev == null) {
            head = node.next;               // удаляем первый
        } else {
            node.prev.next = node.next;
        }
        if (node.next == null) {
            tail = node.prev;               // удаляем последний
        } else {
            node.next.prev = node.prev;
        }
        size--;
        return true;
    }

    // г) вывод одного элемента по номеру
    public boolean printElement(int index) {
        if (index < 1 || index > size) {
            return false;
        }
        System.out.print(index + ") ");
        getNode(index).data.print();
        return true;
    }

    // вывод всех элементов от начала к концу
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

    // вывод всех элементов от конца к началу (удобно только в двусвязном списке)
    public void printAllReverse() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        Node cur = tail;
        int number = size;
        while (cur != null) {
            System.out.print(number + ") ");
            cur.data.print();
            cur = cur.prev;
            number--;
        }
    }

    // д) очистка списка
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}
