package com.company;

public class Main {

    public static void main(String[] args) {
	final Shop shop = new Shop();

	Runnable buy = shop::sellCar;

	    new Thread(null, buy, "Buyer 1").start();
        new Thread(null, buy, "Buyer 2").start();


        new Thread(null, shop::produceCar, "Chevy").start();

    }
}
