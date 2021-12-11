package cz.vsb.ekf.ill.dto;

import java.util.List;

public class Ship {

    private Integer id;
    private String name;
    private Integer capacity;
    private Boolean isOnWay;
    private Integer countOfTransports;
    private double avgSpeed;
    private List<Cargo> shipCargo;

    public List<Cargo> getShipCargo() {
        return shipCargo;
    }

    public void setShipCargo(List<Cargo> shipCargo) {
        this.shipCargo = shipCargo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getOnWay() {
        return isOnWay;
    }

    public void setOnWay(Boolean onWay) {
        isOnWay = onWay;
    }

    public Integer getCountOfTransports() {
        return countOfTransports;
    }

    public void setCountOfTransports(Integer countOfTransports) {
        this.countOfTransports = countOfTransports;
    }

    public double getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    @Override
    public String toString() {
        return "SHIP ["
                + "ID: " + id
                + ", Ship Name: " + name
                + ", Capacity: " + capacity
                + ", Active: " + isOnWay
                + ", Count of transports: " + countOfTransports
                + ", Average Speed: " + avgSpeed + " Km/h"
                + ", Cargo: " + shipCargo
                + ']';
    }

}
