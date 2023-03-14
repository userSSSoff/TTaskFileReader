// TODO: 11.02.2023
//  Реализовать readFile(). Логика проста...
//  Вытащить данные из текстового файла и записать их к объекту класса City.
//  Небольшая подсказказка можно использовать метод .split() класса String.

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

// TODO: 11.02.2023
//  После того как ты закончил предыдущий метод можешь приступить к следуещему.
//  Вся суть printAllCities() заключается в том, что надо вывести все города на консоль.
public class CityMethodsImpl implements CityMethods {


    @Override
    public City[] readFile() {
        City[] cities = new City[1109];
        try (FileReader fileReader = new FileReader("city_ru.csv");) {
            Scanner sc = new Scanner(fileReader);
            int i = 0;
            while (sc.hasNext()) {
                String[] fileContent = sc.nextLine().split(";");
                City city = new City();
                city.setId(Integer.parseInt(fileContent[0]));
                city.setName(fileContent[1]);
                city.setRegion(fileContent[2]);
                city.setDistrict(fileContent[3]);
                city.setPopulation(Integer.parseInt(fileContent[4]));
                try {
                    city.setFoundation(fileContent[5]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    city.setFoundation(null);
                }
                cities[i] = city;
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cities;
    }

    @Override
    public void printAllCities(City[] cities) {
        for (City city : cities) {
            System.out.println(city);
        }
    }

    @Override
    public void groupByRegion(City[] cities) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Region!");
        String getNameRegion = sc.nextLine();
        for (City c : cities) {
            if (c.getRegion().equals(getNameRegion)) {
                System.out.println(c);
            }
        }
    }

    @Override
    public void searchByName(String name) {
        City[] cities = readFile();
        for (int i = 0; i < cities.length; i++) {
            if (name.equals(cities[i].getName())) {
                System.out.println(cities[i]);
            }
        }
    }
}
