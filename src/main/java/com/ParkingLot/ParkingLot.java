package com.ParkingLot;

import java.util.LinkedHashMap;

public class ParkingLot {
    private Object vehicle;
    //public int size=5;

    LinkedHashMap<String, Object> parkingLot = new LinkedHashMap<>();
    AirportSecurity airportSecurity = new AirportSecurity();

    public ParkingLot() {
    }

    public String park(Vehicle vehicle) throws ParkingLotException {
        if (parkingLot.containsKey(vehicle.getVehicleNumber()))
            throw new ParkingLotException(ParkingLotException.ExceptionType.VEHICLE_ALREADY_PARK, "This vehicle already park");
        if (parkingLot.size() % 2 == 0 && parkingLot.size() != 0) {
            parkingLot.put(vehicle.getVehicleNumber(), vehicle);
            airportSecurity.setParkingSlotFullOrNot("parking lot is full");
            throw new ParkingLotException(ParkingLotException.ExceptionType.PARKING_LOT_IS_FULL, airportSecurity.getParkingSlotFullOrNot());
        } else {
            parkingLot.put(vehicle.getVehicleNumber(), vehicle);
        }
        //System.out.println(parkingLot.size());
        return "Added";

    }

    public boolean isVehiclePark(Object vehicle) {
        if (this.vehicle.equals(vehicle))
            return true;
        return false;
    }

    public String unPark(Vehicle vehicle) throws ParkingLotException {
        if (parkingLot.containsKey(vehicle.getVehicleNumber())) {
            parkingLot.remove(vehicle.getVehicleNumber());
            if (parkingLot.size() < 3) {
                new Owner().setParkingFullOrNot("parking lot space available ");
                return "space available";
            }
            return "UnPark";
        } else {
            throw new ParkingLotException(ParkingLotException.ExceptionType.VEHICLE_NOT_PARK,
                    "This vehicle not park in my parking lot");
        }
    }
}

