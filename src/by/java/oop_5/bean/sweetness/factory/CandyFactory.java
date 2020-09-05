package by.java.oop_5.bean.sweetness.factory;

import by.java.oop_5.bean.sweetness.sweetness_children.Candy;

public final class CandyFactory implements SweetnessFactory {

    /* Фабрика создания конфет. */

    @Override
    public Candy createSweetness() {
        return new Candy();
    }
}
