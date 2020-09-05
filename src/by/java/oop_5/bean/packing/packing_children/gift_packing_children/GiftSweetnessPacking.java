package by.java.oop_5.bean.packing.packing_children.gift_packing_children;

import by.java.oop_5.bean.packing.packing_children.GiftPacking;
import by.java.oop_5.bean.sweetness.*;
import java.util.ArrayList;
import java.util.Objects;

public final class GiftSweetnessPacking extends GiftPacking {

    /* Класс описывает подарочную упаковку для сладостей. */

    private final ArrayList<Sweetness> sweetness;

    public GiftSweetnessPacking() {
        super();
        sweetness = new ArrayList<Sweetness>();
    }

    public GiftSweetnessPacking(double maxWeight, TypeOfGiftPacking typeOfGiftPacking) {
        super(maxWeight, typeOfGiftPacking);
        sweetness = new ArrayList<Sweetness>();
    }

    public GiftSweetnessPacking(GiftSweetnessPacking other)
    {
        this(other.getMaxWeight(), TypeOfGiftPacking.valueOf(other.getTypeOfGiftPacking().name()));
    }

    public ArrayList<Sweetness> getSweetness() {
        return sweetness;
    }

    public double getCurrentWeightGiftPacking()
    {
        double sumWeight = 0;
        for (Sweetness sweetness : sweetness)
        {
            sumWeight += sweetness.getWeight();
        }
        return sumWeight;
    }

    public void removeSweetness(Sweetness sweetness)
    {
        this.sweetness.remove(sweetness);
    }

    public void clearSweetness()
    {
        sweetness.clear();
    }

    @Override
    public String toString() {
        StringBuilder newStr = new StringBuilder(getTypeOfGiftPacking().toString() + " | Максимально допустимый вес упаковки: " + getMaxWeight() + " | Объекты внутри подарочной упаковки:\n");
        for (int i = 0; i < sweetness.size(); i++)
        {
            newStr.append(sweetness.get(i).toString() + "\n");
        }
        newStr.append("Текущий вес упаковки: " + String.valueOf(getCurrentWeightGiftPacking()) + "г.\n");
        return newStr.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GiftSweetnessPacking giftSweetnessPacking = (GiftSweetnessPacking) o;
        return sweetness.equals(giftSweetnessPacking.sweetness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sweetness);
    }
}