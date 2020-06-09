package com.ParkingLot;

public class ParkingLot {
    private Object vehicle;

    public ParkingLot() {
    }
    public boolean park(Object vehicle){
        this.vehicle=vehicle;
        return true;
    }
}

