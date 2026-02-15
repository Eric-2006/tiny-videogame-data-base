# Tiny Videogame Database

A Java-based utility designed to manage and organize a collection of video game data using Object-Oriented Programming (OOP).

## Project Overview

The main objective of this project is to create a structured system to store, search, and manage information about video games. It demonstrates how to handle data records using Java classes and how to interact with that data through a simple interface.
1. **Data Management:** Allows listing, removing and getting information of video games.
2. **Search Logic:** Includes functionality to find specific games within the database based on different criteria.
3. **Structured Storage:** Uses arrays or lists to keep the game collection organized in memory during execution.

The program focuses on maintaining data integrity and providing a clear way to visualize the stored collection.

## Key Features

* **Record Handling:** Defines a custom object structure to represent a "Video Game" with all its necessary attributes.
* **Information Retrieval:** Implements logic to filter or search through the database efficiently.
* **Encapsulation:** Protects the database records using private fields and controlled access through getter and setter methods.
* **Scalability:** Designed so that more fields (like release year or rating) can be easily added to the game records.

## Technologies Used

* **Language:** Java.
* **Standard:** Developed using Java SE standards.
* **External Library:** ACM Java Task Force (`acm.jar`).

## Dependencies

This project requires the **ACM Java Task Force** library (`acm.jar`) for input/output handling and display.

## How to Run (Terminal)

1.  **Compile**:
    ```bash
    javac -cp ".:/path/to/your/acm.jar" Main.java
    ```
2.  **Run**:
    ```bash
    java -cp ".:/path/to/your/acm.jar" Main
    ```
*(Note: Replace `MainDatabase.java` with your actual main file name and `/path/to/your/acm.jar` with the real path. On Windows, use a semicolon `;` instead of a colon `:`).*

## Technical Note (Language)
The output console prints are written in **Catalan**, as it was an academic project for the University of Lleida (UdL) as part of the **Computer Science degree (Programació II, 2024-2025)**. This documentation is provided in English for universal portfolio visibility.

---
**Developed by:** Eric Buenavida Crespo.
