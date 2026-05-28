import java.util.ArrayList;

public class DonationMatcher {
    public ArrayList<FoodDonation> findMatches(ArrayList<FoodDonation> donations, Receiver receiver) {
        ArrayList<FoodDonation> matches = new ArrayList<FoodDonation>();

        for (int i = 0; i < donations.size(); i++) {
            FoodDonation donation = donations.get(i);

            boolean sameFoodType = donation.getFoodType().equalsIgnoreCase(receiver.getRequiredFoodType());
            boolean enoughQuantity = donation.getQuantity() >= receiver.getRequiredQuantity();
            boolean sameLocation = donation.getLocation().equalsIgnoreCase(receiver.getLocation());

            if (sameFoodType && enoughQuantity && sameLocation) {
                matches.add(donation);
            }
        }

        sortByUrgency(matches);
        return matches;
    }

    private void sortByUrgency(ArrayList<FoodDonation> donations) {
        for (int i = 0; i < donations.size() - 1; i++) {
            for (int j = 0; j < donations.size() - i - 1; j++) {
                FoodDonation first = donations.get(j);
                FoodDonation second = donations.get(j + 1);

                if (first.getAvailableHours() > second.getAvailableHours()) {
                    donations.set(j, second);
                    donations.set(j + 1, first);
                }
            }
        }
    }
}
