package by.java.oop_5.bean.sweetness.sweetness_children;

import by.java.oop_5.bean.sweetness.Sweetness;
import java.util.Objects;

public class Marshmallow extends Sweetness {

    /* Класс описывает пастилу/зефир. */

    private TypeOfMarshmallow typeOfMarshmallow;

    public Marshmallow() {
        super();
        typeOfMarshmallow = TypeOfMarshmallow.WHITE;
    }

    public Marshmallow(String name, String manufacturer, double weight, TypeOfMarshmallow typeOfMarshmallow) {
        super(name, manufacturer, weight);
        this.typeOfMarshmallow = typeOfMarshmallow;
    }

    public Marshmallow(Marshmallow other)
    {
        this(other.getName(), other.getManufacturer(), other.getWeight(), TypeOfMarshmallow.valueOf(other.getTypeOfMarshmallow().name()));
    }

    public TypeOfMarshmallow getTypeOfMarshmallow() {
        return typeOfMarshmallow;
    }

    public void setTypeOfMarshmallow(TypeOfMarshmallow typeOfMarshmallow) {
        this.typeOfMarshmallow = typeOfMarshmallow;
    }

    @Override
    public String toString() {
        return typeOfMarshmallow.toString()
                + " | Название: " + getName()
                + " | Производитель: " + getManufacturer()
                + " | Вес: " + getWeight() + "г.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Marshmallow that = (Marshmallow) o;
        return typeOfMarshmallow == that.typeOfMarshmallow;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfMarshmallow);
    }

    public enum TypeOfMarshmallow {

        WHITE("Белый"),
        PINK("Розовый"),
        GREEN("Зеленый"),
        CHOCOLATE("Шоколадный");

        private String typeOfMarshmallow;

        TypeOfMarshmallow(String typeOfMarshmallow) {
            this.typeOfMarshmallow = typeOfMarshmallow;
        }

        public String getTypeOfMarshmallow() {
            return typeOfMarshmallow;
        }

        public void setTypeOfMarshmallow(String typeOfMarshmallow) {
            this.typeOfMarshmallow = typeOfMarshmallow;
        }

        @Override
        public String toString() {
            return "Тип пастилы/зефира: " + typeOfMarshmallow;
        }
    }
}