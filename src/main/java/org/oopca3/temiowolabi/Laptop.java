package org.oopca3.temiowolabi;

import java.time.LocalDate;

public class Laptop extends Computer
{
    private double screenSize;
    private int batteryLife;

    public Laptop(String manufacturer, String processor, int ramSize, int diskSize, double weight, String assertTag, String dateOfPurchase, double screenSize, int batteryLife) {
        super(manufacturer, processor, ramSize, diskSize, weight, assertTag, dateOfPurchase);
        this.screenSize = screenSize;
        this.batteryLife = batteryLife;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "screenSize=" + screenSize +
                ", batteryLife=" + batteryLife +
                '}';
    }
}
