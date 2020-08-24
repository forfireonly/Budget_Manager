package budget;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Purchases {
    List<String> listOfPurchases = new ArrayList<>();
    Scanner scn = new Scanner(System.in);
    Double total = 0.0;

    public Purchases() {
        //scn = new Scanner(System.in);
    }

    public void createList() {
        while(scn.hasNext()) {
            String item = scn.nextLine();
            listOfPurchases.add(item);
        }
    }

    static double processString(String singlePurchase) {
        String amountString = singlePurchase.substring(singlePurchase.indexOf('$') + 1);
        return Double.parseDouble(amountString);
    }

    public void calculateTotal () {

        for (String purchase : listOfPurchases) {
            total += processString(purchase);
        }
    }

    public void displayTotal() {
        for (String purchase : listOfPurchases) {
            System.out.println(purchase);
        }
        System.out.printf("Total: $%.2f", total);
    }

    public static void showTotal() {
        Purchases myList = new Purchases();
        myList.createList();
        myList.calculateTotal();
        myList.displayTotal();
    }

}
