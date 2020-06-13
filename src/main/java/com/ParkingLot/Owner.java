package com.ParkingLot;

public class Owner implements Observer {
    private String parkingFull;
    private String parkingSpace;
    private String parkingCharge;

    @Override
    public void update(Object status) {
        String string = status.toString();
        if (string.contains("Full"))
            this.setParkingFull((String) status);
        else if (string.contains("Have Space lot number "))
            this.setParkingSpace((String) status);
        else if (string.contains("this vehicle charge Rs."))
            this.setParkingCharge((String) status);
    }

    public void setParkingFull(String parkingFull) {
        this.parkingFull = parkingFull;
    }

    public void setParkingSpace(String parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public void setParkingCharge(String parkingCharge) {
        this.parkingCharge = parkingCharge;
    }

    public String getParkingFull() {
        return parkingFull;
    }

    public String getParkingSpace() {
        return parkingSpace;
    }

    public String getParkingCharge() {
        return parkingCharge;
    }
}
