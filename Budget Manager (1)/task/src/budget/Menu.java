package budget;

import java.io.IOException;
import static budget.Main.*;

public class Menu {

    double budget;
    Purchases newPurchase = new Purchases();

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

    String[] typesOfPurchasesList = {"1) Food", "2) Clothes", "3) Entertainment", "4) Other", "5) Back"};
    String[] typesOfDisplayedLists = {"1) Food", "2) Clothes", "3) Entertainment", "4) Other", "5) All", "6) Back"};

    //display menu for purchases
    public void displayPurchasesOption() {
        System.out.println();
        System.out.println("Choose the type of purchase:");

        for (String choice : typesOfPurchasesList) {
            System.out.println(choice);
        }

    }

    public void displayTypesOfDisplayedLists() {
        System.out.println();
        System.out.println("Choose the type of purchase:");

        for (String choice : typesOfDisplayedLists) {
            System.out.println(choice);
        }

    }

    //display menu for actions
    public void displayMenu() {
        System.out.println();
        System.out.println("Choose your action");
        for (MenuChoicesForBudget menuChoice : MenuChoicesForBudget.values()) {
           System.out.println(menuChoice.menuDescription);
        }
    }

    public void addIncome() throws IOException {
        System.out.println("Enter income:");
        budget =+ Integer.parseInt(reader.readLine());
        System.out.println("Income was added!");
    }

    public void displayBalance() {
        System.out.println("Balance: $" + budget);

    }

}
