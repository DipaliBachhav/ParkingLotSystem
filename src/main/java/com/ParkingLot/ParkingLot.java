package com.ParkingLot;

public class ParkingLot {
    private Object vehicle;

    public ParkingLot() {
    }
    public boolean park(Object vehicle){
        this.vehicle=vehicle;
        return true;
    }

    public boolean unPark(Object vehicle) {
        if (vehicle == null) return false;
        if (this.vehicle.equals(vehicle)){
            this.vehicle = null;
            return true;
        }
        else return false;
    }
}

