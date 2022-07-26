package com.company;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    final Seller seller = new Seller(this);
    final List<Car> cars = new ArrayList<>(10);


    public Car sellCar() {
        return seller.sellCar();
    }

    public void produceCar() {
        seller.produceCar();
    }

    List<Car> getCars() {
        return cars;
    }

}
