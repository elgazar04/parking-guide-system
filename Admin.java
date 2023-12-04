package com.parkingguidancesystem;

public class Admin {
    private ParkingLot parkingLot;

    public Admin(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void addSlots(int newSlotsCount) {
        parkingLot.addSlots(newSlotsCount);
        System.out.println(newSlotsCount + " new slots added to the parking lot.");
    }

    public void viewTotalSlots() {
        int totalSlots = parkingLot.getTotalSlots();
        System.out.println("Total slots in the parking lot: " + totalSlots);
    }
    
}
