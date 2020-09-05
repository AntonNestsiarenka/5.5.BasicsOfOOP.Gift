package by.java.oop_5.bean.gift;

import by.java.oop_5.bean.packing.packing_children.GiftPacking;

import java.util.Objects;

public abstract class Gift {

    /* Класс описывает абстрактный подарок. */

    private String name;
    private GiftPacking packing;

    public Gift() {
        name = "";
        packing = null;
    }

    public Gift(String name, GiftPacking packing) {
        this.name = name;
        this.packing = packing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GiftPacking getPacking() {
        return packing;
    }

    public void setPacking(GiftPacking packing) {
        this.packing = packing;
    }

    @Override
    public String toString() {
        return "Подарок: " + name + " | " + packing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gift gift = (Gift) o;
        return name.equals(gift.name) &&
                packing.equals(gift.packing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, packing);
    }
}