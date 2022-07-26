package com.company;

public class Seller {

    final int producingTime = 2000;
    final int choosingTime = 500;
    final Shop shop;

    public Seller(Shop shop) {
        this.shop = shop;
    }

    public synchronized void produceCar() {
            try {
                System.out.println(Thread.currentThread().getName() + " is producing car.");
                Thread.sleep(2000);
                shop.getCars().add(new Car());
                System.out.println(Thread.currentThread().getName() + " CAR IS PRODUCED.");
                notifyAll();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
    }

    public synchronized Car sellCar() {
            try {
                System.out.println(Thread.currentThread().getName() + " entered car salon.");
                Thread.sleep(1000);
                while (shop.getCars().isEmpty()) {
                    System.out.println("There are no cars.");
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + " left with a new car!");
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            return shop.getCars().remove(0);
        }
}
