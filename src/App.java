import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        System.out.println(" ");
        System.out.println("**********************************************");
        System.out.println("*                                            *");
        System.out.println("* Welcome to Computer Shop Management System *");
        System.out.println("*           By ANDYDERIS & HAMIEZI           *");
        System.out.println("*                                            *");
        System.out.println("**********************************************");
        System.out.println(" ");

        // Show menu confirmation & option
        switchMenu();
    }

    public static void switchMenu() {

        System.out.println("Do you want to show Main Menu? (y/n) ");

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
                        System.out.println("======");
                        System.out.println("Menu 1");
                        System.out.println("======");
                        //Triangle.mainTri();
                        break;
                    case 2:
                        System.out.println("======");
                        System.out.println("Menu 2");
                        System.out.println("======");
                        //Number.mainNum();
                        break;
                    case 3:
                        System.out.println("======");
                        System.out.println("Menu 3");
                        System.out.println("======");
                        //LoopSum.mainLoop();
                        break;
                    case 4:
                        System.out.println("======");
                        System.out.println("Menu 4");
                        System.out.println("======");
                        //LoopSum.mainLoop();
                        break;
                    case 5:
                        System.out.println("======");
                        System.out.println("Menu 5");
                        System.out.println("======");
                        //LoopSum.mainLoop();
                        break;
                    case 6:
                        System.out.println("======");
                        System.out.println("Menu 6");
                        System.out.println("======");
                        //LoopSum.mainLoop();
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
        System.out.println("**********************************************");
        System.out.println("*                  MAIN MENU                 *");
        System.out.println("*           0. Exit                          *");
        System.out.println("*           1. MENU                          *");
        System.out.println("*           2. MENU                          *");
        System.out.println("*           3. MENU                          *");
        System.out.println("*           4. MENU                          *");
        System.out.println("*           5. MENU                          *");
        System.out.println("*           6. MENU                          *");
        System.out.println("**********************************************");
        System.out.print("Enter your menu: ");

        Scanner menu = new Scanner(System.in);
        // Validate that the user entered correct input
        while (!menu.hasNextInt()) {
            System.out.println("Invalid input please enter an integer! \n");
            menu.next();
        }
        return menu.nextInt();
    }
}
