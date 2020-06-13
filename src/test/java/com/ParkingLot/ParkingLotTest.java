package com.ParkingLot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {

    ParkingLot parkingLot;
    Vehicle vehicle;
    Owner owner;
    AirportSecurity airportSecurity;
    ParkingLotAttendant attendant;
    Integer capacity = 3;
    int slot = 1;

    @Before
    public void setUp() {
        parkingLot = new ParkingLot(capacity, slot);
        owner = new Owner();

    }

    @Test
    public void givenVehicle_whenParked_ThenReturnTrue() {
        try {
            Vehicle vehicle = new Vehicle("suzuki", "MH4R4545", "SMALL", new Driver(Driver.DriverType.NORMAL));
            parkingLot.park(vehicle);
            String result = parkingLot.park(vehicle);
            Assert.assertEquals("park vehicle", result);
        } catch (ParkingLotException e) {
        }
    }

    @Test
    public void givenAVehicle_whenUnParked_ShouldReturnTrue() {
        try {
            Vehicle vehicle = new Vehicle("suzuki","MH4R4545","SMALL",new Driver(Driver.DriverType.NORMAL));
            parkingLot.park(vehicle);
        } catch (ParkingLotException e) {
            Assert.assertEquals("This vehicle already park", e.getMessage());
        }
    }

    @Test
    public void givenParkingLot_whenFull_ThenReturnTrue() {
        try {
            Vehicle vehicle1 = new Vehicle("suzuki","MH4R4545","SMALL",new Driver(Driver.DriverType.NORMAL));
            parkingLot.park(vehicle);
            Vehicle vehicle = new Vehicle("suzuki","MH4R4547","SMALL",new Driver(Driver.DriverType.NORMAL));
            parkingLot.park(vehicle);
            String result = parkingLot.park(vehicle);
            Assert.assertEquals("park vehicle",result);
        } catch (ParkingLotException e) {
        }
    }

    @Test
    public void givenParkingLotIsFull_whenInformAirportSecurity_ThenReturnTrue() {
        try {
            Vehicle vehicle1 = new Vehicle("suzuki","MH4R4545","SMALL",new Driver(Driver.DriverType.NORMAL));
            parkingLot.park(vehicle1);
            Vehicle vehicle2 = new Vehicle("suzuki","MH4R4546","SMALL",new Driver(Driver.DriverType.NORMAL));
            parkingLot.park(vehicle2);
            Vehicle vehicle3 = new Vehicle("suzuki","MH4R4545","SMALL",new Driver(Driver.DriverType.NORMAL));
            parkingLot.park(vehicle3);
            Assert.assertEquals("Full Lot 1",airportSecurity.getParkingSlotFullOrNot());
        } catch (ParkingLotException e) {
        }
    }

    @Test
    public void givenAgainParkingSpaceAvailable_WhenInformOwner_ThenReturnTrue() {
        try {
            parkingLot.addObserver(owner);
            Vehicle vehicle1 = new Vehicle("suzuki","MH4R4545","SMALL",new Driver(Driver.DriverType.NORMAL));
            parkingLot.park(vehicle1);
            Vehicle vehicle2 = new Vehicle("suzuki","MH4R4546","SMALL",new Driver(Driver.DriverType.NORMAL));
            parkingLot.park(vehicle2);
            parkingLot.unPark(vehicle);
            Assert.assertEquals("Have Space lot number 3",owner.getParkingSpace());
        } catch (ParkingLotException e) {
        }
    }

    @Test
    public void givenVehicleNotPresentInParkingLot_WhenUnPark_ThenThrowException() {
        try {
            Vehicle vehicle1 = new Vehicle("suzuki","MH4R4545","SMALL",new Driver(Driver.DriverType.NORMAL));
            parkingLot.park(vehicle1);
            Vehicle vehicle = new Vehicle("suzuki","MH4R4546","SMALL",new Driver(Driver.DriverType.NORMAL));
            String  result=parkingLot.unPark(vehicle);;
        } catch (ParkingLotException e) {
            Assert.assertEquals("This vehicle not park in my parking lot",e.getMessage());
        }
    }

    @Test
    public void givenCarFind_WhenParked_ThenReturnCarPosition() {
        try {
            Vehicle vehicle = new Vehicle("suzuki","MH4R4545","SMALL",new Driver(Driver.DriverType.NORMAL));
            parkingLot.park(vehicle);
            Vehicle vehicle1 = new Vehicle("suzuki","MH4R4546","SMALL",new Driver(Driver.DriverType.NORMAL));
            parkingLot.park(vehicle1);
            String result = parkingLot.isVehiclePark(vehicle);
            Assert.assertEquals("vehicle park in lot number 1",result);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenVehicleParkInLot_WhenCharge_ThenReturnTrue() {
        try {
            Vehicle vehicle = new Vehicle("suzuki","MH4R4545","SMALL",new Driver(Driver.DriverType.NORMAL));
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
            Vehicle vehicle = new Vehicle("suzuki","MH4R4545","SMALL",new Driver(Driver.DriverType.NORMAL));
            parkingLot.park(vehicle);
            Vehicle vehicle1 = new Vehicle("suzuki","MH4R4546","SMALL",new Driver(Driver.DriverType.NORMAL));
            parkingLot.park(vehicle1);
            Assert.assertEquals("Full Lot 1",owner.getParkingFull());
            Vehicle vehicle2 = new Vehicle("suzuki","MH4R4547" ,"SMALL",new Driver(Driver.DriverType.NORMAL));
            parkingLot.park(vehicle2);
            Vehicle vehicle3 = new Vehicle("suzuki","MH4R4548" ,"SMALL",new Driver(Driver.DriverType.NORMAL));
            parkingLot.park(vehicle3);
            Assert.assertEquals("Full Lot 2",owner.getParkingFull());
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenHandicapDriver_WhenNearestFreeSpace_ThenParkCar(){
    try {
            parkingLot.addObserver(owner);
            Vehicle vehicle1 = new Vehicle("suzuki","MH4R4545","SMALL",new Driver(Driver.DriverType.NORMAL));
            parkingLot.park(vehicle1);
            Vehicle vehicle2 = new Vehicle("suzuki","MH4R4546","SMALL",new Driver(Driver.DriverType.HANDICAP));
            parkingLot.park(vehicle2);
            Vehicle vehicle = new Vehicle("suzuki","MH4R4547","SMALL",new Driver(Driver.DriverType.HANDICAP));
            String result = parkingLot.park(vehicle);
            Assert.assertEquals("park vehicle", result);
        } catch (ParkingLotException e) {
        }
    }
}






