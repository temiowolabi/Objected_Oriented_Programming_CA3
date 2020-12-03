package org.oopca3.temiowolabi;

import java.util.ArrayList;

public class ComputerDB
{
    ArrayList<Computer> computerList;

    public ComputerDB() {
        this.computerList = new ArrayList<>();
    }

    public Computer getComputerById(String computerID)
    {
        for(Computer c : computerList) {
            if (c.getAssertTag().equals(computerID)) {
                return c;
            }
        }
                return null;
    }

    public void addComputer( Computer c)
    {
        computerList.add( c );
    }

}
