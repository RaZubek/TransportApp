package cz.vsb.ekf.ill.dao;

import java.util.ArrayList;
import java.util.List;
import cz.vsb.ekf.ill.dto.Cargo;
import java.security.SecureRandom;
import cz.vsb.ekf.ill.dto.Ship;

public class InitialDemoData {

    public List<Cargo> cargoList = new ArrayList<>();
    public List<Ship> shipList = new ArrayList<>();
    private static final SecureRandom random = new SecureRandom();

    public List<Cargo> creatingCargo() {
        for (int i = 1; i <= 40; i++) {
            Cargo cargo = new Cargo();
            cargo.setId(i);

            Integer temp = Long.valueOf((Math.round(Math.random() * 10) * 100)).intValue();
            if (temp == 0) {
                cargo.setDescription("Empty");
            } else {
                cargo.setDescription(consistOf[random.nextInt(consistOf.length)]);
            }

            cargo.setWeight(temp);
            cargo.setTotalPrice(temp * 100 + 2 * temp);
            cargoList.add(cargo);
        }
        return cargoList;
    }

    public List<Ship> creatingShip() {

        int cargoInt = 0;

        for (int i = 1; i <= 20; i++) {
            Ship ship = new Ship();
            ship.setId(i);
            ship.setName(shipName[random.nextInt(shipName.length)] + i);
            Integer tempCap = Long.valueOf((Math.round(Math.random() * (10 + 1) + 20) * 100)).intValue();
            ship.setCapacity(tempCap);
            ship.setOnWay(i % 10 != 0);
            ship.setCountOfTransports((int) (Math.random() * ((20) + 1)));
            ship.setAvgSpeed((int) (Math.random() * Math.random() * (70 + 1) + 30));

            List<Cargo> cargoOnShip = new ArrayList<>();
            cargoOnShip.add(cargoList.get(cargoInt));
            cargoOnShip.add(cargoList.get(cargoInt + 1));
            cargoInt += 2;

            ship.setShipCargo(cargoOnShip);

            shipList.add(ship);

        }
        return shipList;
    }

    public Ship findShip(List<Ship> shiplist, String input) {
        Ship ship = null;
        for (Ship s : shipList) {
            if (isInteger(input)) {
                if (s.getId() == Integer.parseInt(input)) {
                    ship = s;
                    break;
                }
            } else if (s.getName().equalsIgnoreCase(input)) {
                ship = s;
                break;
            }
        }

        return ship;
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    final static String[] consistOf = {
        "Horses",
        "Furniture",
        "User electronics",
        "Tobacco",
        "Automobiles",
        "Fruit",
        "Clothing",
        "Beauty and health",
        "Toys",
        "Home appliances",
        "Jewelry and Watches"
    };

    final static String[] shipName = {
        "Predator",
        "Auricula",
        "Snowflake",
        "Conway",
        "Stormcloud",
        "The Hermes",
        "Messina",
        "Astraea",
        "The Aztec",
        "Tide Runner",
        "Windsong",
        "Bendor",
        "Yamato",
        "Millbrook",
        "Africaine",};
}
