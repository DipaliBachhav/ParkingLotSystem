package com.ParkingLot;

    public class ParkingLotException extends Exception{
        public enum ExceptionType  {
            PARKING_LOT_IS_FULL,VEHICLE_ALREADY_PARK,VEHICLE_NOT_PARK;
        }
        ExceptionType type;

        public ParkingLotException(ExceptionType vehicleAlreadyPark, String message) {
            super(message);
            this.type = type;
        }
}
