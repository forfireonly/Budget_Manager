package budget;

import java.io.IOException;
import static budget.Main.*;

public class Menu {

    public enum MenuChoicesForBudget {
        ONE ("1) Add income"),
        TWO ("2) Add purchase"),
        THREE ("3) Show list of purchases"),
        FOUR ("4) Balance"),
        FIVE ("5) Save"),
        SIX ("6) Load"),
        SEVEN("7) Analyze (Sort)"),
        ZERO ("0) Exit");

        String menuDescription;

        MenuChoicesForBudget(String menuDescription) {
            this.menuDescription = menuDescription;
        }
    }

    String[] typesOfPurchasesList = {"1) Food", "2) Clothes", "3) Entertainment", "4) Other", "5) Back"};
    String[] typesOfDisplayedLists = {"1) Food", "2) Clothes", "3) Entertainment", "4) Other", "5) All", "6) Back"};
    String[] sortingWays = {"1) Sort all purchases", "2) Sort by type", "3) Sort certain type", "4) back"};
    String[] typesOfPurchasesToSort = {"1) Food", "2) Clothes", "3) Entertainment", "4) Other"};

    public void displayPurchasesForSorting() {
        System.out.println();
        System.out.println("Choose the type of purchase");

        for (String choice : typesOfPurchasesToSort) {
            System.out.println(choice);
        }
    }

    public void displaySortingWays() {
        System.out.println();
        System.out.println("How do you want to sort?");

        for (String choice : sortingWays) {
            System.out.println(choice);
        }

    }

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
        budget = budget + Double.parseDouble(reader.readLine());
        System.out.println("Income was added!");
    }

    public void displayBalance() {
        System.out.println("Balance: $" + budget);
    }
}
