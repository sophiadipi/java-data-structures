/********************************************************************************************
* HashTableDriver.java
* 
* The HashTableDriver class demonstrates the funcionality of the HashTable class. 
*********************************************************************************************/

public class HashTableDriver 
{
    public static void main(String[] args)
    {
        HashTable myHashTable = new HashTable();

        System.out.println("\n---------------------------------------------------------------");
        System.out.println("ADDING ELEMENTS TO THE HASH TABLE:");
        System.out.println("---------------------------------------------------------------");

        System.out.println("\nHash table:\n" + myHashTable.toString());

        myHashTable.add("1897458376", "Little Red Riding Hood");
        System.out.println("\nHash table:\n" + myHashTable.toString());

        myHashTable.add("8939284920", "Greens Eggs and Ham");
        System.out.println("\nHash table:\n" + myHashTable.toString());

        myHashTable.add("89392849F", "Narnia");

        myHashTable.add("5437892509", "Cat in the Hat");
        System.out.println("\nHash table:\n" + myHashTable.toString());

        myHashTable.add("9849372376", "Geronimo Stilton");
        System.out.println("\nHash table:\n" + myHashTable.toString());

        myHashTable.add("1897458376", "The Princess and the Frog");
        System.out.println("\nHash table:\n" + myHashTable.toString());

        myHashTable.add("5674839920", "Cinderella");
        System.out.println("\nHash table:\n" + myHashTable.toString());

        myHashTable.add("3849502878", "Jack and the Beanstalk");
        System.out.println("\nHash table:\n" + myHashTable.toString());

        myHashTable.add("9374852934", "Alexandria of Africa");
        System.out.println("\nHash table:\n" + myHashTable.toString());

        myHashTable.add("5674839000", "Alice in Wonderland");
        System.out.println("\nHash table:\n" + myHashTable.toString());

        myHashTable.add("5674839001", "We All Fall Down");
        System.out.println("\nHash table:\n" + myHashTable.toString());

        myHashTable.add("2938573002", "The Princess Bride");
        System.out.println("\nHash table:\n" + myHashTable.toString());

        System.out.println("\n-----------------------------------------------------------------------------------------------------------------");
        System.out.println("ORDER MATTERS! Adding the same elements to the table in a different order will result in a different table:");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");

        HashTable myHashTable2 = new HashTable();

        myHashTable2.add("5437892509", "Cat in the Hat");

        myHashTable2.add("2938573002", "The Princess Bride");

        myHashTable2.add("5674839001", "We All Fall Down");

        myHashTable2.add("5674839920", "Cinderella");

        myHashTable2.add("8939284920", "Greens Eggs and Ham");

        myHashTable2.add("9374852934", "Alexandria of Africa");

        myHashTable2.add("3849502878", "Jack and the Beanstalk");

        myHashTable2.add("9849372376", "Geronimo Stilton");

        myHashTable2.add("1897458376", "Little Red Riding Hood");

        myHashTable2.add("1897458376", "The Princess and the Frog");
        
        myHashTable2.add("5674839000", "Alice in Wonderland");

        System.out.println("\nORIGINAL HASH TABLE:\n" + myHashTable.toString());

        System.out.println("\nHASH TABLE WITH SAME ELEMENTS ADDED IN DIFFERENT ORDER:\n" + myHashTable2.toString());

        System.out.println("\n---------------------------------------------------------------");
        System.out.println("REMOVING ELEMENTS FROM THE HASH TABLE:");
        System.out.println("---------------------------------------------------------------");

        System.out.println(myHashTable.toString());

        myHashTable.remove("3849502878");
        myHashTable.remove("5674839000");
        myHashTable.remove("8939284920");
        myHashTable.remove("1234567890");

        System.out.println("\nHash table after removals:\n" + myHashTable.toString());

    }
    
}
