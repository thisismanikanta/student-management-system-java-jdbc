# Student Management System

A **menu-driven CRUD application** built with **Java**, **JDBC**, and **MySQL**, designed to manage student records. This is a console-based project suitable for beginners learning **Java Full Stack Development**.

---

## 🔹 Features

- Add a new student record  
- View all student records  
- Update student information (course)  
- Delete a student record  
- Exit the program  

All data is stored in a **MySQL database**.

---

## 🔹 Technologies Used

- **Java** (Core Java, Scanner, JDBC)  
- **MySQL** (Database)  
- **Eclipse IDE** (Development)  
- **Git & GitHub** (Version control)

---

## 🔹 Database Setup

Create the database and table in MySQL:

```sql
CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE students(
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    course VARCHAR(50)
);
