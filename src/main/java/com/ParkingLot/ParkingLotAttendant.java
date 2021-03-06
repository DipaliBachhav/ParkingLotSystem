package com.ParkingLot;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParkingLotAttendant {
    ParkingLot parkingLotService;
    Integer capacity;
    int slot;
    Map<Integer,Integer> lots = new HashMap<>();
    LinkedHashMap parkingLot;

    // constructor
    public ParkingLotAttendant(LinkedHashMap<Integer, Object> parkingLot, Integer capacity, int slot) {
        this.parkingLot = parkingLot;
        this.capacity = capacity;
        this.slot = slot;
    }
    // find empty parking lot
    public int vehicleParkLotNumber(Vehicle vehicle){
        Integer key=0;
        if (vehicle.getDriver().getDriverType().equals(Driver.DriverType.HANDICAP))
            key=0;
        else
            key=(checkLot()-1)*slot;
        key++;
        for (; key<=capacity ; key++)
            if (parkingLot.get(key) == null)
                return key;
        return key+1;
    }
    // find Object key
    public int occupiedParkingLot(Object vehicle){
        int k = 0;
        for (Object o: parkingLot.values()) {
            k++;
            if (o==vehicle)
                return k;
        }
        return k+1;
    }
    // check empty space in lots
    public int checkLot(){
        int i=0,count=0,key=0;
        for (Object o:parkingLot.values()) {
            if (o==null)
                count++;
            i++;
            if (i%slot==0){
                lots.put(++key,count);
                count = 0;
            }
        }
        return minimumcarsLots();
    }
    // check minimum cars in lot
    public int minimumcarsLots(){
        int minCar = lots.keySet().stream().filter(key -> Collections.max(lots.values()).equals(lots.get(key)))
                .findFirst().get();
        return minCar;
    }
    // check lot full or not
    public String isLotFull(){
        checkLot();
        Integer value = 0, lotNumber = 0;
        String lot = "";
        for (Object o:lots.values()){
            lotNumber++;
            if (o==value)
                lot = "Full Lot "+lotNumber;
        }
        return lot;
    }
}

