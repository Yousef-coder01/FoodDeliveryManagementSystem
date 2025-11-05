A Java project simulating a food delivery system using **OOP** and **file I/O**, designed to manage customers, restaurants, and deliveries.

---

## 🚀 Features
- 👤 Supports **Regular** and **Golden** customers  
- 🍔 Manage restaurants and their menus  
- 🚗 Assign deliveries automatically to drivers or drones  
- 📦 Handle orders: create, view, track status  
- 📑 Generate reports summarizing system data  

---

## 🧠 Concepts Used
- Object-Oriented Programming (OOP):  
  - Classes, Inheritance, Polymorphism  
  - Abstract Classes & Interfaces  
- File I/O (`input.txt` for reading orders)  
- Encapsulation and modular class design  

---

## 🧩 Project Structure
FoodDeliveryManagementSystem/
├── src/
│ ├── Customer.java
│ ├── GoldenCustomer.java
│ ├── RegularCustomer.java
│ ├── Restaurant.java
│ ├── Order.java
│ ├── Driver.java
│ ├── Drone.java
│ ├── Delivery.java
│ ├── Test.java <-- Main class
│ └── input.txt
└── README.md
## 🧾 How to Run
1. Open in **IntelliJ IDEA** or any Java IDE  
2. Ensure `input.txt` is in the **project root**  
3. Run `Test.java` (contains `main` method)

Or in terminal:
```bash
javac src/*.java
java -cp src Test
