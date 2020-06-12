package com.ParkingLot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {

    ParkingLot parkingLot;
    Vehicle vehicle;

    @Before
    public void setUp() {
        parkingLot = new ParkingLot();
        vehicle = new Vehicle();
    }

    @Test
    public void givenVehicle_whenParked_ThenReturnTrue() {
        try {
            vehicle.setVehicleNumber("MH4R4545");
            parkingLot.park(vehicle);
            String result = parkingLot.isVehiclePark(vehicle);
            Assert.assertEquals("vehicle park in lot number 1",result);
        } catch (ParkingLotException e) {
        }
    }

    @Test
    public void givenAVehicle_whenUnParked_ShouldReturnTrue() {
        try {
            vehicle.setVehicleNumber("MH4R4545");
            parkingLot.park(vehicle);
        } catch (ParkingLotException e) {
            Assert.assertEquals("This vehicle already park", e.getMessage());
        }
    }

    @Test
    public void givenParkingLot_whenFull_ThenReturnTrue() {
        try {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber("MH4R4543");
            parkingLot.park(vehicle);
            vehicle.setVehicleNumber("MH4R4549");
            parkingLot.park(vehicle);
        } catch (ParkingLotException e) {
            Assert.assertEquals("Parking lot is full", e.getMessage());
        }
    }

    @Test
    public void givenParkingLotIsFull_whenInformAirportSecurity_ThenReturnTrue() {
        try {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber("MH4R4545");
            parkingLot.park(vehicle);
            vehicle.setVehicleNumber("MH4R4547");
            parkingLot.park(vehicle);
            vehicle.setVehicleNumber("MH4R4548");
            parkingLot.park(vehicle);
        } catch (ParkingLotException e) {
            Assert.assertEquals("Parking lot is full", e.getMessage());
        }
    }

    @Test
    public void givenAgainParkingSpaceAvailable_WhenInformOwner_ThenReturnTrue() {
        try {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber("MH4R4547");
            parkingLot.park(vehicle);
            vehicle.setVehicleNumber("MH4R4547");
            parkingLot.park(vehicle);
            String result = parkingLot.unPark(vehicle);
            Assert.assertEquals("space available", result);
        } catch (ParkingLotException e) {
        }
    }

    @Test
    public void givenVehicleNotPresentInParkingLot_WhenUnPark_ThenThrowException() {
        try {
            vehicle.setVehicleNumber("MH4R4545");
            parkingLot.park(vehicle);
            vehicle.setVehicleNumber("MH4R4547");
            String  result=parkingLot.unPark(vehicle);;
        } catch (ParkingLotException e) {
            Assert.assertEquals("This vehicle not park in my parking lot",e.getMessage());
        }
    }

    @Test
    public void givenCarFind_WhenParked_ThenReturnCarPosition() {
        try {
            vehicle.setVehicleNumber("MH4R4545");
            parkingLot.park(vehicle);
            vehicle.setVehicleNumber("MH4R4547");
            parkingLot.park(vehicle);
            String result = parkingLot.isVehiclePark(vehicle);
            Assert.assertEquals("vehicle park in lot number 2",result);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenVehicleParkInLot_WhenCharge_ThenReturnTrue() {
        try {
            vehicle.setVehicleNumber("MH4R4545");
            String result = parkingLot.park(vehicle);
            Assert.assertEquals("park vehicle",result);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }
}




