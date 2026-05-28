# MealBridge

MealBridge is a food donation matcher that connects people or restaurants with extra food to nearby receivers such as NGOs, shelters, and community groups.

The project is built to stay within beginner-friendly concepts: Java fundamentals, basic DSA, and simple SQL queries.

## Features

- Add food donations with donor name, food type, quantity, location, and available time
- Add receiver requests with required food type, quantity, and location
- Search donations by location
- Match receivers with suitable donations
- Sort matching donations by urgency using bubble sort
- Store the project data model using basic SQL tables
- Public web demo for deployment on Vercel

## Concepts Used

- Java classes and objects
- Encapsulation with private fields and getter methods
- ArrayList for storing records
- Linear search for filtering donations
- Bubble sort for sorting urgent donations first
- Scanner for menu-driven input
- Basic SQL table creation, insert, select, where, and order by

## Project Structure

```text
MealBridge/
├── src/
│   ├── Main.java
│   ├── FoodDonation.java
│   ├── Receiver.java
│   └── DonationMatcher.java
├── sql/
│   └── schema.sql
├── web/
│   ├── index.html
│   ├── style.css
│   └── script.js
├── vercel.json
└── README.md
```

## How to Run Java Project

Open a terminal inside the project folder and run:

```bash
cd src
javac *.java
java Main
```

## How to Use SQL File

Open `sql/schema.sql` in MySQL and run the queries. It creates the database, adds sample donation and receiver records, and shows a basic matching query.

## Web Demo

The `web` folder contains a simple browser demo of the matching idea. It is included so the project can be deployed and shared easily.

## Future Scope

- Add login for donors and receivers
- Connect Java project with a real database using JDBC
- Add pickup status tracking
- Add expiry warnings for urgent donations
- Add distance-based matching
