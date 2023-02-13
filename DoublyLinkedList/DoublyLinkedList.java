package DoublyLinkedList;

public class DoublyLinkedList<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    private int itemCount;

    private static class Node<Item> {
        private Item item;
        private DoublyLinkedList.Node<Item> next;
        private DoublyLinkedList.Node<Item> previous;
    }

    public void insertAtHead(Item newItem) {
        Node newFirst = new Node<Item>();
        newFirst.item = newItem;
        if (head == null) {
            head = newFirst;
            tail = newFirst;
        } else {
            Node oldFirst = head;
            head = newFirst;
            newFirst.next = oldFirst;
            oldFirst.previous = newFirst;
            newFirst.previous = null;
        }
    }

    public void insertAtTail(Item newItem) {
        Node newLast = new Node<Item>();
        newLast.item = newItem;
        if (tail == null) {
            tail = newLast;
            head = newLast;
            newLast.next = null;
            newLast.previous = null;
        } else {
            newLast.previous = tail;
            tail.next = newLast;
            tail = newLast;
            newLast.next = null;
        }
    }

    public void insertBeforeNthNode(Integer index, Item newItem) {
        Node current = head;
        int counter = 0;

        while (current != null) {
            if (counter == index) {
                Node newNode = new Node<Item>();
                newNode.item = newItem;

                newNode.previous = current.previous;
                current.previous = newNode;
                newNode.next = current;

                if (head == current) {
                    head = newNode;
                } else {
                    newNode.previous.next = newNode;
                }
                return;
            }
            counter++;
            current = current.next;
        }
    }

    public void insertAfterNthNode(Integer index, Item newItem) {
        Node current = head;
        int counter = 0;

        while (current != null) {
            if (counter == index) {
                Node newNode = new Node<Item>();
                newNode.item = newItem;

                newNode.next = current.next;
                current.next = newNode;
                newNode.previous = current;

                if (tail == current) {
                    tail = newNode;
                } else {
                    newNode.next.previous = newNode;
                }
                return;
            }
            counter++;
            current = current.next;
        }
    }

    public void removeHead() {
        if (head == null) {
            return;
        } else {
            Node newFirst = head.next;
            head.next = null;
            newFirst.previous = null;
            head = newFirst;
        }
    }

    public void removeTail() {
        if (tail == null) {
            return;
        } else if (tail.previous == null) {
            tail = null;
            head = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
    }

    public void removeNthNode(Integer index) {
        Node current = head;
        int counter = 0;

        while (current != null) {
            if (counter == index) {
                if (head == current) {
                    head = current.next;
                    head.previous = null;
                } else if (tail == current) {
                    tail = current.previous;
                    tail.next = null;
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                return;
            }
            counter++;
            current = current.next;
        }
    }



    public static void main(String[] args) {
        DoublyLinkedList testList = new DoublyLinkedList<String>();
        testList.insertAtHead("November");
        testList.insertAtHead("August");
        testList.insertAfterNthNode(1, "December");
        testList.insertAtHead("Monday");
        testList.insertAtHead("March");
        testList.insertAtHead("January");
        testList.insertAtTail("Tuesday");
        testList.insertBeforeNthNode(4, "September");
        testList.insertAfterNthNode(2, "June");
        testList.insertBeforeNthNode(3, "May");
        testList.insertAtHead("Sunday");
        testList.insertBeforeNthNode(6, "July");
        testList.insertBeforeNthNode(2, "February");
        testList.insertBeforeNthNode(10, "October");
        testList.insertBeforeNthNode(5, "April");
        testList.removeHead();
        testList.removeTail();
        testList.removeNthNode(3);


        Node currentNode = testList.head;

        while (currentNode.next != null) {

            System.out.println(currentNode.item);
            currentNode = currentNode.next;
        }
        System.out.println(currentNode.item);
    }
}