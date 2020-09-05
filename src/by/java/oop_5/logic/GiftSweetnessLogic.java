package by.java.oop_5.logic;

import by.java.oop_5.bean.gift.factory.GiftFactory;
import by.java.oop_5.bean.gift.factory.GiftSweetnessFactory;
import by.java.oop_5.bean.gift.gift_children.GiftSweetness;
import by.java.oop_5.bean.packing.packing_children.GiftPacking;
import by.java.oop_5.bean.packing.packing_children.gift_packing_children.GiftSweetnessPacking;
import by.java.oop_5.bean.storage.StorageGiftSweetnessPacking;
import by.java.oop_5.bean.storage.StorageSweetness;
import by.java.oop_5.bean.sweetness.Sweetness;
import by.java.oop_5.bean.sweetness.sweetness_children.Candy;
import by.java.oop_5.bean.sweetness.sweetness_children.Chocolate;
import by.java.oop_5.bean.sweetness.sweetness_children.Halva;
import by.java.oop_5.bean.sweetness.sweetness_children.Marshmallow;
import by.java.oop_5.logic.exception.NumberOfGiftSweetnessPackingOutOfBoundsException;
import by.java.oop_5.view.Viewer;

public class GiftSweetnessLogic {

    private StorageGiftSweetnessPacking storageGiftSweetnessPacking;
    private StorageSweetness storageSweetness;
    private Viewer viewer;

    public GiftSweetnessLogic(StorageGiftSweetnessPacking storageGiftSweetnessPacking, StorageSweetness storageSweetness, Viewer viewer)
    {
        this.storageGiftSweetnessPacking = storageGiftSweetnessPacking;
        this.storageSweetness = storageSweetness;
        this.viewer = viewer;
    }

    public GiftSweetness createGiftSweetness(String nameOfGift, int numberOfGiftPacking) throws NumberOfGiftSweetnessPackingOutOfBoundsException
    {
        // Создает подарок сладостей.
        if (numberOfGiftPacking >= 1 && numberOfGiftPacking <= storageGiftSweetnessPacking.getGiftSweetnessPackings().size())
        {
            GiftFactory giftFactory = new GiftSweetnessFactory();
            double maxWeight = storageGiftSweetnessPacking.getGiftSweetnessPackings().get(numberOfGiftPacking - 1).getMaxWeight();
            GiftPacking.TypeOfGiftPacking typeOfGiftPacking = storageGiftSweetnessPacking.getGiftSweetnessPackings().get(numberOfGiftPacking - 1).getTypeOfGiftPacking();
            GiftSweetness giftSweetness = (GiftSweetness) giftFactory.createGift();
            giftSweetness.setName(nameOfGift);
            giftSweetness.setPacking(new GiftSweetnessPacking(maxWeight, typeOfGiftPacking));
            return giftSweetness;
        }
        else
        {
            throw new NumberOfGiftSweetnessPackingOutOfBoundsException("Preset number of gift wrapping for sweets out of range");
        }
    }

    public void fillGiftSweetnessMix(GiftSweetness giftSweetness)
    {
        // Заполняет подарок случайными сладостями.
        int numberOfSweetness = randInt(0, storageSweetness.getAllSweetness().size() - 1);
        while(addSweetness(giftSweetness, storageSweetness.getAllSweetness().get(numberOfSweetness)))
        {
            numberOfSweetness = randInt(0, storageSweetness.getAllSweetness().size() - 1);
        }
    }

    public void addSweetness(GiftSweetness giftSweetness, int numberOfSweetness)
    {
        // Добавляет в заданный подарок заданную сладость из хранилища всех доступных сладостей.
        if (checkNumberOfSweetnessInStorageSweetness(numberOfSweetness))
        {
            if (addSweetness(giftSweetness, storageSweetness.getAllSweetness().get(numberOfSweetness - 1)))
            {
                viewer.printMessage("Sweetness " + storageSweetness.getAllSweetness().get(numberOfSweetness - 1).getName() + " added as a gift.");
            }
            else
            {
                viewer.printMessage("Sweetness " + storageSweetness.getAllSweetness().get(numberOfSweetness - 1).getName() + " not added as a gift. Gift wrap is full.");
            }
        }
        else
        {
            viewer.printMessage("User-defined sweetness not available.");
        }
    }

    public int addSweetnessByQuantity(GiftSweetness giftSweetness, int numberOfSweetness, int countOfSweetness)
    {
        // Добавляет в подарок заданную сладость из хранилища всех доступных сладостей в заданном количестве.
        if(checkNumberOfSweetnessInStorageSweetness(numberOfSweetness)) {
            Sweetness sweetness = storageSweetness.getAllSweetness().get(numberOfSweetness - 1);
            int count = 0;
            for (int i = 0; i < countOfSweetness; i++) {
                if (addSweetness(giftSweetness, sweetness)) {
                    count++;
                } else {
                    viewer.printMessage("Sweetness " + sweetness.getName() + " not added as a gift. Gift wrap is full.");
                    break;
                }
            }
            return count;
        }
        viewer.printMessage("User-defined sweetness not available.");
        return 0;
    }

    private boolean checkNumberOfSweetnessInStorageSweetness(int numberOfSweetness)
    {
        // Проверяет входит ли номер сладости в диапазон хранилища всех доступных сладостей.
        return numberOfSweetness >= 1 && numberOfSweetness <= storageSweetness.getAllSweetness().size();
    }

    private int randInt(int lowLimit, int highLimit)
    {
        // Генерация случайного целого значения в диапазоне [lowLimit, highlimit].
        if (lowLimit > highLimit)
        {
            int temp = lowLimit;
            lowLimit = highLimit;
            highLimit = temp;
        }
        int randomNumber = lowLimit + (int)(Math.random() * (highLimit - lowLimit + 1));
        return randomNumber;
    }

    private boolean addSweetness(GiftSweetness giftSweetness, Sweetness sweetness)
    {
        // Добавляет в подарок заданную сладость (новый объект), если у подарка еще есть место.
        GiftSweetnessPacking giftSweetnessPacking = (GiftSweetnessPacking) giftSweetness.getPacking();
        if (sweetness.getWeight() + giftSweetnessPacking.getCurrentWeightGiftPacking() <= giftSweetnessPacking.getMaxWeight()) {
            Sweetness sweetnessNew = null;
            if (sweetness instanceof Candy) {
                Candy candy = (Candy) sweetness;
                sweetnessNew = new Candy(candy);
            }
            else if (sweetness instanceof Chocolate)
            {
                Chocolate chocolate = (Chocolate) sweetness;
                sweetnessNew = new Chocolate(chocolate);
            }
            else if (sweetness instanceof Halva)
            {
                Halva halva = (Halva) sweetness;
                sweetnessNew = new Halva(halva);
            }
            else if (sweetness instanceof Marshmallow)
            {
                Marshmallow marshmallow = (Marshmallow) sweetness;
                sweetnessNew = new Marshmallow(marshmallow);
            }
            giftSweetnessPacking.getSweetness().add(sweetnessNew);
            return true;
        }
        return false;
    }


}
