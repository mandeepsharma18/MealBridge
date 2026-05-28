public class FoodDonation {
    private int id;
    private String donorName;
    private String foodType;
    private int quantity;
    private String location;
    private int availableHours;

    public FoodDonation(int id, String donorName, String foodType, int quantity, String location, int availableHours) {
        this.id = id;
        this.donorName = donorName;
        this.foodType = foodType;
        this.quantity = quantity;
        this.location = location;
        this.availableHours = availableHours;
    }

    public int getId() {
        return id;
    }

    public String getDonorName() {
        return donorName;
    }

    public String getFoodType() {
        return foodType;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getLocation() {
        return location;
    }

    public int getAvailableHours() {
        return availableHours;
    }

    public void display() {
        System.out.println("Donation ID: " + id);
        System.out.println("Donor: " + donorName);
        System.out.println("Food Type: " + foodType);
        System.out.println("Quantity: " + quantity + " meals");
        System.out.println("Location: " + location);
        System.out.println("Available For: " + availableHours + " hours");
        System.out.println("--------------------------------");
    }
}
