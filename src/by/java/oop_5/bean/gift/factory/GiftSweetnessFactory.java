package by.java.oop_5.bean.gift.factory;

import by.java.oop_5.bean.gift.gift_children.GiftSweetness;

public final class GiftSweetnessFactory implements GiftFactory {

    /* Фабрика создания подарков под сладости. */

    @Override
    public GiftSweetness createGift() {
        return new GiftSweetness();
    }
}
