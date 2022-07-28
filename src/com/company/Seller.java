package com.company;

public class Seller {

    final Shop shop;

    final int productionTime = 5000;
    final int buyingTime = 1000;

    public Seller(Shop shop) {
        this.shop = shop;
    }

    public synchronized void produceCar() {
            try {
                System.out.println(Thread.currentThread().getName() + " is producing car.");
                Thread.sleep(productionTime);
                shop.getCars().add(new Car());
                System.out.println(Thread.currentThread().getName() + " CAR IS PRODUCED.");
                notifyAll();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
    }

    public synchronized void sellCar() {
            try {
                System.out.println(Thread.currentThread().getName() + " entered car salon.");
                while (shop.getCars().isEmpty()) {
                    System.out.println("There are no cars.");
                    wait();
                }
                Thread.sleep(buyingTime);
                System.out.println(Thread.currentThread().getName() + " left with a new car!");
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            shop.getCars().remove(0);
        }
}
