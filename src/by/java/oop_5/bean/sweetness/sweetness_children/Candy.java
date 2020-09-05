package by.java.oop_5.bean.sweetness.sweetness_children;

import by.java.oop_5.bean.sweetness.Sweetness;
import java.util.Objects;

public class Candy extends Sweetness {

    /* Класс описывает конфету. */

    private TypeOfCandy typeOfCandy;

    public Candy() {
        super();
        typeOfCandy = TypeOfCandy.CHOCOLATE;
    }

    public Candy(String name, String manufacturer, double weight, TypeOfCandy typeOfCandy) {
        super(name, manufacturer, weight);
        this.typeOfCandy = typeOfCandy;
    }

    public Candy(Candy other)
    {
        this(other.getName(), other.getManufacturer(), other.getWeight(), TypeOfCandy.valueOf(other.getTypeOfCandy().name()));
    }

    public TypeOfCandy getTypeOfCandy() {
        return typeOfCandy;
    }

    public void setTypeOfCandy(TypeOfCandy typeOfCandy) {
        this.typeOfCandy = typeOfCandy;
    }

    @Override
    public String toString() {
        return typeOfCandy.toString()
                + " | Название: " + getName()
                + " | Производитель: " + getManufacturer()
                + " | Вес: " + getWeight() + "г.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Candy candy = (Candy) o;
        return typeOfCandy == candy.typeOfCandy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfCandy);
    }

    public enum TypeOfCandy {

        CHOCOLATE("Шоколад"),
        LOLLIPOP("Леденец"),
        CARAMEL("Карамель"),
        IRIS("Ирис");

        private String typeOfCandy;

        TypeOfCandy(String typeOfCandy) {
            this.typeOfCandy = typeOfCandy;
        }

        public String getTypeOfCandy() {
            return typeOfCandy;
        }

        public void setTypeOfCandy(String typeOfCandy) {
            this.typeOfCandy = typeOfCandy;
        }

        @Override
        public String toString() {
            return "Тип конфеты: " + typeOfCandy;
        }
    }
}