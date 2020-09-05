package by.java.oop_5.view;

import by.java.oop_5.bean.client.person_children.Client;
import by.java.oop_5.bean.gift.gift_children.GiftSweetness;
import by.java.oop_5.bean.storage.StorageGiftSweetnessPacking;
import by.java.oop_5.bean.storage.StorageSweetness;
import by.java.oop_5.logic.*;
import by.java.oop_5.logic.exception.NumberOfGiftSweetnessPackingOutOfBoundsException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuApp {

    public static final String MAIN_MENU = "Main command menu:\n" +
            "1. createGiftSweetness\n" +
            "2. createGiftSweetnessMix\n" +
            "3. printInfoMyGifts\n" +
            "4. clearMyGifts\n" +
            "5. help\n" +
            "6. quit\n";

    public static final String ADD_SWEETNESS_MENU = "Add sweetness command menu:\n" +
            "1. add\n" +
            "2. addByQuantity\n" +
            "3. finish\n" +
            "4. giftInfo\n" +
            "5. help\n" +
            "6. quit\n";

    private Client client;
    private StorageSweetness storageSweetness;
    private StorageSweetnessLogic storageSweetnessLogic;
    private StorageGiftSweetnessPacking storageGiftSweetnessPacking;
    private StorageGiftSweetnessPackingLogic storageGiftSweetnessPackingLogic;
    private Scanner scanner;
    private Viewer viewer;
    private ClientLogic clientLogic;
    private GiftSweetnessLogic giftSweetnessLogic;

    public MenuApp(Client client, StorageSweetness storageSweetness, StorageGiftSweetnessPacking storageGiftSweetnessPacking) {
        this.client = client;
        this.storageSweetness = storageSweetness;
        this.storageGiftSweetnessPacking = storageGiftSweetnessPacking;
        viewer = new Viewer();
        storageSweetnessLogic = new StorageSweetnessLogic(viewer);
        storageGiftSweetnessPackingLogic = new StorageGiftSweetnessPackingLogic(viewer);
        scanner = new Scanner(System.in);
        clientLogic = new ClientLogic(storageGiftSweetnessPacking);
        giftSweetnessLogic = new GiftSweetnessLogic(storageGiftSweetnessPacking, storageSweetness, viewer);
    }

    public void mainMenu()
    {
        // Главное меню приложения.
        boolean flag = true;
        viewer.printMessage(MAIN_MENU);
        while (flag)
        {
            String command = inputLine("Enter command: ").toLowerCase();
            switch (command)
            {
                case ("creategiftsweetness"):
                case ("1"):
                {
                    String nameOfGift = inputLine("Enter gift name: ");
                    storageGiftSweetnessPackingLogic.printAllGiftSweetnessPacking(storageGiftSweetnessPacking);
                    int numberOfGiftPacking = inputUInt("Enter the number of the desired gift box from the list above: ", scanner);
                    try {
                        GiftSweetness giftSweetness = giftSweetnessLogic.createGiftSweetness(nameOfGift, numberOfGiftPacking);
                        client.addGiftSweetness(giftSweetness);
                        addSweetnessMenu(giftSweetness);
                    } catch (NumberOfGiftSweetnessPackingOutOfBoundsException e) {
                        viewer.printMessage("Gift box with this number is out of stock. Gift not created.");
                    }
                    break;
                }
                case ("creategiftsweetnessmix"):
                case ("2"):
                {
                    String nameOfGift = inputLine("Enter gift name: ");
                    storageGiftSweetnessPackingLogic.printAllGiftSweetnessPacking(storageGiftSweetnessPacking);
                    int numberOfGiftPacking = inputUInt("Enter the number of the desired gift box from the list above: ", scanner);
                    try {
                        GiftSweetness giftSweetness = giftSweetnessLogic.createGiftSweetness(nameOfGift, numberOfGiftPacking);
                        giftSweetnessLogic.fillGiftSweetnessMix(giftSweetness);
                        client.addGiftSweetness(giftSweetness);
                    } catch (NumberOfGiftSweetnessPackingOutOfBoundsException e) {
                        viewer.printMessage("Gift box with this number is out of stock. Gift not created.");
                    }
                    break;
                }
                case ("printinfomygifts"):
                case ("3"):
                {
                    viewer.printMessage(client.toString());
                    break;
                }
                case ("clearmygifts"):
                case ("4"):
                {
                    client.clearGiftsSweetness();
                    viewer.printMessage("All gifts are cleared");
                    break;
                }
                case ("help"):
                case ("5"):
                {
                    viewer.printMessage("Description of all commands:\n" +
                            "1. createGiftSweetness - create a gift and fill it with sweets of the user's choice.\n" +
                            "2. createGiftSweetnessMix - create a gift and fill it with sweets at random.\n" +
                            "3. printInfoMyGifts - display all information about all gifts created by the user to the console.\n" +
                            "4. clearMyGifts - delete all gifts created by the user.\n" +
                            "5. help - description of all commands.\n" +
                            "6. quit - application shutdown.\n" +
                            "Commands can be entered case insensitive or using numbers.");
                    break;
                }
                case ("quit"):
                case ("6"):
                {
                    flag = false;
                    scanner.close();
                    break;
                }
                default:
                {
                    viewer.printMessage("Such a console command does not exist. For help, type help in the console.");
                }
            }
        }
    }

    private void addSweetnessMenu(GiftSweetness giftSweetness)
    {
        // Меню для добавления сладостей в подарок.
        boolean flag = true;
        viewer.printMessage(ADD_SWEETNESS_MENU);
        while (flag)
        {
            String command = inputLine("Enter command: ").toLowerCase();
            switch (command)
            {
                case ("add"):
                case ("1"):
                {
                    storageSweetnessLogic.printAllSweetness(storageSweetness);
                    int numberOfSweetness = inputUInt("Enter the number of the desired sweets from the list above to add as a gift: ", scanner);
                    giftSweetnessLogic.addSweetness(giftSweetness, numberOfSweetness);
                    break;
                }
                case ("addbyquantity"):
                case ("2"):
                {
                    storageSweetnessLogic.printAllSweetness(storageSweetness);
                    int numberOfSweetness = inputUInt("Enter the number of the desired sweets from the list above to add as a gift: ", scanner);
                    int countOfSweetness = inputUInt("Enter the number of sweets to add as a gift: ", scanner);
                    int countOfAdded = giftSweetnessLogic.addSweetnessByQuantity(giftSweetness, numberOfSweetness, countOfSweetness);
                    viewer.printMessage("Sweetness " + storageSweetness.getAllSweetness().get(numberOfSweetness - 1).getName() + " added as a gift in quantity " + countOfAdded + " pcs.");
                    break;
                }
                case ("finish"):
                case ("3"):
                {
                    String str = inputLine("Are you sure you want to finish adding a gift? After completing the addition, it will be impossible to add anything to this gift. Enter Yes / No: ").toLowerCase();
                    if (str.equals("yes"))
                    {
                        viewer.printMessage("Completed the addition of sweets to the gift.");
                        flag = false;
                    }
                    break;
                }
                case ("giftinfo"):
                case ("4"):
                {
                    viewer.printMessage(giftSweetness.toString());
                    break;
                }
                case ("help"):
                case ("5"):
                {
                    viewer.printMessage("Description of all commands:\n" +
                            "1. add - add a user-defined sweetness as a gift.\n" +
                            "2. addByQuantity - add a user-specified sweetness as a gift in a user-specified amount.\n" +
                            "3. finish - finish adding sweets as a gift.\n" +
                            "4. giftInfo - displaying information about the gift filled with sweets.\n" +
                            "5. help - description of all commands.\n" +
                            "6. quit - application shutdown.\n" +
                            "Commands can be entered case insensitive or using numbers.");
                    break;
                }
                case ("quit"):
                case ("6"):
                {
                    scanner.close();
                    System.exit(0);
                }
                default:
                {
                    viewer.printMessage("Such a console command does not exist. For help, type help in the console.");
                }
            }
        }
    }

    private int inputUInt(String str, Scanner scanner) {
        // Метод для ввода целочисленного положительного значения из консоли.
        System.out.print(str);
        int number;
        try {
            number = scanner.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("The entered data is incorrect. An integer is expected for input.");
            scanner.nextLine();
            return inputUInt(str, scanner);
        }
        if (number >= 0)
            return number;
        System.out.println("The number must be positive.");
        return inputUInt(str, scanner);
    }

    private String inputLine(String str) {
        // Метод для ввода строки из консоли.
        System.out.print(str);
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        return text;
    }
}
