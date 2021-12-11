package cz.vsb.ekf.ill.service;

import cz.vsb.ekf.ill.dto.Cargo;
import cz.vsb.ekf.ill.dto.Port;
import cz.vsb.ekf.ill.dto.Route;
import cz.vsb.ekf.ill.dto.Ship;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class ShippingTime {

    public static void shippingTime(List<Ship> shipList) {

        try {
            Scanner scanner = new Scanner(System.in);
            Integer id;
            double distance;
            Route route = new Route();
            while (true) {
                System.out.println("Enter numbers 0-9 to choose port A.");
                int i = 0;
                for (Port p : Port.values()) {
                    System.out.print(i + ": " + p + ", ");
                    i++;
                }
                System.out.println("");
                int a = scanner.nextInt();
                if (a < 0 || a > 9) {
                    System.out.println("Try again. You did not enter any number from the number options we gave you.");
                    System.out.println("");
                    continue;
                }

                Port[] port = Port.values();

                for (Port p : port) {
                    if (a == p.ordinal()) {
                        System.out.println("Port " + p.name() + " succesfully set as A.");
                        route.setStartPort(Port.valueOf(p.name()));
                    }
                }

                System.out.println("-------------------");
                System.out.println("Enter numbers 0-9 to choose port B.");

                int b = scanner.nextInt();
                if (a == b) {
                    System.out.println("You already are at port " + a);
                    System.out.println("Try again.");
                    System.out.println("");
                    continue;
                } else if (b < 0 || b > 9) {
                    System.out.println("Error! You can only choose from the number options we gave you.");
                    System.out.println("");
                    continue;
                }

                for (Port p : port) {
                    if (b == p.ordinal()) {
                        System.out.println("Port " + p.name() + " successfully set as B.");
                        route.setStartPort(Port.valueOf(p.name()));

                    }
                }
                break;
            }

            System.out.println("-------------------");
            boolean distanceBool = true;
            while (distanceBool) {
                System.out.println("Enter travel distance in km(can be decimal): ");
                distance = scanner.nextDouble();
                if (distance <= 0) {
                    System.out.println("Distance value must be higher than zero.");
                    System.out.println("");
                } else {
                    route.setDistance(distance);
                    distanceBool = false;
                }
            }

            System.out.println();

            UUID newRandom = UUID.randomUUID();
            route.setId(newRandom);

            boolean idBool = true;
            while (idBool) {

                System.out.println("Enter ID of the Ship:");
                boolean check = false;
                id = scanner.nextInt();
                for (Ship s : shipList) {
                    if (s.getId().equals(id)) {
                        check = true;
                        route.setShip_id(id);
                        break;
                    }
                }

                if (check) {
                    System.out.println("Route " + route.getId() + " succesfully loaded.");
                    idBool = false;
                    break;
                } else {
                    System.out.println("Ship with ID " + id + " not found.");
                }

            }

            double travelTime;
            Integer cargoWeight = 0;
            double avgspeed = 0.0;
            for (Ship s : shipList) {
                if (s.getId() == route.getShip_id()) {
                    avgspeed = s.getAvgSpeed();
                    for (Cargo c : s.getShipCargo()) {
                        cargoWeight += c.getWeight();
                    }
                }
            }

            System.out.println("Do you want to launch the simulation? Y/N");
            boolean bool1 = true;
            while (bool1) {
                String yesNo = scanner.nextLine().toLowerCase();
                if (yesNo.equals("y")) {

                    double speedWithCargo = avgspeed - (cargoWeight / 100) * 0.2;
                    travelTime = (route.getDistance() / speedWithCargo);
                    travelTime = Math.round(travelTime * 100.0) / 100.0;
                    if (travelTime < 1) {
                        System.out.println("Ship will be travelling for: " + travelTime * 60 + " minutes.");
                    } else if (travelTime > 72) {
                        System.out.println("Ship will be travelling for: " + travelTime / 24 + " days.");
                    } else {
                        System.out.println("Ship will be travelling for: " + travelTime + " hours.");
                    }
                    bool1 = false;
                } else if (yesNo.equals("n")) {
                    System.out.println("Thank you for using our app.");
                    System.exit(0);
                } else {
                    System.out.println("Please enter valid input: ('y' or 'n')");
                }

            }

        } catch (InputMismatchException ex) {
            System.out.println("Error! Next time try entering an Integer number.");
            System.exit(0);
        } catch (Exception ex) {
            System.out.println("Following error occured: " + ex.getMessage());
            System.exit(0);
        }
    }
}
