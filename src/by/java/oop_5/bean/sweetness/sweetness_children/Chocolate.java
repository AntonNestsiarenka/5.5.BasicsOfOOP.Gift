package by.java.oop_5.bean.sweetness.sweetness_children;

import by.java.oop_5.bean.sweetness.Sweetness;
import java.util.Objects;

public class Chocolate extends Sweetness {

    /* Класс описывает шоколад. */

    private TypeOfChocolate typeOfChocolate;

    public Chocolate() {
        super();
        typeOfChocolate = TypeOfChocolate.MILK;
    }

    public Chocolate(String name, String manufacturer, double weight, TypeOfChocolate typeOfChocolate) {
        super(name, manufacturer, weight);
        this.typeOfChocolate = typeOfChocolate;
    }

    public Chocolate(Chocolate other)
    {
        this(other.getName(), other.getManufacturer(), other.getWeight(), TypeOfChocolate.valueOf(other.getTypeOfChocolate().name()));
    }

    public TypeOfChocolate getTypeOfChocolate() {
        return typeOfChocolate;
    }

    public void setTypeOfChocolate(TypeOfChocolate typeOfChocolate) {
        this.typeOfChocolate = typeOfChocolate;
    }

    @Override
    public String toString() {
        return typeOfChocolate.toString()
                + " | Название: " + getName()
                + " | Производитель: " + getManufacturer()
                + " | Вес: " + getWeight() + "г.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Chocolate chocolate = (Chocolate) o;
        return typeOfChocolate == chocolate.typeOfChocolate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfChocolate);
    }

    public enum TypeOfChocolate {

        MILK("Молочный"),
        BITTER("Горький"),
        WHITE("Белый");

        private String typeOfChocolate;

        TypeOfChocolate(String typeOfChocolate) {
            this.typeOfChocolate = typeOfChocolate;
        }

        public String getTypeOfChocolate() {
            return typeOfChocolate;
        }

        public void setTypeOfChocolate(String typeOfChocolate) {
            this.typeOfChocolate = typeOfChocolate;
        }

        @Override
        public String toString() {
            return "Тип шоколада: " + typeOfChocolate;
        }
    }
}