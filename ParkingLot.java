package com.parkingguidancesystem;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private Map<Integer, Boolean> parkingSlots;

    public ParkingLot() {
        this.parkingSlots = new HashMap<>();
    }

    public void initializeParking(int totalSlots) {
        for (int i = 1; i <= totalSlots; i++) {
            parkingSlots.put(i, false); // Initially, all slots are marked as unoccupied
        }
    }

    public void addSlots(int newSlotsCount) {
        int currentSlotCount = parkingSlots.size();
        for (int i = currentSlotCount + 1; i <= currentSlotCount + newSlotsCount; i++) {
            parkingSlots.put(i, false);
        }
    }

    public List<Integer> getAvailableFreeSlots() {
        List<Integer> freeSlots = new ArrayList<>();
        for (Map.Entry<Integer, Boolean> entry : parkingSlots.entrySet()) {
            if (!entry.getValue()) {
                freeSlots.add(entry.getKey());
            }
        }
        return freeSlots;
    }

    public boolean takeSlot(int slotNumber, Customer customer) {
        LocalDateTime entryTime = LocalDateTime.now();
        if (parkingSlots.containsKey(slotNumber) && !parkingSlots.get(slotNumber)) {
            parkingSlots.put(slotNumber, true); // Mark the slot as occupied    
            customer.assignSlot(slotNumber, entryTime); // Assign the slot to the customer
            return true; // Slot successfully taken
        }
        return false; // Slot was either invalid or already occupied
    }

    public void freeSlot(int slotNumber, Customer customer) {
        if (parkingSlots.containsKey(slotNumber) && parkingSlots.get(slotNumber)) {
            parkingSlots.put(slotNumber, false); // Mark the slot as unoccupied
            customer.leaveSlot(); // Remove the slot assignment from the customer
        }
    }

    public String getPlateNumberInSlot(int slotNumber) {
        // Simulated plate number retrieval
        return "Plate number" + slotNumber;
    }

    public int getTotalSlots() {
        return parkingSlots.size();
    }
}
