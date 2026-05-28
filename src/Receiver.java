public class Receiver {
    private int id;
    private String name;
    private String requiredFoodType;
    private int requiredQuantity;
    private String location;

    public Receiver(int id, String name, String requiredFoodType, int requiredQuantity, String location) {
        this.id = id;
        this.name = name;
        this.requiredFoodType = requiredFoodType;
        this.requiredQuantity = requiredQuantity;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRequiredFoodType() {
        return requiredFoodType;
    }

    public int getRequiredQuantity() {
        return requiredQuantity;
    }

    public String getLocation() {
        return location;
    }

    public void display() {
        System.out.println("Receiver ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Required Food Type: " + requiredFoodType);
        System.out.println("Required Quantity: " + requiredQuantity + " meals");
        System.out.println("Location: " + location);
        System.out.println("--------------------------------");
    }
}
