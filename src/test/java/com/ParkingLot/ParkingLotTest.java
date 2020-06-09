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
    public void givenAVehicle_WhenParked_ShouldReturnTrue() {
        boolean isParked=parkingLot.park(vehicle);
        Assert.assertTrue(isParked);
    }
}

