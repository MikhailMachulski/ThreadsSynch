package com.company;

public class Main {

    public static void main(String[] args) {
	final Shop shop = new Shop();

	Runnable buy = shop::sellCar;
	Runnable produce = shop::produceCar;

	    new Thread(null, buy, "Buyer 1").start();
        new Thread(null, buy, "Buyer 2").start();
        new Thread(null, buy, "Buyer 3").start();

        new Thread(null, produce, "Chevy").start();

    }

    }

