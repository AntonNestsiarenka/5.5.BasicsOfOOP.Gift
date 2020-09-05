package by.java.oop_5.bean.packing.packing_children.factory;

import by.java.oop_5.bean.packing.packing_children.gift_packing_children.GiftSweetnessPacking;

public final class GiftSweetnessPackingFactory implements GiftPackingFactory {

    /* Фабрика создания подарочной упаковки под сладости. */

    @Override
    public GiftSweetnessPacking createGiftPacking() {
        return new GiftSweetnessPacking();
    }
}
