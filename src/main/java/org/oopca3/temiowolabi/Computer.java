package org.oopca3.temiowolabi;

import java.time.LocalDate;

abstract public class Computer
{
    private String Manufacturer;
    private String Processor;
    private int ramSize;
    private int diskSize;
    private double Weight;
    private String assertTag; //every computer has this so they will all inherit this.
    private LocalDate purchaseDate;

    public Computer(String manufacturer, String processor, int ramSize, int diskSize, double weight, String assertTag, String dateOfPurchase)
    {
        Manufacturer = manufacturer;
        Processor = processor;
        this.ramSize = ramSize;
        this.diskSize = diskSize;
        Weight = weight;
        this.assertTag = assertTag;
        purchaseDate = LocalDate.parse(dateOfPurchase);
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public String getProcessor() {
        return Processor;
    }

    public int getRamSize() {
        return ramSize;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public double getWeight() {
        return Weight;
    }

    public String getAssertTag() {
        return assertTag;
    }

    public void setAssertTag(String assertTag) {
        this.assertTag = assertTag;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "Manufacturer='" + Manufacturer + '\'' +
                ", Processor='" + Processor + '\'' +
                ", ramSize=" + ramSize +
                ", diskSize=" + diskSize +
                ", Weight=" + Weight +
                ", assertTag='" + assertTag + '\'' +
                ", purchaseDate='" + purchaseDate + '\'' +
                '}';
    }
}
