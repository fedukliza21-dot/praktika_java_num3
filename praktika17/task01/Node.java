package praktika17.task01;

// Узел односвязного списка: данные и ссылка на следующий узел
public class Node {
    Student data;
    Node next;

    Node(Student data) {
        this.data = data;
        this.next = null;
    }
}

