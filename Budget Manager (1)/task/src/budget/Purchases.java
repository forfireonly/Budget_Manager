package budget;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Purchases {
    List<Item> listOfPurchases = new ArrayList<>();
    Scanner scn = new Scanner(System.in);
    Double total = 0.0;
    Double purchaseCost = 0.0;

    public static class Item {
        String itemName;
        double price;

        public Item(String itemName, double price) {
            this.itemName = itemName;
            this.price = price;
        }

    }


    public void createList() {
            System.out.println("Enter purchase name");
            String itemName = scn.nextLine();
            System.out.println("Enter its price");
            double price = scn.nextDouble();
            scn.nextLine();
            purchaseCost = price;
            Item item = new Item(itemName, price);
            listOfPurchases.add(item);
            System.out.println("Purchase was added!");

    }

    static double processString(String singlePurchase) {
        String amountString = singlePurchase.substring(singlePurchase.indexOf('$') + 1);
        return Double.parseDouble(amountString);
    }

    public void calculateTotal () {

        for (Item purchase : listOfPurchases) {
            total += purchase.price;
        }
    }

    public void displayListAndTotal() {
        if (listOfPurchases.size() == 0) {
            System.out.println("Purchase list is empty");
        } else {
            for (Item purchase : listOfPurchases) {
                System.out.println(purchase.itemName + " $" + purchase.price);
            }
            System.out.printf("Total: $%.2f%n", total);
        }
    }

    public static void showTotal() {
        Purchases myList = new Purchases();
        myList.createList();
        myList.calculateTotal();
       // myList.displayTotal();
    }

}
