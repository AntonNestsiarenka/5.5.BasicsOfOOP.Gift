package by.java.oop_5.bean.packing;

public abstract class Packing {

    /* Класс описывает абстрактную упаковку. */

    private double maxWeight;

    public Packing() {
        maxWeight = 0;
    }

    public Packing(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Packing packing = (Packing) o;
        return Double.compare(packing.maxWeight, maxWeight) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(maxWeight);
    }
}