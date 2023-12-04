package com.parkingguidancesystem;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Customer {
    private String vehicleNumber;
    private int assignedSlot;
    private int parkingSlot;
    private int slotNumber;
    private String entryID;
    private LocalDateTime entryTime;
    private double parkingFeePerHour = 2.5; // Assuming a fixed fee per hour

    public void assignSlot(int slotNumber, LocalDateTime entryTime) {
        this.assignedSlot = slotNumber;
        this.entryTime = entryTime;
    }

    public void leaveSlot() {
        this.assignedSlot = -1; // Indicating no slot assigned
        this.entryTime = null; // Reset entry time
    }

    public String getPlateNumber() {
        return vehicleNumber;
    }

    public Customer(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void park(int slotNumber) {
        this.parkingSlot = slotNumber;
        generateEntryID();
        recordEntryTime();
        printEntryTicket();
        System.out.println("Vehicle " + vehicleNumber + " parked at slot " + parkingSlot);
    }

    public void printExitTicket(String providedEntryID) {
        if (providedEntryID.equals(entryID)) {
            calculateParkingDurationHours();
            double parkingFee = calculateParkingFee();
            System.out.println("Parking duration: " + calculateParkingDurationHours() + " hours");
            System.out.println("Parking Fee: $" + parkingFee);
            // Simulate printing an exit ticket with duration and fee details
            System.out.println("==== Exit Ticket ====");
            System.out.println("Entry ID: " + entryID);
            System.out.println("Vehicle Number: " + vehicleNumber);
            System.out.println("Parked Time: " + calculateParkingDurationHours() + " hours");
            System.out.println("Parking Fee: $" + parkingFee);
            System.out.println("=====================");
        } else {
            System.out.println("Invalid Entry ID. Please provide the correct entry ID.");
        }
    }

    public void generateEntryID() {
        // ID generation logic as before
        //entryID = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + (int) (Math.random() * 1000);
        //entryID = String.valueOf((int) (Math.random() * 100000));
        entryID = vehicleNumber;
    }

    public void recordEntryTime() {
        entryTime = LocalDateTime.now();
    }
    public double calculateParkingFee() {
        double hours = calculateParkingDurationHours();
        return hours * parkingFeePerHour;
    }

    public double calculateParkingDurationHours() {
        LocalDateTime exitTime = LocalDateTime.now();
        Duration duration = Duration.between(entryTime, exitTime);
        return duration.getSeconds() / 3600.0;
    }

    public void printEntryTicket() {
        System.out.println("==== Entry Ticket ====");
        System.out.println("Entry ID: " + entryID);
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Entry Time: " + entryTime);
        System.out.println("Slot Number: "+ slotNumber);
        System.out.println("=====================");
    }

    // Other methods for exit, additional functionalities, etc.
}
