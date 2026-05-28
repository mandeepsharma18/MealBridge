import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<FoodDonation> donations = new ArrayList<FoodDonation>();
    private static ArrayList<Receiver> receivers = new ArrayList<Receiver>();
    private static Scanner scanner = new Scanner(System.in);
    private static int donationId = 1;
    private static int receiverId = 1;

    public static void main(String[] args) {
        addSampleData();

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addDonation();
                    break;
                case 2:
                    addReceiver();
                    break;
                case 3:
                    showDonations();
                    break;
                case 4:
                    showReceivers();
                    break;
                case 5:
                    matchFood();
                    break;
                case 6:
                    searchByLocation();
                    break;
                case 0:
                    System.out.println("Thank you for using MealBridge.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("========== MealBridge ==========");
        System.out.println("1. Add Food Donation");
        System.out.println("2. Add Receiver Request");
        System.out.println("3. View All Donations");
        System.out.println("4. View All Receivers");
        System.out.println("5. Match Food Donation");
        System.out.println("6. Search Donations by Location");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addDonation() {
        System.out.print("Enter donor name: ");
        String donorName = scanner.nextLine();

        System.out.print("Enter food type: ");
        String foodType = scanner.nextLine();

        System.out.print("Enter quantity in meals: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        System.out.print("Food available for how many hours: ");
        int availableHours = scanner.nextInt();
        scanner.nextLine();

        FoodDonation donation = new FoodDonation(donationId, donorName, foodType, quantity, location, availableHours);
        donations.add(donation);
        donationId++;

        System.out.println("Donation added successfully.");
    }

    private static void addReceiver() {
        System.out.print("Enter receiver name: ");
        String name = scanner.nextLine();

        System.out.print("Enter required food type: ");
        String foodType = scanner.nextLine();

        System.out.print("Enter required quantity in meals: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        Receiver receiver = new Receiver(receiverId, name, foodType, quantity, location);
        receivers.add(receiver);
        receiverId++;

        System.out.println("Receiver request added successfully.");
    }

    private static void showDonations() {
        if (donations.size() == 0) {
            System.out.println("No donations available.");
            return;
        }

        for (int i = 0; i < donations.size(); i++) {
            donations.get(i).display();
        }
    }

    private static void showReceivers() {
        if (receivers.size() == 0) {
            System.out.println("No receiver requests available.");
            return;
        }

        for (int i = 0; i < receivers.size(); i++) {
            receivers.get(i).display();
        }
    }

    private static void matchFood() {
        if (receivers.size() == 0) {
            System.out.println("Please add a receiver request first.");
            return;
        }

        showReceivers();
        System.out.print("Enter receiver ID to find matches: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Receiver selectedReceiver = null;
        for (int i = 0; i < receivers.size(); i++) {
            if (receivers.get(i).getId() == id) {
                selectedReceiver = receivers.get(i);
                break;
            }
        }

        if (selectedReceiver == null) {
            System.out.println("Receiver not found.");
            return;
        }

        DonationMatcher matcher = new DonationMatcher();
        ArrayList<FoodDonation> matches = matcher.findMatches(donations, selectedReceiver);

        if (matches.size() == 0) {
            System.out.println("No matching donations found.");
        } else {
            System.out.println("Best matches sorted by shortest available time:");
            for (int i = 0; i < matches.size(); i++) {
                matches.get(i).display();
            }
        }
    }

    private static void searchByLocation() {
        System.out.print("Enter location to search: ");
        String location = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < donations.size(); i++) {
            if (donations.get(i).getLocation().equalsIgnoreCase(location)) {
                donations.get(i).display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No donations found in this location.");
        }
    }

    private static void addSampleData() {
        donations.add(new FoodDonation(donationId++, "Green Bowl Cafe", "Rice Meals", 45, "Indiranagar", 3));
        donations.add(new FoodDonation(donationId++, "City Canteen", "Rice Meals", 30, "Indiranagar", 1));
        donations.add(new FoodDonation(donationId++, "Fresh Plate", "Bread", 60, "Koramangala", 2));

        receivers.add(new Receiver(receiverId++, "Helping Hands NGO", "Rice Meals", 25, "Indiranagar"));
        receivers.add(new Receiver(receiverId++, "Night Shelter", "Bread", 40, "Koramangala"));
    }
}
