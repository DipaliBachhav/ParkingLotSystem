package com.ParkingLot;

import java.util.LinkedHashMap;

public class ParkingLot {
    private Object vehicle;
    LinkedHashMap<String,Object> parkingLot = new LinkedHashMap<>();

    public ParkingLot() {
    }
    public boolean park(Vehicle vehicle) throws ParkingLotException {
        if (parkingLot.size()%2==0 && parkingLot.size() != 0) {
            parkingLot = null;
            throw new ParkingLotException("Parking lot is full");
        }
        this.vehicle = vehicle;
        parkingLot.put(vehicle.getVehicleNumber(),vehicle);
        return false;
    }

    public boolean isVehiclePark(Object vehicle) {
        if (this.vehicle.equals(vehicle))
            return true;
        return false;
    }

    public boolean unPark(Vehicle vehicle) {
        if (vehicle == null) return false;
        if (this.vehicle.equals(vehicle)){
            this.vehicle = null;
            parkingLot.remove(vehicle.getVehicleNumber());

            return true;
        }
        else return false;
    }
}

