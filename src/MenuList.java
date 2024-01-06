import java.util.Arrays;
import java.util.Scanner;

public class MenuList {
    // Assuming these arrays and variable are defined in the App class
    private static String[] items = {};
    private static double[] itemPrices = {};
    private static int[] itemStocks = {};
    private static double shopBalance = 10000.0;

    // Method for menu 1
    public static void viewItems() {
        System.out.println("=============================");
        System.out.println("Menu 1 - Show Available Items");
        System.out.println("=============================");

        if (items.length == 0) {
            System.out.println("\nNo items available in the shop!!!\n");
        } else {
            System.out.println("\nList of available items: \n");
            for (int i = 0; i < items.length; i++) {
                String itemName = items[i];
                double itemPrice = itemPrices[i];
                int itemStock = itemStocks[i];
                System.out.println((i+1) + ". " + itemName + " - RM" + itemPrice + " | Stock: " + itemStock);
            }
        }
    }

    // Method for menu 2
    public static void sellItem(Scanner scanner) {
        System.out.println("==================");
        System.out.println("Menu 2 - Sell Item");
        System.out.println("==================");

        if (items.length == 0) {
            System.out.println("\nNo items available in the shop!!!\n");
        } else {
            System.out.println("\nList of available items: \n");
            for (int i = 0; i < items.length; i++) {
                String itemName = items[i];
                double itemPrice = itemPrices[i];
                int itemStock = itemStocks[i];
                System.out.println((i+1) + ". " + itemName + " - RM" + itemPrice + " | Stock: " + itemStock);
            }

            System.out.print("\nEnter the item name to sell: ");
            String itemName = scanner.next();
            int itemIndex = Arrays.asList(items).indexOf(itemName);

            if (itemIndex != -1 && itemStocks[itemIndex] > 0) {
                double itemPrice = itemPrices[itemIndex];
                itemStocks[itemIndex]--;
                shopBalance += itemPrice;
                System.out.println("Sold " + itemName + " for RM" + itemPrice);
            } else {
                System.out.println("Item not available or out of stock!!!");
            }
        }
    }

    // Method for menu 3
    public static void restockItem(Scanner scanner) {
        System.out.println("=====================");
        System.out.println("Menu 3 - Restock Item");
        System.out.println("=====================");

        if (items.length == 0) {
            System.out.println("\nAdd new item first!!!\n");

            // Get user confirmation
            System.out.println("\nDo you want to add item? (y/n)");
            char confirmation = scanner.next().charAt(0);
            if (confirmation == 'y' || confirmation == 'Y') {
                addItem(scanner);
            } else if (confirmation == 'n' || confirmation == 'N') {
                return;
            } else {
                System.out.println("\nInvalid input!!!\n");
                restockItem(scanner);
            }

        } else {
            System.out.print("\nEnter the item name to restock: ");
            String itemName = scanner.next();
            int itemIndex = Arrays.asList(items).indexOf(itemName);

            if (itemIndex != -1) {
                System.out.print("Enter the quantity to restock: ");
                int quantity = scanner.nextInt();
                itemStocks[itemIndex] += quantity;
                double totalCost = itemPrices[itemIndex] * quantity;
                shopBalance -= totalCost;
                System.out.println("Restocked " + quantity + " " + itemName + " for RM" + totalCost);
            } else {
                System.out.println("Invalid item name!!!");
            }
        }
    }

    // Method for menu 4
    public static void viewShopBalance() {
        System.out.println("==========================");
        System.out.println("Menu 4 - View Shop Balance");
        System.out.println("==========================");
        System.out.println("\nShop Balance: RM" + shopBalance);
    }

    // Method for menu 5
    public static void searchItem(Scanner scanner) {
        System.out.println("====================");
        System.out.println("Menu 5 - Search Item");
        System.out.println("====================");
        System.out.print("\nEnter the item name to search: ");
        String itemName = scanner.next();

        int itemIndex = Arrays.asList(items).indexOf(itemName);

        if (itemIndex != -1) {
            double itemPrice = itemPrices[itemIndex];
            int itemStock = itemStocks[itemIndex];
            System.out.println("\nItem found: " + itemName + " - Price: $" + itemPrice + " | Stock: " + itemStock);
        } else {
            System.out.println("\nItem not found!!!");
        }
    }

    // Method for menu 6
    public static void addItem(Scanner scanner) {
        System.out.println();
        System.out.println("=================");
        System.out.println("Menu 6 - Add Item");
        System.out.println("=================");

        System.out.print("\nEnter the new item name: ");
        String newItemName = scanner.next();

        int newItemIndex = Arrays.asList(items).indexOf(newItemName);

        if (newItemIndex != -1) {
            System.out.println("Item already exists. Please add other item!!!");
            return;
        }

        // Input price of item
        System.out.print("Enter the price for " + newItemName + ": RM");
        
        // Check if the input is an integer
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            System.out.print("Enter the price for " + newItemName + ": RM");
            scanner.next(); // Consume the invalid input
        }
        double newItemPrice = scanner.nextDouble();

        // Input initial stock of item
        System.out.print("Enter the initial stock for " + newItemName + ": ");

        // Check if the input is an integer
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            System.out.print("Enter the initial stock for " + newItemName + ": ");
            scanner.next(); // Consume the invalid input
        }
        // Read the valid integer input
        int newItemStock = scanner.nextInt();



        // Assuming items, itemPrices, and itemStocks are defined in MenuList class
        items = Arrays.copyOf(items, items.length + 1);
        itemPrices = Arrays.copyOf(itemPrices, itemPrices.length + 1);
        itemStocks = Arrays.copyOf(itemStocks, itemStocks.length + 1);

        items[items.length - 1] = newItemName;
        itemPrices[itemPrices.length - 1] = newItemPrice;
        itemStocks[itemStocks.length - 1] = newItemStock;

        System.out.println(
                "\nAdded new item: \n" + newItemName + " | Price: RM" + newItemPrice + " | Initial Stock: " + newItemStock);
    }

    // Method for menu 7
    public static void deleteItem(Scanner scanner) {
        System.out.println("====================");
        System.out.println("Menu 7 - Delete Item");
        System.out.println("====================");

        if (items.length == 0) {
            System.out.println("\nNo items available in the shop!!!\n");
            return;
        } else {
            System.out.println("\nList of available items: \n");
            for (int i = 0; i < items.length; i++) {
                String itemName = items[i];
                double itemPrice = itemPrices[i];
                int itemStock = itemStocks[i];
                System.out.println((i+1) + ". " + itemName + " - RM" + itemPrice + " | Stock: " + itemStock);
            }
        }

        System.out.print("\nEnter the item name to delete: ");
        String itemName = scanner.next();

        int itemIndex = Arrays.asList(items).indexOf(itemName);

        if (itemIndex != -1) {
            // Remove the item from arrays
            items = removeElement(items, itemIndex);
            itemPrices = removeElement(itemPrices, itemIndex);
            itemStocks = removeElement(itemStocks, itemIndex);

            System.out.println(itemName + " has been deleted.");
        } else {
            System.out.println("Item not found!!!");
            return;
        }
    }

    private static String[] removeElement(String[] array, int index) {
        String[] newArray = new String[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        return newArray;
    }

    private static double[] removeElement(double[] array, int index) {
        double[] newArray = new double[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        return newArray;
    }

    private static int[] removeElement(int[] array, int index) {
        int[] newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        return newArray;
    }
}
