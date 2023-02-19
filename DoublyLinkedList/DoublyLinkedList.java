package DoublyLinkedList;

public class DoublyLinkedList<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    private int itemCoun;

    private static class Node<Item> {
        private Item item;
        private DoublyLinkedList.Node<Item> next;
        private DoublyLinkedList.Node<Item> previous;
    }


    public Item get(Integer index) {
        Node currentNode = head;
        int counter = 0;
        while(currentNode.next != null) {
            if (counter == index) {
                return (Item) currentNode.item;
            }
            currentNode = currentNode.next;
            counter++;
        }
        return null;
    }

    public void set(Integer index, Item newItem) {
        Node currentNode = head;
        int counter = 0;
        while(currentNode.next != null) {
            if (counter == index) {
                currentNode.item = newItem;
            }
            currentNode = currentNode.next;
            counter++;
        }
    }
    public void insertAtHead(Item newItem) {
        Node newFirst = new Node<Item>();
        newFirst.item = newItem;
        itemCount++;
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
        itemCount++;
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
        Node currentNode = head;
        int counter = 0;
        itemCount++;

        while (currentNode != null) {
            if (counter == index) {
                Node newNode = new Node<Item>();
                newNode.item = newItem;

                newNode.previous = currentNode.previous;
                currentNode.previous = newNode;
                newNode.next = currentNode;

                if (head == currentNode) {
                    head = newNode;
                } else {
                    newNode.previous.next = newNode;
                }
                return;
            }
            counter++;
            currentNode = currentNode.next;
        }
    }

    public void insertAfterNthNode(Integer index, Item newItem) {
        Node currentNode = head;
        int counter = 0;
        itemCount++;

        while (currentNode != null) {
            if (counter == index) {
                Node newNode = new Node<Item>();
                newNode.item = newItem;

                newNode.next = currentNode.next;
                currentNode.next = newNode;
                newNode.previous = currentNode;

                if (tail == currentNode) {
                    tail = newNode;
                } else {
                    newNode.next.previous = newNode;
                }
                return;
            }
            counter++;
            currentNode = currentNode.next;
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
            itemCount--;
        }
    }

    public void removeTail() {
        if (tail == null) {
            return;
        } else if (tail.previous == null) {
            tail = null;
            head = null;
            itemCount--;
        } else {
            tail = tail.previous;
            tail.next = null;
            itemCount--;
        }
    }

    public void removeNthNode(Integer index) {
        Node current = head;
        int counter = 0;
        itemCount--;

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
        testList.insertBeforeNthNode(4, "Septhember");
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
        testList.set(8, "September");


        Node currentNode = testList.head;

        for (int i = 0; i < testList.itemCount; i++) {
            System.out.println(testList.get(i));
        }
        System.out.println(testList.get(11));
    }
}