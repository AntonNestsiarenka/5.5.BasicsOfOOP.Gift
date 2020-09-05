package by.java.oop_5.bean.sweetness;

public abstract class Sweetness {

    /* Класс описывает абстрактную сладость. */

    private String name;
    private String manufacturer;
    private double weight;

    public Sweetness() {
        name = "";
        manufacturer = "";
        weight = 0;
    }

    public Sweetness(String name, String manufacturer, double weight) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sweetness sweetness = (Sweetness) o;
        return name.equals(sweetness.name) &&
                manufacturer.equals(sweetness.manufacturer)
                && Double.compare(sweetness.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (name != null ? name.hashCode() : 0);
        result = 37 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 37 * result + Double.hashCode(weight);
        return result;
    }
}
