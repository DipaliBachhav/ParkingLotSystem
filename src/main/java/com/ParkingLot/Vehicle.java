package com.ParkingLot;



public class Vehicle {
    private String vehicleName;
    private String vehicleNumber;
    private String vehicleModel;
    private String vehicleType;
    private Driver driver;

    public String getVehicleName() {
        return vehicleName;
    }

    public Vehicle(String vehicleName, String vehicleNumber, String vehicleType, Driver driver) {
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.driver = driver;
        this.vehicleType = vehicleType;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
    public Driver getDriver() {
        return driver;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleName='" + vehicleName + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", driver=" + driver +
                '}';
    }
}
