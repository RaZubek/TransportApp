package cz.vsb.ekf.ill.service;

import cz.vsb.ekf.ill.dao.InitialDemoData;
import cz.vsb.ekf.ill.dto.Cargo;
import cz.vsb.ekf.ill.dto.Ship;
import java.util.List;
import java.util.Scanner;

public class ShipFound {

    public static void shipFound(InitialDemoData init, List<Ship> shipList) {
        String input;
        Ship ship = null;

        Scanner scanner = new Scanner(System.in);
        boolean userInput = true;
        boolean userInput2 = true;
        System.out.println("Search a ship? Y/N:");
        while (userInput) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("n")) {
                System.out.println("Thank you for using our app.");
                System.exit(0);
            } else if (input.equalsIgnoreCase("y")) {
                userInput = false;
                while (userInput2) {

                    System.out.println("Search ship by entering its ID/Name:");
                    input = scanner.nextLine();
                    ship = init.findShip(shipList, input);

                    if (ship == null) {
                        System.out.println("Ship with " + (InitialDemoData.isInteger(input) ? "ID " : "name ") + input + " doesn't exist");
                    } else {
                        userInput2 = false;
                    }
                }
            } else {
                System.out.println("Please enter valid input: ('y' or 'n')");
            }
        }

        if (ship != null) {
            System.out.println("Name:                 " + ship.getName());
            System.out.println("On way:               " + (ship.getOnWay() ? "Yes" : "No"));
            System.out.println("Capacity:             " + ship.getCapacity());
            System.out.println("Count of transports:  " + ship.getCountOfTransports());
            System.out.println("Average speed:        " + ship.getAvgSpeed() + " km/h");
            for (Cargo cargo : ship.getShipCargo()) {
                System.out.println("Cargo:   Description: " + cargo.getDescription());
                System.out.println("         Weight:      " + cargo.getWeight());
                System.out.println("         Total price: " + cargo.getTotalPrice());
            }
        }
    }
}
