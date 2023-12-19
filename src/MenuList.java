import java.util.Map;
import java.util.Scanner;

public class MenuList {

    public static void viewItems() {
        System.out.println("===================");
        System.out.println("Menu 1 - Show Available Items");
        System.out.println("===================");
        System.out.println("\nItems available in the shop: \n");
        for (Map.Entry<String, Double> entry : App.itemPrices.entrySet()) {
            String itemName = entry.getKey();
            double itemPrice = entry.getValue();
            int itemStock = App.itemStocks.get(itemName);
            System.out.println(itemName + " - RM " + itemPrice + " | Stock: " + itemStock);
        }
    }

    public static void sellItem(Scanner scanner) {
        System.out.println("==================");
        System.out.println("Menu 2 - Sell Item");
        System.out.println("==================");

        for (Map.Entry<String, Double> entry : App.itemPrices.entrySet()) {
            String itemName = entry.getKey();
            System.out.println(itemName);
        }

        System.out.print("\nEnter the item name to sell: ");
        String itemName = scanner.next();
        if (App.itemPrices.containsKey(itemName) && App.itemStocks.get(itemName) > 0) {
            double itemPrice = App.itemPrices.get(itemName);
            App.itemStocks.put(itemName, App.itemStocks.get(itemName) - 1);
            App.shopBalance += itemPrice;
            System.out.println("Sold " + itemName + " for RM" + itemPrice);
        } else {
            System.out.println("Item not available or out of stock.");
        }
    }

    public static void restockItem(Scanner scanner) {
        System.out.println("=====================");
        System.out.println("Menu 3 - Restock Item");
        System.out.println("=====================");
        System.out.print("\nEnter the item name to restock: ");
        String itemName = scanner.next();

        if (App.itemPrices.containsKey(itemName)) {
            System.out.print("Enter the quantity to restock: ");
            int quantity = scanner.nextInt();
            App.itemStocks.put(itemName, App.itemStocks.get(itemName) + quantity);
            double totalCost = App.itemPrices.get(itemName) * quantity;
            App.shopBalance -= totalCost;
            System.out.println("Restocked " + quantity + " " + itemName + " for RM" + totalCost);
        } else {
            System.out.println("Invalid item name.");
        }
    }

    public static void viewShopBalance() {
        System.out.println("==========================");
        System.out.println("Menu 4 - View Shop Balance");
        System.out.println("==========================");
        System.out.println("\nShop Balance: RM" + App.shopBalance);
    }

    public static void searchItem(Scanner scanner) {
        System.out.print("\nEnter the item name to search: ");
        String itemName = scanner.next();

        if (App.itemPrices.containsKey(itemName)) {
            double itemPrice = App.itemPrices.get(itemName);
            int itemStock = App.itemStocks.get(itemName);
            System.out.println("Item found: " + itemName + " - Price: $" + itemPrice + " | Stock: " + itemStock);
        } else {
            System.out.println("Item not found.");
        }
    }

    public static void addItem(Scanner scanner) {
        System.out.println("================");
        System.out.println("Menu 6 - Add Item");
        System.out.println("================");

        System.out.print("Enter the new item name: ");
        String newItemName = scanner.next();

        if (App.itemPrices.containsKey(newItemName)) {
            System.out.println("Item already exists. Please use the update item option.");
            return;
        }

        System.out.print("Enter the price for " + newItemName + ": RM");
        double newItemPrice = scanner.nextDouble();

        System.out.print("Enter the initial stock for " + newItemName + ": ");
        int newItemStock = scanner.nextInt();

        App.itemPrices.put(newItemName, newItemPrice);
        App.itemStocks.put(newItemName, newItemStock);

        System.out.println("Added new item: " + newItemName + " | Price: RM" + newItemPrice + " | Initial Stock: " + newItemStock);
    }

    public static void deleteItem(Scanner scanner) {
        System.out.println("=====================");
        System.out.println("Menu 7 - Delete Item");
        System.out.println("=====================");
        System.out.print("\nEnter the item name to delete: ");
        String itemName = scanner.next();

        if (App.itemPrices.containsKey(itemName)) {
            // Remove the item from itemPrices and itemStocks
            App.itemPrices.remove(itemName);
            App.itemStocks.remove(itemName);
            System.out.println(itemName + " has been deleted.");
        } else {
            System.out.println("Item not found.");
        }
    }

}


