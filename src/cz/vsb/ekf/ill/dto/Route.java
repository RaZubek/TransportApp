package cz.vsb.ekf.ill.dto;

import java.util.UUID;

public class Route {

    private UUID id;
    private Port startPort;
    private Port targetPort;
    private double distance;
    private double travelTime;
    private Integer ship_id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Port getStartPort() {
        return startPort;
    }

    public void setStartPort(Port startPort) {
        this.startPort = startPort;
    }

    public Port getTargetPort() {
        return targetPort;
    }

    public void setTargetPort(Port targetPort) {
        this.targetPort = targetPort;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Double getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(Double travelTime) {
        this.travelTime = travelTime;
    }

    public Integer getShip_id() {
        return ship_id;
    }

    public void setShip_id(Integer ship_id) {
        this.ship_id = ship_id;
    }

}
