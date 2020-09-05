package by.java.oop_5;

import by.java.oop_5.bean.client.Person;
import by.java.oop_5.bean.client.person_children.Client;
import by.java.oop_5.bean.storage.StorageGiftSweetnessPacking;
import by.java.oop_5.bean.storage.StorageSweetness;
import by.java.oop_5.bean.storage.exception.ApplicationInitializationException;
import by.java.oop_5.view.MenuApp;
import by.java.oop_5.view.Viewer;

import java.io.IOException;

public class GiftMain {

    public static void main(String[] args) throws ApplicationInitializationException {
        Client client = new Client("Леонова", "Анна", "Георгиевна", 31, Person.Sex.WOMEN);
        Viewer viewer = new Viewer();

        StorageSweetness storageSweetness = StorageSweetness.createInstance();
        StorageGiftSweetnessPacking storageGiftSweetnessPacking = StorageGiftSweetnessPacking.createInstance();

        storageSweetness.storageSweetnessInit();

        try {
            storageGiftSweetnessPacking.storageGiftSweetnessPackingInit();
        } catch (IOException e) {
            viewer.printErrorMessage(e.getMessage());
            throw new ApplicationInitializationException("Application initialization failed");
        }

        MenuApp menu = new MenuApp(client, storageSweetness, storageGiftSweetnessPacking);
        menu.mainMenu();
    }
}
