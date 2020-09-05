package by.java.oop_5.bean.sweetness.factory;

import by.java.oop_5.bean.sweetness.sweetness_children.Chocolate;

public final class ChocolateFactory implements SweetnessFactory {

    /* Фабрика создания шоколада. */

    @Override
    public Chocolate createSweetness() {
        return new Chocolate();
    }
}
