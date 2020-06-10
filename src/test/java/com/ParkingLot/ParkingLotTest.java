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

    @Test
    public void givenParkingLot_whenFull_ThenReturnTrue() {
        try {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleName("sujuki");vehicle.setVehicleNumber("MH4R4545");
            parkingLot.park(vehicle);
            vehicle.setVehicleName("Maruti");vehicle.setVehicleNumber("MH4R4547");
            parkingLot.park(vehicle);
            parkingLot.park(vehicle);
        } catch (ParkingLotException e) {
            Assert.assertEquals("Parking lot is full",e.getMessage());
        }
    }

    @Test
    public void givenParkingLotIsFull_whenInformAirportSecurity_ThenReturnTrue() {
        try {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleName("suzuki");vehicle.setVehicleNumber("MH4R4545");
            parkingLot.park(vehicle);
            vehicle.setVehicleName("suzuki");vehicle.setVehicleNumber("MH4R4547");
            parkingLot.park(vehicle);
            vehicle.setVehicleName("suzuki");vehicle.setVehicleNumber("MH4R4548");
            parkingLot.park(vehicle);
        } catch (ParkingLotException e) {
            Assert.assertEquals("parking lot is full",e.getMessage());
        }
    }
}



