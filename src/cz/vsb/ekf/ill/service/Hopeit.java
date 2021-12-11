package cz.vsb.ekf.ill.service;

import cz.vsb.ekf.ill.dao.InitialDemoData;
import cz.vsb.ekf.ill.dto.Cargo;
import cz.vsb.ekf.ill.dto.Ship;
import java.util.List;

public class Hopeit {

    public static void willwork() {
        //Ukol4
        InitialDemoData init = new InitialDemoData();
        List<Cargo> cargoList = init.creatingCargo();
        List<Ship> shipList = init.creatingShip();

        //Ukol5
        ShipFound.shipFound(init, shipList);

        //Simulace+ukol6
        ShippingTime.shippingTime(shipList);

        //Ukol7
        ExportDesktop.exportDesktop(shipList);
    }
}
