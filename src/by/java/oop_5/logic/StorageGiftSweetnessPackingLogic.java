package by.java.oop_5.logic;

import by.java.oop_5.bean.packing.packing_children.gift_packing_children.GiftSweetnessPacking;
import by.java.oop_5.bean.storage.StorageGiftSweetnessPacking;
import by.java.oop_5.view.Viewer;

public class StorageGiftSweetnessPackingLogic {

    private Viewer viewer;

    public StorageGiftSweetnessPackingLogic()
    {
        viewer = new Viewer();
    }

    public StorageGiftSweetnessPackingLogic(Viewer viewer)
    {
        this.viewer = viewer;
    }

    public void printAllGiftSweetnessPacking(StorageGiftSweetnessPacking storageGiftSweetnessPacking)
    {
        // Выводит в консоль все доступные подарочные упаковки под сладости.
        viewer.printMessage("All available gift wraps.");
        int i = 1;
        for (GiftSweetnessPacking giftSweetnessPacking : storageGiftSweetnessPacking.getGiftSweetnessPackings())
        {
            viewer.printMessage(i + ". " + giftSweetnessPacking.toString());
            i++;
        }
    }
}
