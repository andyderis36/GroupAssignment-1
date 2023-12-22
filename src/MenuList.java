import java.util.Arrays;
import java.util.Scanner;

public class MenuList {
    // Assuming these arrays and variable are defined in the App class
    private static String[] items = { "mouse", "keyboard", "monitor", "desktop" };
    private static double[] itemPrices = { 20.0, 30.0, 150.0, 500.0 };
    private static int[] itemStocks = { 50, 30, 20, 10 };
    private static double shopBalance = 10000.0;

    //Method for menu 1
    public static void viewItems() {
        System.out.println("=============================");
        System.out.println("Menu 1 - Show Available Items");
        System.out.println("=============================");
        System.out.println("\nItems available in the shop: \n");
        for (int i = 0; i < items.length; i++) {
            String itemName = items[i];
            double itemPrice = itemPrices[i];
            int itemStock = itemStocks[i];
            System.out.println(itemName + " - RM " + itemPrice + " | Stock: " + itemStock);
        }
    }

    //Method for menu 2
    public static void sellItem(Scanner scanner) {
        System.out.println("==================");
        System.out.println("Menu 2 - Sell Item");
        System.out.println("==================");

        for (String itemName : items) {
            System.out.println(itemName);
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
            System.out.println("Item not available or out of stock.");
        }
    }
    //Method for menu 3
    public static void restockItem(Scanner scanner) {
        System.out.println("=====================");
        System.out.println("Menu 3 - Restock Item");
        System.out.println("=====================");
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
            System.out.println("Invalid item name.");
        }
    }
    //Method for menu 4
    public static void viewShopBalance() {
        System.out.println("==========================");
        System.out.println("Menu 4 - View Shop Balance");
        System.out.println("==========================");
        System.out.println("\nShop Balance: RM" + shopBalance);
    }
    //Method for menu 5
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
            System.out.println("Item found: " + itemName + " - Price: $" + itemPrice + " | Stock: " + itemStock);
        } else {
            System.out.println("Item not found.");
        }
    }
    //Method for menu 6
    public static void addItem(Scanner scanner) {
        System.out.println("=================");
        System.out.println("Menu 6 - Add Item");
        System.out.println("=================");

        System.out.print("Enter the new item name: ");
        String newItemName = scanner.next();

        int newItemIndex = Arrays.asList(items).indexOf(newItemName);

        if (newItemIndex != -1) {
            System.out.println("Item already exists. Please use the update item option.");
            return;
        }

        System.out.print("Enter the price for " + newItemName + ": RM");
        double newItemPrice = scanner.nextDouble();

        System.out.print("Enter the initial stock for " + newItemName + ": ");
        int newItemStock = scanner.nextInt();

        // Assuming items, itemPrices, and itemStocks are defined in MenuList class
        items = Arrays.copyOf(items, items.length + 1);
        itemPrices = Arrays.copyOf(itemPrices, itemPrices.length + 1);
        itemStocks = Arrays.copyOf(itemStocks, itemStocks.length + 1);

        items[items.length - 1] = newItemName;
        itemPrices[itemPrices.length - 1] = newItemPrice;
        itemStocks[itemStocks.length - 1] = newItemStock;

        System.out.println(
                "Added new item: " + newItemName + " | Price: RM" + newItemPrice + " | Initial Stock: " + newItemStock);
    }
    //Method for menu 7
    public static void deleteItem(Scanner scanner) {
        System.out.println("====================");
        System.out.println("Menu 7 - Delete Item");
        System.out.println("====================");
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
            System.out.println("Item not found!!! \n");
            deleteItem(scanner);
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
