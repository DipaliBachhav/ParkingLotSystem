package com.ParkingLot;

public class AirportSecurity implements Observer{
    private String parkingSlotFullOrNot;

    @Override
    public void update(Object status) {
        this.setParkingSlotFullOrNot((String) status);
    }

    public String getParkingSlotFullOrNot() {
        return parkingSlotFullOrNot;
    }

    public void setParkingSlotFullOrNot(String parkingSlotFullOrNot) {
        this.parkingSlotFullOrNot = parkingSlotFullOrNot;
    }
}
