package by.java.oop_5.bean.gift.gift_children;

import by.java.oop_5.bean.gift.Gift;
import by.java.oop_5.bean.packing.packing_children.gift_packing_children.GiftSweetnessPacking;

public class GiftSweetness extends Gift {

    /* Класс описывает подарок сладостей. */

    public GiftSweetness() {
        super();
        setPacking(new GiftSweetnessPacking());
    }

    public GiftSweetness(String name, GiftSweetnessPacking packing) {
        super(name, packing);
    }

}