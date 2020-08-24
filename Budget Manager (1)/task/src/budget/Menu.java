package budget;

import java.util.Scanner;

public class Menu {

    double budget;
    Purchases newPurchase = new Purchases();
    static Scanner budgetScanner = new Scanner(System.in);


    public enum MenuChoicesForBudget {
        ONE ("1) Add income"),
        TWO ("2) Add purchase"),
        THREE ("3) Show list of purchases"),
        FOUR ("4) Balance"),
        ZERO ("0) Exit");

        String menuDescription;

        MenuChoicesForBudget(String menuDescription) {
            this.menuDescription = menuDescription;
        }
    }

    public void displayMenu() {
        System.out.println("Choose your action:");
        for (MenuChoicesForBudget yourChoice : MenuChoicesForBudget.values()) {
            System.out.println(yourChoice.menuDescription);
        }
    }

    public void addIncome() {

        System.out.println("Enter income:");
        budget =+ budgetScanner.nextInt();
        System.out.println("Income was added!");
    }

    public void addPurchase() {
        newPurchase.createList();
        budget = budget - newPurchase.purchaseCost;
    }

    public void showListOfPurchases() {
        newPurchase.calculateTotal();
        newPurchase.displayListAndTotal();
    }

    public void displayBalance() {
        System.out.println("Balance: $" + budget);

    }

    public static void runMenu() {
        Menu menu = new Menu();
        menu.displayMenu();
        int choice = budgetScanner.nextInt();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    System.out.println();
                    menu.addIncome();
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    menu.addPurchase();
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    menu.showListOfPurchases();
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    menu.displayBalance();
                    System.out.println();
                    break;
                default:
                    System.out.println("Please enter the correct choice");

            }
            menu.displayMenu();
            choice = budgetScanner.nextInt();
            //budgetScanner.nextLine();
        }
        System.out.println();
        System.out.println("Bye!");
        System.exit(0);
    }
}
