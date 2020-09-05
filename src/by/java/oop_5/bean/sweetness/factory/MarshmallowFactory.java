package by.java.oop_5.bean.sweetness.factory;

import by.java.oop_5.bean.sweetness.sweetness_children.Marshmallow;

public final class MarshmallowFactory implements SweetnessFactory {

    /* Фабрика создания пастилы/зефира. */

    @Override
    public Marshmallow createSweetness() {
        return new Marshmallow();
    }
}