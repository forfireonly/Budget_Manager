package budget;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.text.DecimalFormat;
import static budget.Main.*;

public class Purchases {

    public static class Item implements Comparable<Item>{
        String itemName;
        double price;

        public Double getPrice () {
            return this.price;
        }
        public Item(String itemName, double price) {
            this.itemName = itemName;
            this.price = price;
        }

        @Override
        public int compareTo(@NotNull Item item) {
            return this.getPrice().compareTo(item.getPrice());
        }
    }

    public void createList(int choice) throws IOException {
            System.out.println("Enter purchase name");
            String itemName = reader.readLine();
            System.out.println("Enter its price");
            double price = Double.parseDouble(reader.readLine());
            budget -= price;

            purchaseCost += price;
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

    public void createListOfCategoriesAndTotals() {
        totalFood = 0;
        totalClothes = 0;
        totalEntertainment = 0;
        totalOther = 0;
        for (Item purchase : foodList) {
            totalFood += purchase.price;
        }
        Item food = new Item("Food", totalFood);
        listOfCategories.add(food);
        for (Item purchase : clothesList) {
            totalClothes += purchase.price;
        }
        Item clothes = new Item("Clothes", totalClothes);
        listOfCategories.add(clothes);
        for (Item purchase : entertainmentList) {
            totalEntertainment += purchase.price;
        }
        Item entertainment = new Item("Entertainment", totalEntertainment);
        listOfCategories.add(entertainment);
        for (Item purchase : otherList) {
            totalOther += purchase.price;
        }
        Item other = new Item("Other", totalOther);
        listOfCategories.add(other);

    }

    public void calculateTotal (int choice) {

        switch (choice) {
            case 1:
                totalFood = 0;
                for (Item purchase : foodList) {
                      totalFood += purchase.price;
                    }
                break;
            case 2:
                totalClothes = 0;
                for (Item purchase : clothesList) {
                    totalClothes += purchase.price;
                }
                break;
            case 3:
                totalEntertainment = 0;
                for (Item purchase : entertainmentList) {
                    totalEntertainment += purchase.price;
                }
                break;
            case 4:
                totalOther = 0;
                for (Item purchase : otherList) {
                    totalOther += purchase.price;
                }
                break;
            case 5:
                for (Item purchase : listOfPurchases) {
                    total += purchase.price;
                }

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
                            System.out.println(purchase.itemName + " $" + df.format(purchase.price));
                        }

                        totalFood = 0;
                        calculateTotal(choice);
                        System.out.printf("Total sum: $%.2f%n", totalFood);
                    }

                    break;
                case 2:
                    System.out.println("Clothes:");
                    if (clothesList.size() == 0) {
                        System.out.println("Purchase list is Empty");
                    } else {
                        for (Item purchase : clothesList) {
                            System.out.println(purchase.itemName + " $" + df.format(purchase.price));
                        }
                        totalClothes = 0;
                        calculateTotal(choice);
                        System.out.printf("Total sum: $%.2f%n", totalClothes);
                    }

                    break;
                case 3:
                    System.out.println("Entertainment:");
                    if (entertainmentList.size() == 0) {
                        System.out.println("Purchase list is Empty");
                    } else {
                        for (Item purchase : entertainmentList) {
                            System.out.println(purchase.itemName + " $" + df.format(purchase.price));
                        }

                        totalEntertainment = 0;
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
                            System.out.println(purchase.itemName + " $" + df.format(purchase.price));
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
                            System.out.println(purchase.itemName + " $" + df.format(purchase.price));

                        }
                            total = 0;
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



