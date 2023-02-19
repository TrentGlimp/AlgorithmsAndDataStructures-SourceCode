package ArrayList;


import java.util.Arrays;

public class ArrayList<Item> {

    private Item[] itemArray = (Item[]) new Object[10];
    private int itemCount = 0;

    private void resize(int max) {
        Item[] temporary = (Item[]) new Object[max];
        for (int i = 0; i < itemCount; i++) { temporary[i] = itemArray[i]; }
        itemArray = temporary;
    }

    private void resizeCheck() {
        if (itemCount == itemArray.length) {
            resize(2*itemArray.length);
        }
    }

    public void add(Item item) {
        resizeCheck();
        itemArray[itemCount] = item;
        itemCount++;
    }



    public void add(int index, Item item) {
        resizeCheck();
        for (int i = itemCount - 1; i >= index; i--) {
            itemArray[i+1] = itemArray[i];
        }
        itemArray[index] = item;
        itemCount++;
    }

    public void clear() {
        itemCount = 0;
        itemArray = (Item[]) new Object[10];
    }

    public boolean contains(Item item) {
        for (int i = 0; i < itemCount; i++) {
            if (itemArray[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public Item get(int index) {
        return itemArray[index];
    }

    public int indexOf(Item item) {
        for (int i = 0; i < itemCount; i++) {
            if (itemArray[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public void remove(int index) {
        for (int i = index; i < itemCount - 1; i++) {
            itemArray[i] = itemArray[i+1];
        }
        itemArray[itemCount-1] = null;
        itemCount--;
    }

    public void remove(Item item) {
        int index = indexOf(item);
        if (index != -1) {
            remove(index);
        }
    }

    public void set(int index, Item item) {
        itemArray[index] = item;
    }

    public int size() {
        return itemCount;
    }

    /*public Item[] toArray() {
        Item[] array = Arrays.copyOf(itemArray, itemCount);
        return array;
    }*/ // DOESN'T WORK

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < itemCount; i++) {
            string += itemArray[i] + " ";
        }
        return string;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        System.out.println("Array list: " + arrayList.toString());

        arrayList.add(2, 5);
        System.out.println("Array list after adding element at index 2: " + arrayList.toString());

        arrayList.remove(1);
        System.out.println("Array list after removing element at index 1: " + arrayList.toString());

        arrayList.remove((Integer) 3);
        System.out.println("Array list after removing element 3: " + arrayList.toString());

        arrayList.set(1, 6);
        System.out.println("Array list after setting element at index 1 to 6: " + arrayList.toString());

        System.out.println("Element at index 2: " + arrayList.get(2));

        System.out.println("Array list contains 2: " + arrayList.contains(2));

        System.out.println("Index of 4: " + arrayList.indexOf(4));

        arrayList.clear();
        System.out.println("Array list after clearing: " + arrayList.toString());

        System.out.println("Array list is empty: " + arrayList.isEmpty());

        /*Integer[] newArray = (Integer[]) arrayList.toArray();
        System.out.println("New array: " + Arrays.toString(newArray));*/ // DOESN'T WORK
    }
}
