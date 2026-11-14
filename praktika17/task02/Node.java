package praktika17.task02;

public class Node {
    Student data;
    Node prev;
    Node next;

    Node(Student data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
