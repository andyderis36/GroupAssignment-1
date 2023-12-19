import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static Map<String, Double> itemPrices = new HashMap<>();
    public static Map<String, Integer> itemStocks = new HashMap<>();
    public static double shopBalance = 10000.0; // Initial shop balance

    public static void main(String[] args) {

        System.out.println(" ");
        System.out.println("************************************************");
        System.out.println("*                                              *");
        System.out.println("*  Welcome to Computer Shop Management System  *");
        System.out.println("*                                              *");
        System.out.println("************************************************");
        System.out.println(" ");
        
        initializeItems();
        switchMenu();
    }   
        
    public static void initializeItems() {
            itemPrices.put("mouse", 20.0);
            itemPrices.put("keyboard", 30.0);
            itemPrices.put("monitor", 150.0);
            itemPrices.put("desktop", 500.0);
    
            itemStocks.put("mouse", 50);
            itemStocks.put("keyboard", 30);
            itemStocks.put("monitor", 20);
            itemStocks.put("desktop", 10);
    }

    public static void switchMenu() {

            System.out.println("\nDo you want to show Main Menu? (y/n) ");
    
            Scanner scanner = new Scanner(System.in);
            // Get user confirmation
            char confirmation = scanner.next().charAt(0);
    
            if (confirmation == 'y' || confirmation == 'Y') {
    
                int menu = displayMenu();
                do {
    
                    // Now you can use the 'menu' variable as needed
                    switch (menu) {
                        case 0:
                            System.out.println("Exiting the program. Goodbye! \n");
                            break;
                        case 1:
                            MenuList.viewItems();
                            switchMenu();
                            break;
                        case 2:
                            MenuList.sellItem(scanner);
                            switchMenu();
                            break;
                        case 3:
                            MenuList.restockItem(scanner);
                            switchMenu();
                            break;
                        case 4:
                            MenuList.viewShopBalance();
                            switchMenu();
                            break;
                        case 5:
                            MenuList.searchItem(scanner);
                            switchMenu();
                            break;
                        case 6:
                            MenuList.addItem(scanner);
                            switchMenu();
                            break;
                        case 7:
                            MenuList.deleteItem(scanner);
                            switchMenu();
                            break;
                        default:
                            System.out.println("Menu not available. Please choose menu from given list! \n");
                            switchMenu();
                    }
                    break;
                } while (menu != 0);
    
            } else if (confirmation == 'n' || confirmation == 'N') {
                System.out.println("Menu not displayed. Exiting the program. Goodbye! \n");
    
            } else {
                System.out.println("Invalid input! \n");
                switchMenu();
            }
    
            // Close the scanner
            scanner.close();
    }
    
    public static int displayMenu() {
    
            // Menu Option Display
            System.out.println(" ");
            System.out.println("***********************************************");
            System.out.println("*                  MAIN MENU                  *");
            System.out.println("*           0. Exit                           *");
            System.out.println("*           1. Show Available Items           *");
            System.out.println("*           2. Sell Item                      *");
            System.out.println("*           3. Restock Item                   *");
            System.out.println("*           4. Show Shop Balance              *");
            System.out.println("*           5. Search Item                    *");
            System.out.println("*           6. Add New Item                   *");
            System.out.println("*           7. Delete Item                   *");
            System.out.println("***********************************************");
            System.out.print("Enter your menu: ");
        
            Scanner menu = new Scanner(System.in);

            // Validate that the user entered correct input
            while (!menu.hasNextInt()) {
                System.out.println("Invalid input please enter an integer! \n");
                menu.next();
            }
            System.out.print("\n");
            return menu.nextInt();
    }
}
