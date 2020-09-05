package by.java.oop_5.bean.sweetness.factory;

import by.java.oop_5.bean.sweetness.sweetness_children.Halva;

public final class HalvaFactory implements SweetnessFactory {

    /* Фабрика создания халвы. */

    @Override
    public Halva createSweetness() {
        return new Halva();
    }
}
