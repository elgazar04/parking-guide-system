package com.parkingguidancesystem;

import java.util.Scanner;

public class ParkingSystemMain {
    private static ParkingLot parkingLot;
    private static Admin admin;
    public static void main(String[] args) {

        parkingLot = new ParkingLot();
        parkingLot.initializeParking(20);
        admin = new Admin(parkingLot);

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("===== Parking System Menu =====");
            System.out.println("1. Customer");
            System.out.println("2. Operator in Entry Station");
            System.out.println("3. Operator in Exit Station");
            System.out.println("4. Admin");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    customerMenu();
                    break;
                case 2:
                    entryStationOperatorMenu();
                    break;
                case 3:
                    exitStationOperatorMenu();
                    break;
                case 4:
                    if (adminLogin()) {
                        adminMenu();
                    } else {
                        System.out.println("Admin login failed. Access denied.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the Parking System. Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }

    private static void customerMenu() {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer("");
    
        System.out.println("Customer Menu");
        System.out.println("1. Print Entry Ticket");
        System.out.println("2. Print Exit Ticket");
        System.out.println("3. Back");
    
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        switch (choice) {
            case 1:
                System.out.print("Enter vehicle plate number: ");
                String plateNumber = scanner.nextLine();
                customer.setVehicleNumber(plateNumber);
                customer.park(1);
                break;
            case 2:
                System.out.print("Enter entry ID: ");
                String providedEntryID = scanner.nextLine();
                customer.printExitTicket(providedEntryID);
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
                break;
        }
    }
    

    private static void entryStationOperatorMenu() {
        EntryStationOperator entryOperator = new EntryStationOperator(parkingLot);
        Scanner scanner = new Scanner(System.in);
        boolean backToMain = false;

        // Simulated login credentials
        final String OPERATOR_USERNAME = "operator";
        final String OPERATOR_PASSWORD = "password";

        while (!backToMain) {
            System.out.print("Enter Operator Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Operator Password: ");
            String password = scanner.nextLine();

            if (username.equals(OPERATOR_USERNAME) && password.equals(OPERATOR_PASSWORD)) {
                System.out.println("Login successful!");
                operatorActions(entryOperator);
                backToMain = true;
            } else {
                System.out.println("Invalid credentials. Please try again or type 'back' to return.");
                if (username.equalsIgnoreCase("back")) {
                    backToMain = true;
                }
            }
        }
    }

    private static void operatorActions(EntryStationOperator entryOperator) {
        Scanner scanner = new Scanner(System.in);
        boolean backToLogin = false;

        while (!backToLogin) {
            System.out.println("===== Entry Station Operator Menu =====");
            System.out.println("1. Display Free Slots");
            System.out.println("2. Display Plate Numbers in Every Slot");
            System.out.println("3. Back to Login");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    entryOperator.displayFreeSlots();
                    break;
                case 2:
                    entryOperator.displayPlateNumbers();
                    break;
                case 3:
                    backToLogin = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }

    private static void exitStationOperatorMenu() {
        // Implement exit station operator menu logic
        System.out.println("Operator in Exit Station Menu");
        // Add options for exit station operators
    }

    private static boolean adminLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        // Simulated admin credentials
        String adminUsername = "admin";
        String adminPassword = "password";

        return username.equals(adminUsername) && password.equals(adminPassword);
    }


    private static void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean backToMain = false;

        while (!backToMain) {
            System.out.println("===== Admin Menu =====");
            System.out.println("1. Add Slots");
            System.out.println("2. View Total Slots");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the number of new slots to add: ");
                    int newSlots = scanner.nextInt();
                    admin.addSlots(newSlots);
                    break;
                case 2:
                    admin.viewTotalSlots();
                    break;
                case 3:
                    backToMain = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }
}