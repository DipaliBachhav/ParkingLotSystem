package com.ParkingLot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {

    ParkingLot parkingLot;
    Object vehicle;
    @Before
    public void setUp(){
        parkingLot=new ParkingLot();
        vehicle=new Object();
    }

    @Test
    public void givenAVehicle_whenParked_ShouldReturnTrue() {
        boolean isParked=parkingLot.park(vehicle);
        Assert.assertTrue(isParked);
    }

    @Test
    public void givenAVehicle_whenUnParked_ShouldReturnTrue() {
        parkingLot.park(vehicle);
        boolean isParked=parkingLot.unPark(vehicle);
        Assert.assertTrue(isParked);
    }
}



