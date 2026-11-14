package praktika17.task03;

// Кольцевой односвязный список студентов: последний узел ссылается на первый.
// Храним ссылку только на последний узел tail, тогда первый узел - это tail.next.
public class StudentList {
    private Node tail;   // последний узел (tail.next - первый)
    private int size;

    // а) создание пустого списка
    public StudentList() {
        tail = null;
        size = 0;
    }

    // ж) проверка на пустоту
    public boolean isEmpty() {
        return tail == null;
    }

    public int size() {
        return size;
    }

    // б) добавление в конец
    public void add(Student s) {
        Node node = new Node(s);
        if (tail == null) {
            node.next = node;               // единственный узел ссылается сам на себя
            tail = node;
        } else {
            node.next = tail.next;          // новый узел замыкается на первый
            tail.next = node;               // бывший последний ссылается на новый
            tail = node;                    // новый узел становится последним
        }
        size++;
    }

    // в) удаление по номеру (нумерация с 1, первый узел - tail.next)
    public boolean remove(int index) {
        if (index < 1 || index > size) {
            return false;
        }
        if (size == 1) {
            tail = null;                    // был единственный узел
        } else {
            Node prev = tail;               // узел перед удаляемым (для первого это tail)
            for (int i = 1; i < index; i++) {
                prev = prev.next;
            }
            Node target = prev.next;
            prev.next = target.next;
            if (target == tail) {
                tail = prev;                // удалили последний: новый последний - prev
            }
        }
        size--;
        return true;
    }

    // г) вывод одного элемента по номеру
    public boolean printElement(int index) {
        if (index < 1 || index > size) {
            return false;
        }
        Node cur = tail.next;
        for (int i = 1; i < index; i++) {
            cur = cur.next;
        }
        System.out.print(index + ") ");
        cur.data.print();
        return true;
    }

    // вывод всех элементов один раз по кругу
    public void printAll() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        Node cur = tail.next;
        for (int i = 1; i <= size; i++) {
            System.out.print(i + ") ");
            cur.data.print();
            cur = cur.next;
        }
    }

    // показать кольцевую природу списка: вывести count элементов подряд, переходя с конца на начало
    public void printCircle(int count) {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        Node cur = tail.next;
        for (int i = 1; i <= count; i++) {
            System.out.print(i + ") ");
            cur.data.print();
            cur = cur.next;
        }
    }

    // д) очистка списка
    public void clear() {
        tail = null;
        size = 0;
    }
}
