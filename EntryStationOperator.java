package com.parkingguidancesystem;

import java.util.List;

public class EntryStationOperator {
    private ParkingLot parkingLot;

    public EntryStationOperator(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void displayFreeSlots() {
        List<Integer> availableFreeSlots = parkingLot.getAvailableFreeSlots();
        if (!availableFreeSlots.isEmpty()) {
            System.out.println("Free parking spots available at:");
            for (int slot : availableFreeSlots) {
                System.out.println("Slot " + slot);
            }
        } else {
            System.out.println("Sorry, no free parking spots available at the moment.");
        }
    }

    public void displayPlateNumbers() {
        System.out.println("Plate numbers in every slot:");
        for (int i = 1; i <= parkingLot.getTotalSlots(); i++) {
            System.out.println("Slot " + i + ": " + parkingLot.getPlateNumberInSlot(i));
        }
    }
}
