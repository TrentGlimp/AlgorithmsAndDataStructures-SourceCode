package ShoeRandomQueue;

import java.util.concurrent.ThreadLocalRandom;

public class RandomQueue<Item> {

    private Item[] ItemArray = (Item[]) new Object[52];
    private int ItemCount = 0;

    public RandomQueue(){

    }
    public boolean isEmpty(){
        return ItemCount == 0;
    }

    private void resize(int max) {
        Item[] Temp = (Item[]) new Object[max];
        for (int i = 0; i < ItemCount; i++) { Temp[i] = ItemArray[i]; }
        ItemArray = Temp;
    }

    public void enqueue(Item item){
        if (ItemCount == ItemArray.length) { resize(2*ItemArray.length); }
        ItemArray[ItemCount++] = item;
    }

    public Item sample(){
        int random = ThreadLocalRandom.current().nextInt(0, ItemCount -1 );
        return ItemArray[random];
    }

    public Item dequeue(){
        int RandomIndex = ThreadLocalRandom.current().nextInt(0, ItemCount); // gets a random number that will be an index
        Item Temp = ItemArray[RandomIndex]; // stores the value of the chosen index in a placeholder variable
        ItemArray[RandomIndex] = ItemArray[ItemCount-1]; // moves the last item in the array to the chosen index
        ItemArray[ItemCount-1] = Temp; // moves the value stored in the placeholder variable to the last index in the array
        ItemCount--; // shrinks the accessible part of the array so the last number can no longer be selected
        return ItemArray[ItemCount]; // return the value that is no out of range of access of the array
    }


    // **MAIN METHOD**
    public static void main(String[] args) {
        RandomQueue<Cards> CardDeck = new RandomQueue<Cards>();
        for (int i = 0; i < 6; i++) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    CardDeck.enqueue(new Cards(suit, rank));
                }
            }
        }
        for (int i = 1; i < 5; i++) {
            System.out.println("Hand " + i + ":");
            for (int j = 0; j < 2; j++) {
                System.out.println(CardDeck.dequeue().toString());
            }
            System.out.println();
        }
    }
}