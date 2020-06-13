package com.ParkingLot;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class ParkingLot {
    private String isFull;
    //int parkingLotSize = 100;
    Integer capacity;
    ParkingLotAttendant attendant;
    Integer key = 0;

    public ParkingLot(Integer capacity, int slot) {
        attendant = new ParkingLotAttendant(parkingLot,capacity,slot);
        for (Integer key = 1; key <= capacity; key++) {
            parkingLot.put(key, null);
        }
    }

    public LinkedHashMap<Integer, Object> parkingLot = new LinkedHashMap<>();
    AirportSecurity airportSecurity = new AirportSecurity();
    private List<Observer> observableList = new ArrayList<>();
    Owner owner = new Owner();

    public void addObserver(Observer observable) {
        this.observableList.add(observable);
    }

    public void setStatus(String isFull) {
        this.isFull = isFull;
        for (Observer observable : this.observableList) {
            observable.update(this.isFull);
        }
    }

    public String park(Vehicle vehicle) throws ParkingLotException {
        if (parkingLot.containsValue(vehicle))
            throw new ParkingLotException(ParkingLotException.ExceptionType.VEHICLE_ALREADY_PARK, "This vehicle already park");
        key = attendant.vehicleParkLotNumber(vehicle);
        parkingLot.replace(key, vehicle);
        setStatus("this vehicle charge Rs.10");
        //if (parkingLotSize == 0 && parkingLot.size() != 0)
        String lotStatus = attendant.isLotFull();
        setStatus(lotStatus);
        return "park vehicle";
    }

    public String  isVehiclePark(Vehicle vehicle) throws ParkingLotException {
        if (parkingLot.containsValue(vehicle))
            return "vehicle park in lot number "+attendant.occupiedParkingLot(vehicle);
        else {
            throw new ParkingLotException(ParkingLotException.ExceptionType.VEHICLE_NOT_PARK,
                    "This vehicle not park in my parking lot");
        }
    }
        public String unPark (Vehicle vehicle) throws ParkingLotException {
            int key = attendant.occupiedParkingLot(vehicle);
            if (parkingLot.containsValue(vehicle)) {
                parkingLot.replace(key,null);
                setStatus("Have Space lot number "+key);
                return "UnPark";
            }
            else{
                throw new ParkingLotException(ParkingLotException.ExceptionType.VEHICLE_NOT_PARK,
                "This vehicle not park in my parking lot");
    }
}
}



