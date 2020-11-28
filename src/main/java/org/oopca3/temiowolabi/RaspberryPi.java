package org.oopca3.temiowolabi;

public class RaspberryPi extends Computer
{
    private String GPIOPins;
    private String sdCard;
    private int numGPIOPins;
    private double sdCardStorage;

    public RaspberryPi(String manufacturer, String processor, int ramSize, int diskSize, double weight, String assertTag, String purchaseDate, String GPIOPins, String sdCard, int numGPIOPins, double sdCardStorage)
    {
        super(manufacturer, processor, ramSize, diskSize, weight, assertTag, purchaseDate);
        this.GPIOPins = GPIOPins;
        this.sdCard = sdCard;
        this.numGPIOPins = numGPIOPins;
        this.sdCardStorage = sdCardStorage;
    }

    public String getGPIOPins() {
        return GPIOPins;
    }

    public String getSdCard() {
        return sdCard;
    }

    public int getNumGPIOPins() {
        return numGPIOPins;
    }

    public double getSdCardStorage() {
        return sdCardStorage;
    }

    @Override
    public String toString() {
        return "RaspberryPi{" +
                "GPIOPins='" + GPIOPins + '\'' +
                ", sdCard='" + sdCard + '\'' +
                ", numGPIOPins=" + numGPIOPins +
                ", sdCardStorage=" + sdCardStorage +
                '}';
    }
}
