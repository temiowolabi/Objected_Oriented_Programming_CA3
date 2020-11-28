package org.oopca3.temiowolabi;

public class Desktop extends Computer
{
    private String Monitor;

    public Desktop(String manufacturer, String processor, int ramSize, int diskSize, double weight, String assertTag, String purchaseDate, String monitor)
    {
        super(manufacturer, processor, ramSize, diskSize, weight, assertTag, purchaseDate);
        Monitor = monitor;
    }

    public String getMonitor()
    {
        return Monitor;
    }

    @Override
    public String toString()
    {
        return "Desktop{" +
                "Monitor='" + Monitor + '\'' +
                '}';
    }
}
