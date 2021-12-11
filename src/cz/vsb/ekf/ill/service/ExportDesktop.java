package cz.vsb.ekf.ill.service;

import cz.vsb.ekf.ill.TransportApp;
import cz.vsb.ekf.ill.dto.Ship;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;


public class ExportDesktop {

    public static void exportDesktop(List<Ship> shipList) {

        System.out.println("Do you want to export all the ships and its cargo to external file? Y/N");
        Scanner scPrint = new Scanner(System.in);
        boolean bools = true;
        FileWriter shipsWithCargo = null;

        while (bools) {
            try {

                String scanner = scPrint.nextLine().toLowerCase();
                if (scanner.equals("y")) {
                    System.out.println("Successfully exported to file Ships.txt.");
                    shipsWithCargo = new FileWriter(new File("Ships.txt"));
                    PrintWriter pw = new PrintWriter(shipsWithCargo);
                    for (Ship a : shipList) {
                        pw.println(a);
                    }
                    bools = false;
                    pw.close();


                } else if (scanner.equals("n")) {
                    System.out.println("Thank you for using our app.");
                    System.exit(0);
                } else {
                    System.out.println("Please enter valid input: ('y' or 'n')");
                }

            } catch(IOException ex) {
                System.out.println("Chyba");
            } catch (Exception ex) {
                System.out.println("Following error occured: " + ex.getMessage());
            }

        }
    }
}
