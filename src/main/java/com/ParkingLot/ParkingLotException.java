package com.ParkingLot;

    public class ParkingLotException extends Exception{
        public enum ExceptionType  {
            PARKING_LOT_IS_FULL;
        }
        ExceptionType type;

        public ParkingLotException(String message) {
            super(message);
            //this.type = type;
        }
}
