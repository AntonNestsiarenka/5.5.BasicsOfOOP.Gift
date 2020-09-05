package by.java.oop_5.bean.client.person_children;

import by.java.oop_5.bean.gift.gift_children.GiftSweetness;
import by.java.oop_5.bean.client.Person;
import java.util.ArrayList;
import java.util.Objects;

public class Client extends Person {

    private static long idUnique = 0;

    private long id;
    private String email;
    private ArrayList<GiftSweetness> giftsSweetness;

    public Client()
    {
        id = idUnique++;
        email = "";
        giftsSweetness = new ArrayList<GiftSweetness>();
    }

    public Client(String surname, String name, String patronymic, int age, Sex sex, String email) {
        super(surname, name, patronymic, age, sex);
        id = idUnique++;
        this.email = email;
        giftsSweetness = new ArrayList<GiftSweetness>();
    }

    public Client(String surname, String name, String patronymic, int age, Sex sex) {
        super(surname, name, patronymic, age, sex);
        id = idUnique++;
        giftsSweetness = new ArrayList<GiftSweetness>();
    }

    public void addGiftSweetness(GiftSweetness giftSweetness)
    {
        giftsSweetness.add(giftSweetness);
    }

    public void clearGiftsSweetness()
    {
        giftsSweetness.clear();
    }

    public static long getIdUnique() {
        return idUnique;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<GiftSweetness> getGiftsSweetness() {
        return giftsSweetness;
    }

    public void setGiftsSweetness(ArrayList<GiftSweetness> giftsSweetness) {
        this.giftsSweetness = giftsSweetness;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Пользователь id: " + id
                + " | " + getSurname()
                + " " +  getName()
                + " " + getPatronymic()
                + " | Возраст: " + getAge()
                + " | Пол: " + getSex().toString()
                + " | Email: " + ((email != null) ? email : "") + "\n");
        int i = 1;
        for (GiftSweetness giftSweetness : giftsSweetness)
        {
            str.append(i++ + ". " + giftSweetness.toString());
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(email, client.email) &&
                Objects.equals(giftsSweetness, client.giftsSweetness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, email, giftsSweetness);
    }
}