package praktika17.task03;

// Узел односвязного списка: данные и ссылка на следующий узел
public class Node {
    Student data;
    Node next;

    Node(Student data) {
        this.data = data;
        this.next = null;
    }
}
