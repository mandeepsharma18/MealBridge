const donations = [
    {
        donor: "Green Bowl Cafe",
        foodType: "Rice Meals",
        quantity: 45,
        location: "Indiranagar",
        availableHours: 3
    },
    {
        donor: "City Canteen",
        foodType: "Rice Meals",
        quantity: 30,
        location: "Indiranagar",
        availableHours: 1
    },
    {
        donor: "Fresh Plate",
        foodType: "Bread",
        quantity: 60,
        location: "Koramangala",
        availableHours: 2
    },
    {
        donor: "Community Kitchen",
        foodType: "Vegetarian Meals",
        quantity: 80,
        location: "Whitefield",
        availableHours: 4
    },
    {
        donor: "Snack House",
        foodType: "Snacks",
        quantity: 25,
        location: "MG Road",
        availableHours: 2
    }
];

const results = document.getElementById("results");
const foodType = document.getElementById("foodType");
const locationInput = document.getElementById("location");
const quantity = document.getElementById("quantity");
const matchButton = document.getElementById("matchButton");
const mealCount = document.getElementById("mealCount");
const matchCount = document.getElementById("matchCount");

function findMatches() {
    const requiredFood = foodType.value;
    const requiredLocation = locationInput.value;
    const requiredQuantity = Number(quantity.value);

    const matches = [];

    for (let i = 0; i < donations.length; i++) {
        const donation = donations[i];

        if (
            donation.foodType === requiredFood &&
            donation.location === requiredLocation &&
            donation.quantity >= requiredQuantity
        ) {
            matches.push(donation);
        }
    }

    for (let i = 0; i < matches.length - 1; i++) {
        for (let j = 0; j < matches.length - i - 1; j++) {
            if (matches[j].availableHours > matches[j + 1].availableHours) {
                const temp = matches[j];
                matches[j] = matches[j + 1];
                matches[j + 1] = temp;
            }
        }
    }

    showMatches(matches);
}

function showMatches(matches) {
    results.innerHTML = "";
    matchCount.textContent = matches.length;

    if (matches.length === 0) {
        results.innerHTML = "<div class=\"empty-state\">No matching donation found for this request. Try changing the food type, quantity, or location.</div>";
        return;
    }

    for (let i = 0; i < matches.length; i++) {
        const donation = matches[i];
        const card = document.createElement("article");
        card.className = "donation-card";
        card.innerHTML = `
            <div>
                <h4>${donation.donor}</h4>
                <p>${donation.quantity} ${donation.foodType} available in ${donation.location}</p>
            </div>
            <span class="badge">${donation.availableHours} hr left</span>
        `;
        results.appendChild(card);
    }
}

function updateTotalMeals() {
    let total = 0;
    for (let i = 0; i < donations.length; i++) {
        total = total + donations[i].quantity;
    }
    mealCount.textContent = total;
}

matchButton.addEventListener("click", findMatches);
foodType.addEventListener("change", findMatches);
locationInput.addEventListener("change", findMatches);
quantity.addEventListener("input", findMatches);

updateTotalMeals();
findMatches();
