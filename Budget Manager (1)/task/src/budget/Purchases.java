package budget;

import java.io.IOException;
import static budget.Main.*;


public class Purchases {

    public static class Item {
        String itemName;
        double price;

        public Item(String itemName, double price) {
            this.itemName = itemName;
            this.price = price;
        }

    }


    public void createList(int choice) throws IOException {
            System.out.println("Enter purchase name");
            String itemName = reader.readLine();
            System.out.println("Enter its price");
            double price = Double.parseDouble(reader.readLine());

            purchaseCost = price;
            Item item = new Item(itemName, price);
            listOfPurchases.add(item);
            switch (choice) {
                case 1:
                    foodList.add(item);
                    break;
                case 2:
                    clothesList.add(item);
                    break;
                case 3:
                    entertainmentList.add(item);
                    break;
                case 4:
                    otherList.add(item);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Please, enter valid choice");
            }
            System.out.println("Purchase was added!");

    }

    static double processString(String singlePurchase) {
        String amountString = singlePurchase.substring(singlePurchase.indexOf('$') + 1);
        return Double.parseDouble(amountString);
    }

    public void calculateTotal (int choice) {

        switch (choice) {
            case 1:
                for (Item purchase : foodList) {
                      totalFood += purchase.price;
                    total += purchase.price;
                    }
                break;
            case 2:
                for (Item purchase : clothesList) {
                    totalClothes += purchase.price;
                    total += purchase.price;
                }
                break;
            case 3:
                for (Item purchase : entertainmentList) {
                    totalEntertainment += purchase.price;
                    total += purchase.price;
                }
                break;
            case 4:
                for (Item purchase : entertainmentList) {
                    totalOther += purchase.price;
                    total += purchase.price;
                }
                break;
            case 5:

                break;
            case 6:
                break;

            default:



        }
    }

    public void displayListAndTotal(int choice) {

            switch (choice) {
                case 1:
                    System.out.println("Food:");
                    if (foodList.size() == 0) {
                        System.out.println("Purchase list is Empty");
                    } else {
                        for (Item purchase : foodList) {
                            //System.out.println("Total $" + calculateTotal(choice));
                            System.out.println(purchase.itemName + " $" + purchase.price);
                        }
                    }
                    calculateTotal(choice);
                    System.out.printf("Total sum: $%.2f%n", totalFood);
                    break;
                case 2:
                    System.out.println("Clothes:");
                    if (clothesList.size() == 0) {
                        System.out.println("Purchase list is Empty");
                    } else {
                        for (Item purchase : clothesList) {
                            System.out.println(purchase.itemName + " $" + purchase.price);
                        }
                    }
                    calculateTotal(choice);
                    System.out.printf("Total sum: $%.2f%n", totalClothes);
                    break;
                case 3:
                    System.out.println("Entertainment:");
                    if (entertainmentList.size() == 0) {
                        System.out.println("Purchase list is Empty");
                    } else {
                        for (Item purchase : entertainmentList) {
                            System.out.println(purchase.itemName + " $" + purchase.price);
                        }

                        calculateTotal(choice);
                        System.out.printf("Total sum: $%.2f%n", totalEntertainment);
                    }
                    break;
                case 4:
                    System.out.println("Other:");
                    if (otherList.size() == 0) {
                        System.out.println("Purchase list is Empty");
                    } else {
                        for (Item purchase : otherList) {
                            System.out.println(purchase.itemName + " $" + purchase.price);
                        }

                        calculateTotal(choice);
                        System.out.printf("Total sum: $%.2f%n", totalOther);
                    }
                    break;
                case 5:
                    System.out.println("All:");
                    if (listOfPurchases.size() == 0) {
                        System.out.println("Purchase list is Empty");
                    } else {
                        for (Item purchase : listOfPurchases) {
                            System.out.println(purchase.itemName + " $" + purchase.price);

                            calculateTotal(choice);
                            System.out.printf("Total sum: $%.2f%n", total);
                        }
                        break;
                    }
            }
    }

    /*public static void showTotal() {
        Purchases myList = new Purchases();
        myList.createList();
        myList.calculateTotal();
       // myList.displayTotal();
    }*/

}
