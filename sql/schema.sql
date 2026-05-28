CREATE DATABASE mealbridge;

USE mealbridge;

CREATE TABLE donations (
    donation_id INT PRIMARY KEY,
    donor_name VARCHAR(100),
    food_type VARCHAR(50),
    quantity INT,
    location VARCHAR(100),
    available_hours INT
);

CREATE TABLE receivers (
    receiver_id INT PRIMARY KEY,
    receiver_name VARCHAR(100),
    required_food_type VARCHAR(50),
    required_quantity INT,
    location VARCHAR(100)
);

INSERT INTO donations VALUES
(1, 'Green Bowl Cafe', 'Rice Meals', 45, 'Indiranagar', 3),
(2, 'City Canteen', 'Rice Meals', 30, 'Indiranagar', 1),
(3, 'Fresh Plate', 'Bread', 60, 'Koramangala', 2);

INSERT INTO receivers VALUES
(1, 'Helping Hands NGO', 'Rice Meals', 25, 'Indiranagar'),
(2, 'Night Shelter', 'Bread', 40, 'Koramangala');

SELECT * FROM donations;

SELECT * FROM receivers;

SELECT *
FROM donations
WHERE food_type = 'Rice Meals'
AND quantity >= 25
AND location = 'Indiranagar'
ORDER BY available_hours ASC;
