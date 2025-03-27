# Quiz Application Backend

## Overview
This is the backend service for the Quiz Application, which allows users to create, update, delete, and retrieve quiz questions. Users can also take quizzes based on different subjects. The backend is built using **Spring Boot** with **MySQL** as the database and follows a RESTful API design.

## Features
- **User Authentication & Authorization**
  - Role-based access control (Admin can create, update, delete questions, Users can take quizzes)
- **CRUD Operations for Questions**
  - Create new quiz questions
  - Retrieve questions by subject or ID
  - Update existing questions
  - Delete questions
- **Quiz Functionality**
  - Users can take quizzes based on a selected subject
  - Score calculation upon quiz completion
- **Database Integration**
  - Uses MySQL for storing quiz questions and user data
- **Email Notifications** (Optional)
  - Users may receive quiz results via email

## Tech Stack
- **Backend Framework:** Spring Boot
- **Database:** MySQL
- **ORM:** Hibernate
- **Security:** Spring Security with JWT authentication
- **Email Service:** SMTP (for notifications, if enabled)
- **API Documentation:** Swagger

## Installation & Setup

### Prerequisites
Ensure you have the following installed:
- Java 17 or later
- Maven
- MySQL Server

### Steps to Run the Project
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/quiz-app-backend.git
   cd quiz-app-backend
