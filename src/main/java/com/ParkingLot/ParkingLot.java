package com.ParkingLot;

import java.util.LinkedHashMap;

public class ParkingLot {
    private Object vehicle;
    //public int size=5;

    LinkedHashMap<String,Object> parkingLot = new LinkedHashMap<>();
    AirportSecurity airportSecurity = new AirportSecurity();

    public ParkingLot() {
    }
    public void park(Vehicle vehicle) throws  ParkingLotException {
        if (parkingLot.containsKey(vehicle.getVehicleNumber()))
            throw new ParkingLotException(ParkingLotException.ExceptionType.VEHICLE_ALREADY_PARK,"This vehicle already park");
        if (parkingLot.size()%2==0 && parkingLot.size() != 0) {
            parkingLot.put(vehicle.getVehicleNumber(),vehicle);
            airportSecurity.setParkingSlotFullOrNot("parking lot is full");
            throw new ParkingLotException(ParkingLotException.ExceptionType.PARKING_LOT_IS_FULL,airportSecurity.getParkingSlotFullOrNot());
        }else {
            parkingLot.put(vehicle.getVehicleNumber(),vehicle);
        }
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

