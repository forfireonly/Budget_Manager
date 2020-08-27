package budget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Double total = 0.0;
    static Double totalFood = 0.0;
    static Double totalClothes = 0.0;
    static Double totalEntertainment = 0.0;
    static Double totalOther = 0.0;
    static Double purchaseCost = 0.0;
    static List<Purchases.Item> foodList = new ArrayList<>();
    static List<Purchases.Item> clothesList = new ArrayList<>();
    static List<Purchases.Item> entertainmentList = new ArrayList<>();
    static List<Purchases.Item> otherList = new ArrayList<>();
    static List<Purchases.Item> listOfPurchases = new ArrayList<>();


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
                        while (purchaseType != 6) {

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
                default:
                    System.out.println("Please enter the correct choice");


            }
            myMenu.displayMenu();
            choice = Integer.parseInt(reader.readLine());

        }
        System.out.println();
        System.out.println("Bye!");
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
