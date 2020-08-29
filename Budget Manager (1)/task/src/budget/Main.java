package budget;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static double total = 0.0;
    static double totalFood = 0.0;
    static double totalClothes = 0.0;
    static double totalEntertainment = 0.0;
    static double totalOther = 0.0;
    static double purchaseCost = 0.0;
    static List<Purchases.Item> foodList = new ArrayList<>();
    static List<Purchases.Item> clothesList = new ArrayList<>();
    static List<Purchases.Item> entertainmentList = new ArrayList<>();
    static List<Purchases.Item> otherList = new ArrayList<>();
    static List<Purchases.Item> listOfPurchases = new ArrayList<>();
    static double budget;


    static Menu myMenu = new Menu();
    static Purchases myPurchase = new Purchases();


    public static void main(String[] args) throws IOException {

        myMenu.displayMenu();
        int choice = Integer.parseInt(reader.readLine());

        while (choice != 0) {

            switch (choice) {
                case 1:
                    System.out.println();
                    myMenu.addIncome();
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    if (listOfPurchases.size() == 0) {
                        myMenu.displayPurchasesOption();
                        int purchaseType = Integer.parseInt(reader.readLine());
                        while (purchaseType != 5) {
                            runMenuPurchasesTypesStart(purchaseType);
                            myMenu.displayPurchasesOption();
                            purchaseType = Integer.parseInt(reader.readLine());

                        }

                    } else {
                        myMenu.displayPurchasesOption();
                        int purchaseType = Integer.parseInt(reader.readLine());
                        while (purchaseType != 5) {

                            runMenuPurchasesTypes(purchaseType);
                            myMenu.displayPurchasesOption();
                            purchaseType = Integer.parseInt(reader.readLine());

                        }
                    }
                    break;
                case 3:

                    myMenu.displayTypesOfDisplayedLists();
                    int currentChoice = Integer.parseInt(reader.readLine());
                    while (currentChoice != 6) {
                        System.out.println();
                        if (listOfPurchases.size() == 0) {
                            System.out.println("Purchase list is empty!");
                            break;
                        } else {
                            myPurchase.displayListAndTotal(currentChoice);
                            myMenu.displayTypesOfDisplayedLists();
                            currentChoice = Integer.parseInt(reader.readLine());
                        }
                    }

                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    myMenu.displayBalance();
                    System.out.println();
                    break;

                case 5:
                    File myBudget = new File("purchases.txt");

                    try (FileWriter writer = new FileWriter(myBudget)) {
                        writer.write("Budget---" + budget + "\n");

                        writer.write("Food---" );
                        StringBuilder newString = new StringBuilder();
                        for (Purchases.Item  foodItem : foodList) {
                            newString.append(foodItem.itemName).append("---").append(foodItem.price).append("---");
                        }
                        writer.write(newString + "\n");

                        writer.write("Clothes---");
                        newString = new StringBuilder();
                        for (Purchases.Item  clothesItem : clothesList) {
                            newString.append(clothesItem.itemName).append("---").append(clothesItem.price).append("---");
                        }
                        writer.write(newString + "\n");

                        writer.write("Entertainment---");
                        newString = new StringBuilder();
                        for (Purchases.Item  entertainmentItem : entertainmentList) {
                            newString.append(entertainmentItem.itemName).append("---").append(entertainmentItem.price).append("---");
                        }
                        writer.write(newString + "\n");

                        writer.write("Other---");
                        newString = new StringBuilder();
                        for (Purchases.Item  otherItem : otherList) {
                            newString.append(otherItem.itemName).append("---").append(otherItem.price).append("---");
                        }
                        writer.write(newString.toString());




                    } catch (IOException e) {
                        System.out.printf("An exception occurs %s", e.getMessage());
                    }


                    System.out.println("Purchases were saved!");
                    break;
                case 6:
                    File file = new File("purchases.txt");
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNext()) {
                            String myData = scanner.nextLine();
                            String[] input = myData.split("---");
                            int inputLength = input.length;
                            if (input[0].equals("Budget")) {
                                budget = Double.parseDouble(input[1]);
                            }
                            if (input[0].equals("Food")) {
                                for (int i = 1; i < inputLength - 1; i+=2) {
                                    Purchases.Item newItem = new Purchases.Item(input[i], Double.parseDouble(input[i + 1]));
                                    foodList.add(newItem);
                                    listOfPurchases.add(newItem);
                                }
                            }
                            if (input[0].equals("Clothes")) {
                                for (int i = 1; i < inputLength - 1; i+=2) {
                                    Purchases.Item newItem = new Purchases.Item(input[i], Double.parseDouble(input[i + 1]));
                                    clothesList.add(newItem);
                                    listOfPurchases.add(newItem);
                                }
                            }
                            if (input[0].equals("Entertainment")) {
                                for (int i = 1; i < inputLength - 1; i+=2) {
                                    Purchases.Item newItem = new Purchases.Item(input[i], Double.parseDouble(input[i + 1]));
                                    entertainmentList.add(newItem);
                                    listOfPurchases.add(newItem);
                                }
                            }
                            if (input[0].equals("Other")) {
                                for (int i = 1; i < inputLength - 1; i+=2) {
                                    Purchases.Item newItem = new Purchases.Item(input[i], Double.parseDouble(input[i + 1]));
                                    otherList.add(newItem);
                                    listOfPurchases.add(newItem);
                                }
                            }
                        }
                        System.out.println();
                        System.out.println("Purchases were loaded!");
                    } catch (FileNotFoundException e) {
                        System.out.println("No file found");
                    }



                    break;
                default:
                    System.out.println("Please enter the correct choice");


            }
            myMenu.displayMenu();
            choice = Integer.parseInt(reader.readLine());

        }
        System.out.println();
        System.out.println("Bye!");
        System.out.println();
    }

    public static void runMenuPurchasesTypes(int purchaseOption) throws IOException {

            switch (purchaseOption) {
                case 1:
                    System.out.println();
                    myPurchase.createList(1);
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    myPurchase.createList(2);
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    myPurchase.createList(3);
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    myPurchase.createList(4);
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    myPurchase.createList(5);
                    System.out.println();
                    break;

                default:
                    System.out.println("Please enter the correct choice");

        }
    }

    public static void runMenuPurchasesTypesStart(int purchaseOption) throws IOException {

        switch (purchaseOption) {
            case 1:
                System.out.println();
                myPurchase.createList(1);
                System.out.println();
                break;
            case 2:
                System.out.println();
                myPurchase.createList(2);
                System.out.println();
                break;
            case 3:
                System.out.println();
                myPurchase.createList(3);
                System.out.println();
                break;
            case 4:
                System.out.println();
                myPurchase.createList(4);
                System.out.println();
                break;
            case 5:

                break;

            default:
                System.out.println("Please enter the correct choice");

        }
    }
}
