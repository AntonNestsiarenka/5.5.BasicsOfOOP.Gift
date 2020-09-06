package by.java.oop_5.bean.storage;

import by.java.oop_5.bean.storage.exception.ApplicationInitializationException;
import by.java.oop_5.bean.sweetness.*;
import by.java.oop_5.bean.sweetness.factory.*;
import by.java.oop_5.bean.sweetness.sweetness_children.Candy;
import by.java.oop_5.bean.sweetness.sweetness_children.Chocolate;
import by.java.oop_5.bean.sweetness.sweetness_children.Halva;
import by.java.oop_5.bean.sweetness.sweetness_children.Marshmallow;
import by.java.oop_5.view.Viewer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StorageSweetness {

    private static StorageSweetness storageSweetness = null;
    private ArrayList<Sweetness> allSweetness;

    private StorageSweetness() {
        allSweetness = new ArrayList<Sweetness>();
    }

    public static StorageSweetness createInstance()
    {
        if (storageSweetness == null)
        {
            storageSweetness = new StorageSweetness();
        }
        return storageSweetness;
    }

    public static StorageSweetness getStorageSweetness() {
        return storageSweetness;
    }

    public ArrayList<Sweetness> getAllSweetness() {
        return allSweetness;
    }

    public void setAllSweetness(ArrayList<Sweetness> allSweetness) {
        this.allSweetness = allSweetness;
    }

    public void addSweetness(Sweetness sweetness)
    {
        allSweetness.add(sweetness);
    }

    public void removeSweetness(Sweetness sweetness)
    {
        allSweetness.remove(sweetness);
    }

    public void clearStorage()
    {
        allSweetness.clear();
    }

    private void initCandy() throws IOException
    {
        // Инициализация конфет для приложения.
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("candy_data.txt"));
            SweetnessFactory sweetnessFactory = new CandyFactory();
            String currentLine;
            Pattern pattern = Pattern.compile("^([а-яА-Яa-zA-Z\\-\\s\"]+) \\| ([а-яА-Яa-zA-Z\\-\\s\"]+) \\| (\\d+.?\\d+) \\| (\\w+)$");
            while ((currentLine = bf.readLine()) != null) {
                Matcher matcher = pattern.matcher(currentLine);
                if (matcher.find()) {
                    Candy candy = (Candy) sweetnessFactory.createSweetness();
                    candy.setName(matcher.group(1).trim());
                    candy.setManufacturer(matcher.group(2).trim());
                    candy.setWeight(Double.valueOf(matcher.group(3)));
                    candy.setTypeOfCandy(Candy.TypeOfCandy.valueOf(matcher.group(4).toUpperCase()));
                    allSweetness.add(candy);
                }
            }
        }
        finally {
            if (bf != null) {
                bf.close();
            }
        }
    }

    private void initChocolate() throws IOException
    {
        // Инициализация шоколада для приложения.
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("chocolate_data.txt"));
            SweetnessFactory sweetnessFactory = new ChocolateFactory();
            String currentLine;
            Pattern pattern = Pattern.compile("^([а-яА-Яa-zA-Z\\-\\s\"]+) \\| ([а-яА-Яa-zA-Z\\-\\s\"]+) \\| (\\d+.?\\d+) \\| (\\w+)$");
            while ((currentLine = bf.readLine()) != null) {
                Matcher matcher = pattern.matcher(currentLine);
                if (matcher.find()) {
                    Chocolate chocolate = (Chocolate) sweetnessFactory.createSweetness();
                    chocolate.setName(matcher.group(1).trim());
                    chocolate.setManufacturer(matcher.group(2).trim());
                    chocolate.setWeight(Double.valueOf(matcher.group(3)));
                    chocolate.setTypeOfChocolate(Chocolate.TypeOfChocolate.valueOf(matcher.group(4).toUpperCase()));
                    allSweetness.add(chocolate);
                }
            }
        }
        finally {
            if (bf != null) {
                bf.close();
            }
        }
    }

    private void initHalva() throws IOException
    {
        // Инициализация халвы для приложения.
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("halva_data.txt"));
            SweetnessFactory sweetnessFactory = new HalvaFactory();
            String currentLine;
            Pattern pattern = Pattern.compile("^([а-яА-Яa-zA-Z\\-\\s\"]+) \\| ([а-яА-Яa-zA-Z\\-\\s\"]+) \\| (\\d+.?\\d+) \\| (\\w+)$");
            while ((currentLine = bf.readLine()) != null) {
                Matcher matcher = pattern.matcher(currentLine);
                if (matcher.find()) {
                    Halva halva = (Halva) sweetnessFactory.createSweetness();
                    halva.setName(matcher.group(1).trim());
                    halva.setManufacturer(matcher.group(2).trim());
                    halva.setWeight(Double.valueOf(matcher.group(3)));
                    halva.setTypeOfHalva(Halva.TypeOfHalva.valueOf(matcher.group(4).toUpperCase()));
                    allSweetness.add(halva);
                }
            }
        }
        finally {
            if (bf != null) {
                bf.close();
            }
        }
    }

    private void initMarshmallow() throws IOException
    {
        // Инициализация зефира/пастилы для приложения.
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("marshmallow_data.txt"));
            SweetnessFactory sweetnessFactory = new MarshmallowFactory();
            String currentLine;
            Pattern pattern = Pattern.compile("^([а-яА-Яa-zA-Z\\-\\s\"]+) \\| ([а-яА-Яa-zA-Z\\-\\s\"]+) \\| (\\d+.?\\d+) \\| (\\w+)$");
            while ((currentLine = bf.readLine()) != null) {
                Matcher matcher = pattern.matcher(currentLine);
                if (matcher.find()) {
                    Marshmallow marshmallow = (Marshmallow) sweetnessFactory.createSweetness();
                    marshmallow.setName(matcher.group(1).trim());
                    marshmallow.setManufacturer(matcher.group(2).trim());
                    marshmallow.setWeight(Double.valueOf(matcher.group(3)));
                    marshmallow.setTypeOfMarshmallow(Marshmallow.TypeOfMarshmallow.valueOf(matcher.group(4).toUpperCase()));
                    allSweetness.add(marshmallow);
                }
            }
        }
        finally {
            if (bf != null) {
                bf.close();
            }
        }
    }

    public void storageSweetnessInit() throws ApplicationInitializationException {
        // Инициализация всех доступных сладостей для приложения из файлов.
        Viewer viewer = new Viewer();
        try {
            initCandy();
        } catch (IOException e) {
            viewer.printErrorMessage(e.getMessage());
            viewer.printErrorMessage("The application tries to initialize the following available data");
        }
        try {
            initChocolate();
        } catch (IOException e) {
            viewer.printErrorMessage(e.getMessage());
            viewer.printErrorMessage("The application tries to initialize the following available data");
        }
        try {
            initHalva();
        } catch (IOException e) {
            viewer.printErrorMessage(e.getMessage());
            viewer.printErrorMessage("The application tries to initialize the following available data");
        }
        try {
            initMarshmallow();
        } catch (IOException e) {
            viewer.printErrorMessage(e.getMessage());
        }
        if (allSweetness.size() == 0)
        {
            throw new ApplicationInitializationException("Application initialization failed");
        }
    }

    @Override
    public String toString() {
        return "StorageSweetness{" +
                "allSweetness=" + allSweetness +
                '}';
    }
}