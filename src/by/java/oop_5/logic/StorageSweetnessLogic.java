package by.java.oop_5.logic;

import by.java.oop_5.bean.storage.StorageSweetness;
import by.java.oop_5.bean.sweetness.Sweetness;
import by.java.oop_5.view.Viewer;

public class StorageSweetnessLogic {

    private Viewer viewer;

    public StorageSweetnessLogic()
    {
        viewer = new Viewer();
    }

    public StorageSweetnessLogic(Viewer viewer)
    {
        this.viewer = viewer;
    }

    public void printAllSweetness(StorageSweetness storageSweetness)
    {
        // Выводит в консоль все доступные сладости для создания подарков.
        viewer.printMessage("Names of all available sweets.");
        int i = 1;
        for (Sweetness sweetness : storageSweetness.getAllSweetness())
        {
            String number = i++ + ". ";
            viewer.printMessage(number + sweetness.toString());
        }
    }
}
