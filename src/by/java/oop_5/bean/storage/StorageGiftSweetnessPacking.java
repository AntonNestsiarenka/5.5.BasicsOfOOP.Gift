package by.java.oop_5.bean.storage;

import by.java.oop_5.bean.packing.packing_children.GiftPacking;
import by.java.oop_5.bean.packing.packing_children.factory.GiftPackingFactory;
import by.java.oop_5.bean.packing.packing_children.factory.GiftSweetnessPackingFactory;
import by.java.oop_5.bean.packing.packing_children.gift_packing_children.GiftSweetnessPacking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StorageGiftSweetnessPacking {

    private static StorageGiftSweetnessPacking storageGiftSweetnessPacking = null;
    private ArrayList<GiftSweetnessPacking> giftSweetnessPackings;

    private StorageGiftSweetnessPacking() {
        giftSweetnessPackings = new ArrayList<GiftSweetnessPacking>();
    }

    public ArrayList<GiftSweetnessPacking> getGiftSweetnessPackings() {
        return giftSweetnessPackings;
    }

    public void setGiftSweetnessPackings(ArrayList<GiftSweetnessPacking> giftSweetnessPackings) {
        this.giftSweetnessPackings = giftSweetnessPackings;
    }

    public static StorageGiftSweetnessPacking getStorageGiftSweetnessPacking() {
        return storageGiftSweetnessPacking;
    }

    public void addGiftSweetnessPacking(GiftSweetnessPacking giftSweetnessPacking)
    {
        giftSweetnessPackings.add(giftSweetnessPacking);
    }

    public void removeGiftSweetnessPacking(GiftSweetnessPacking giftSweetnessPacking)
    {
        giftSweetnessPackings.remove(giftSweetnessPacking);
    }

    public void clearStorage()
    {
        giftSweetnessPackings.clear();
    }

    public static StorageGiftSweetnessPacking createInstance()
    {
        if (storageGiftSweetnessPacking == null)
        {
            storageGiftSweetnessPacking = new StorageGiftSweetnessPacking();
        }
        return storageGiftSweetnessPacking;
    }

    public void storageGiftSweetnessPackingInit() throws IOException {
        // Инициализация всех доступных подарочных упаковок для приложения под сладости из файла.
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("gift_sweetness_packing_data.txt"));
            GiftPackingFactory giftPackingFactory = new GiftSweetnessPackingFactory();
            String currentLine;
            Pattern pattern = Pattern.compile("^(\\w+)( \\| \\d+.?\\d+)+$");
            while ((currentLine = bf.readLine()) != null) {
                Matcher matcher = pattern.matcher(currentLine);
                if (matcher.find()) {
                    String[] foundLine = matcher.group().split(" \\| ");
                    for (int i = 1; i < foundLine.length; i++) {
                        GiftSweetnessPacking giftSweetnessPacking = (GiftSweetnessPacking) giftPackingFactory.createGiftPacking();
                        giftSweetnessPacking.setTypeOfGiftPacking(GiftPacking.TypeOfGiftPacking.valueOf(foundLine[0].toUpperCase()));
                        giftSweetnessPacking.setMaxWeight(Double.valueOf(foundLine[i]));
                        giftSweetnessPackings.add(giftSweetnessPacking);
                    }
                }
            }
        }
        finally {
            if (bf != null) {
                bf.close();
            }
        }
    }

    @Override
    public String toString() {
        return "StorageGiftSweetnessPacking{" +
                "giftSweetnessPackings=" + giftSweetnessPackings +
                '}';
    }
}