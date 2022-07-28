package com.company;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    final Seller seller = new Seller(this);
    final List<Car> cars = new ArrayList<>(10);


    public void sellCar() {
        for (int i = 0; i < 4; i++) {
            seller.sellCar();
        }
    }

    public void produceCar() {
        try {
            for (int i = 0; i < 10; i++) {
                seller.produceCar();
                Thread.sleep(2000);
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    List<Car> getCars() {
        return cars;
    }

}
