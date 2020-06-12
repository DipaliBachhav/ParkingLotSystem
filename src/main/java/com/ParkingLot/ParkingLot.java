package com.ParkingLot;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class ParkingLot {

    int capacity=100;

    LinkedHashMap<String,Object> parkingLot = new LinkedHashMap<>();
    AirportSecurity airportSecurity = new AirportSecurity();


    public void park(Vehicle vehicle) throws ParkingLotException {
        if (parkingLot.containsKey(vehicle.getVehicleNumber()))
            throw new ParkingLotException(ParkingLotException.ExceptionType.VEHICLE_ALREADY_PARK, "This vehicle already park");
        if (capacity == 0 && parkingLot.size() != 0) {
        //if(parkingLot.size()<capacity){
            parkingLot.put(vehicle.getVehicleNumber(), vehicle);
            airportSecurity.setParkingSlotFullOrNot("Parking lot is full");
            System.out.println(parkingLot.size());
            throw new ParkingLotException(ParkingLotException.ExceptionType.PARKING_LOT_IS_FULL, airportSecurity.getParkingSlotFullOrNot());
        } else {
            parkingLot.put(vehicle.getVehicleNumber(), vehicle);
          //  System.out.println(parkingLot.size());
        }
    }

    public String  isVehiclePark(Vehicle vehicle) throws ParkingLotException {
        if (parkingLot.containsKey(vehicle.getVehicleNumber())) {
            int lotPosition = vehicleParkLotNumber(vehicle);
            return "vehicle park in lot number "+(lotPosition+1);
        }
        else {
            throw new ParkingLotException(ParkingLotException.ExceptionType.VEHICLE_NOT_PARK,
                    "This vehicle not park in my parking lot");
        }
    }
    public int vehicleParkLotNumber(Vehicle vehicle){
        Set<String> keys = parkingLot.keySet();
        List<String> listKeys = new ArrayList<String>( keys );
        return listKeys.indexOf(vehicle.getVehicleNumber());
    }

        public String unPark (Vehicle vehicle) throws ParkingLotException {
            if (parkingLot.containsKey(vehicle.getVehicleNumber())) {
                int lotPosition = vehicleParkLotNumber(vehicle);
                parkingLot.remove(vehicle.getVehicleNumber());
                if (parkingLot.size() < capacity) {
                    new Owner().setParkingFullOrNot("parking lot space available "+(lotPosition+1));
                    return "space available";
                }
                return "UnPark";
            } else {
                throw new ParkingLotException(ParkingLotException.ExceptionType.VEHICLE_NOT_PARK,
                        "This vehicle not park in my parking lot");
            }
        }
    }


