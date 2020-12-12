package org.oopca3.temiowolabi;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

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
        if (getComputerById(c.getAssertTag()) != null) {
            System.out.println("Computer with this Assert Tag already exists.");
        }
//        computerList.add( c );
    }

    public void loadComputersFromFile()
    {

            try(Scanner computersFile = new Scanner(new BufferedReader(new FileReader("computers.txt"))))
            {
            String input;
            while (computersFile.hasNextLine()) {

                input = computersFile.nextLine();
                String[] data = input.split(",");
                String Manufacturer = data[0];
                String Processor = data[1];
                int ramSize = Integer.parseInt(data[2]);
                int diskSize = Integer.parseInt(data[3]);
                double Weight = Double.parseDouble(data[4]);
                String assertTag = data[5];
                String purchaseDate = data[6];

               // LocalDate purchaseDate = LocalDate.parse(sc.next());

                Computer readInComputer = new Computer(Manufacturer, Processor, ramSize, diskSize, Weight, assertTag, purchaseDate);
                this.computerList.add(readInComputer);

            }

        }
        catch (IOException e) {
            System.out.println("IOException thrown in loadComputersFromFile() "+e.getMessage());
        }


    }

    public void saveComputersToFile()
    {
        try(BufferedWriter computersFile = new BufferedWriter(new FileWriter("computers.txt") ))
        {
            for(Computer computer : computerList)
            {
                computersFile.write(computer.getManufacturer() +","+computer.getProcessor()+","+computer.getRamSize()+","+computer.getDiskSize()+","+computer.getWeight()+","+computer.getAssertTag()+","+computer.getPurchaseDate());
                computersFile.write("\n");
            }
        }
        catch(IOException ioe)
        {
            System.out.println(Colours.RED + "Could not save computers." +Colours.RESET);
        }
    }

}
