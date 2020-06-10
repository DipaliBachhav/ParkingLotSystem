package com.ParkingLot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {

    ParkingLot parkingLot;
    Vehicle vehicle;
    @Before
    public void setUp(){
        parkingLot=new ParkingLot();
        vehicle=new Vehicle();
    }

    @Test
    public void givenVehicle_whenParked_ThenReturnTrue() {
        try {
            parkingLot.park(vehicle);
            boolean result = parkingLot.isVehiclePark(vehicle);
            Assert.assertTrue(result);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAVehicle_whenUnParked_ShouldReturnTrue() throws ParkingLotException {
        parkingLot.park(vehicle);
        boolean isParked=parkingLot.unPark(vehicle);
        Assert.assertTrue(isParked);
    }

}



