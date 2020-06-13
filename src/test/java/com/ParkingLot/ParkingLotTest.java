package com.ParkingLot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {

    ParkingLot parkingLot;
    Vehicle vehicle;
    Owner owner;
    Integer capacity = 3;
    int slot = 1;

    @Before
    public void setUp() {
        parkingLot = new ParkingLot(capacity,slot);
        vehicle = new Vehicle();
        owner = new Owner();

    }

    @Test
    public void givenVehicle_whenParked_ThenReturnTrue() {
        try {
            vehicle.setVehicleNumber("MH4R4545");
            parkingLot.park(vehicle);
            String result = parkingLot.park(vehicle);
            Assert.assertEquals("park vehicle",result);
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
            String result = parkingLot.park(vehicle);
            Assert.assertEquals("park vehicle",result);
        } catch (ParkingLotException e) {
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
            parkingLot.unPark(vehicle);
            Assert.assertEquals("Have Space lot number 3",owner.getParkingSpace());
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
            parkingLot.park(vehicle);
            Assert.assertEquals("this vehicle charge Rs.10",owner.getParkingCharge());
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenParkingAttendant_WhenEvenlyDistribution_ThenReturn() {
        try {
            this.capacity = 4;
            this.slot = 2;
            parkingLot=new ParkingLot(capacity,slot);
            parkingLot.addObserver(owner);
            vehicle.setVehicleNumber("MH4R4545");
            parkingLot.park(vehicle);
            Vehicle vehicle1 = new Vehicle();
            vehicle1.setVehicleNumber("MH4R4549");
            parkingLot.park(vehicle1);
            Assert.assertEquals("Full Lot A",owner.getParkingFull());
            Vehicle vehicle2 = new Vehicle();
            vehicle2.setVehicleNumber("MH4R4548");
            parkingLot.park(vehicle2);
            Vehicle vehicle3 = new Vehicle();
            vehicle3.setVehicleNumber("MH4R4547");
            parkingLot.park(vehicle3);
            Assert.assertEquals("Full Lot B",owner.getParkingFull());
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenParkMyCar_WhenNearestFreeSpace_ThenParkCar() {
        try {
            parkingLot.addObserver(owner);
            Vehicle vehicle1 = new Vehicle();
            vehicle1.setVehicleNumber("MH4R4545");
            parkingLot.park(vehicle1);
            Vehicle vehicle2 = new Vehicle();
            vehicle2.setVehicleNumber("MH4R4547");
            parkingLot.park(vehicle2);
            vehicle.setVehicleNumber("MH4R4548");
            String result = parkingLot.park(vehicle);
            Assert.assertEquals("park vehicle", result);
        } catch (ParkingLotException e) {
        }
    }
}






