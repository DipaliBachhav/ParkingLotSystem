package com.ParkingLot;

import java.util.LinkedHashMap;

public class ParkingLot {

    int capacity=100;

    LinkedHashMap<String,Object> parkingLot = new LinkedHashMap<>();
    AirportSecurity airportSecurity = new AirportSecurity();


    public void park(Vehicle vehicle) throws ParkingLotException {
        if (parkingLot.containsKey(vehicle.getVehicleNumber()))
            throw new ParkingLotException(ParkingLotException.ExceptionType.VEHICLE_ALREADY_PARK, "This vehicle already park");
        if (capacity == 0 && parkingLot.size() != 0) {
            parkingLot.put(vehicle.getVehicleNumber(), vehicle);
            airportSecurity.setParkingSlotFullOrNot("Parking lot is full");
            throw new ParkingLotException(ParkingLotException.ExceptionType.PARKING_LOT_IS_FULL, airportSecurity.getParkingSlotFullOrNot());
        } else {
            parkingLot.put(vehicle.getVehicleNumber(), vehicle);
        }
    }

        public boolean isVehiclePark (Vehicle vehicle){
            if (parkingLot.containsKey(vehicle.getVehicleNumber()))
                return true;
            return false;
        }

        public String unPark (Vehicle vehicle) throws ParkingLotException {
            if (parkingLot.containsKey(vehicle.getVehicleNumber())) {
                parkingLot.remove(vehicle.getVehicleNumber());
                if (parkingLot.size() < capacity) {
                    new Owner().setParkingFullOrNot("Parking lot space available ");
                    return "space available";
                }
                return "UnPark";
            } else {
                throw new ParkingLotException(ParkingLotException.ExceptionType.VEHICLE_NOT_PARK,
                        "This vehicle not park in my parking lot");
            }
        }
    }


