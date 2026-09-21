# 🎓 Student Management System

A web-based Student Management System built using **Spring Boot, Spring Data JPA, MySQL, Thymeleaf, HTML, CSS and JavaScript**.

The application allows users to manage student records through a simple and responsive web interface.

---

## 🚀 Features

- ➕ Add Student
- 📋 View All Students
- 🔍 Search Student by Roll Number
- 🔎 Filter Students by Technology
- ✏️ Edit Student
- 🗑️ Delete Student
- 🗑️ Delete All Students
- ✅ Input Validation
- ⚠️ Global Exception Handling
- 🔐 Duplicate Roll Number Handling
- 📊 REST API
- 💾 MySQL Database Integration
- 🎨 Thymeleaf-based Web Interface
- 📱 Responsive UI

---

## 🛠️ Tech Stack

### Backend

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate

### Frontend

- HTML
- CSS
- JavaScript
- Thymeleaf

### Database

- MySQL

### Build Tool

- Maven

### Development Tools

- IntelliJ IDEA
- Git
- GitHub
- Postman

---

## 🏗️ Project Architecture

```text
                 ┌──────────────────────┐
                 │   Web Browser        │
                 │ HTML/CSS/JavaScript  │
                 └──────────┬───────────┘
                            │
                            ▼
                 ┌──────────────────────┐
                 │   Spring Boot       │
                 │    Controller       │
                 └──────────┬───────────┘
                            │
                            ▼
                 ┌──────────────────────┐
                 │      Service        │
                 │   Business Logic    │
                 └──────────┬───────────┘
                            │
                            ▼
                 ┌──────────────────────┐
                 │     Repository      │
                 │   Spring Data JPA   │
                 └──────────┬───────────┘
                            │
                            ▼
                 ┌──────────────────────┐
                 │       MySQL         │
                 │      Database       │
                 └──────────────────────┘