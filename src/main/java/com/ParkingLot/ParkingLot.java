package com.ParkingLot;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class ParkingLot {
    private String isFull;
    int parkingLotSize = 100;
    Integer capacity = 3;
    Integer key = 0;

    public ParkingLot() {
        for (Integer key = 1; key<=capacity; key++){
            parkingLot.put(key,null);
        }
    }
    LinkedHashMap<Integer, Object> parkingLot = new LinkedHashMap<>();
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
        key = vehicleParkLotNumber();
        parkingLot.replace(key,vehicle);
        setStatus("this vehicle charge Rs.10");
        if (parkingLotSize == 0 && parkingLot.size() != 0)
            if (key%3 == 0)
                setStatus("Full");
            return "park vehicle";
    }

    public String  isVehiclePark(Vehicle vehicle) throws ParkingLotException {
        if (parkingLot.containsValue(vehicle)) {
            int lotPosition = occupiedParkingLot(vehicle);
            return "vehicle park in lot number "+lotPosition;
        }
        else {
            throw new ParkingLotException(ParkingLotException.ExceptionType.VEHICLE_NOT_PARK,
                    "This vehicle not park in my parking lot");
        }
    }
    public int vehicleParkLotNumber(){
        Integer k=1;
        for ( ; k<=capacity ; k++)
            if (parkingLot.get(k) == null)
                return k;
        return k;
    }
    public int occupiedParkingLot(Vehicle vehicle) {
        int k = 0;
        for (Object o : parkingLot.values()) {
            k++;
            if (o == vehicle)
                return k;
        }
        return k + 1;
    }

        public String unPark (Vehicle vehicle) throws ParkingLotException {
            int key = occupiedParkingLot(vehicle);
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



