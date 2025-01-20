# Animal Care and Adoption Platform

This project is designed to assist animal shelters in managing daily operations, ensuring animals receive proper care, staff tasks are efficiently assigned, and records are meticulously maintained.

# Table of Contents
a) Technologies Used 
b) Features
c) Setup Instructions
d) About the Author

# Technologies Used
i)  Backend: Java, Spring Boot, Hibernate, PostgreSQL
ii) Frontend: JavaScript, Thymeleaf, Bootstrap, HTML, CSS
iii) APIs: Cloudinary API, Java Mail Sender

# Features 

## Dashboard ##
a) Task Management: Users can view their pending tasks for the week, along with deadlines and options to mark them as completed.
b) Notes: Users can create and delete personal notes.
c) Statistics: Displays current shelter statistics using Chart.js, including the number of animals, their species, and availability.

## Tasks ##
a) Add Task: Users can create new tasks with specific details and deadlines.
b) View Tasks: A comprehensive list of tasks is available, with options to edit or delete each task.

## Animals ##
a) Add Animal: Users can register new animals into the system, including uploading images via the Cloudinary API.
b) View Animals: Displays a list of all animals with details such as species, breed, age, and adoption status.
c) Edit Animal Details: Users can update animal information as needed.

## Staff ##
a) Add Staff Member: Allows the addition of new staff members with roles and contact information.
b) View Staff: Lists all staff members, their roles, and assigned tasks.
c) Edit Staff Details: Users can modify staff information and manage their responsibilities.

## Adoption Management ##
a) Adoption Requests: Users can view and manage adoption requests, including approving or declining applications.
b) Adoption Records: Maintains a history of all adoptions, including adopter details and animal information.

# Setup Instructions
1) Clone the Repository: git clone https://github.com/harshjaiswal848/Animal-care-and-adoption-platform.git
2) Navigate to the Project Directory: cd Animal-care-and-adoption-platform
3) Backend Setup: a) Ensure you have Java and Maven installed.
                  b) Configure the PostgreSQL database settings in src/main/resources/application.properties
                  c) Build the project using Maven: mvn clean install
                  d) Run the Spring Boot application: mvn spring-boot:run
4) Frontend Setup: a) Open the project in your preferred IDE.
                   b)Ensure that the frontend is correctly configured to interact with the backend services.
                   c) Start the frontend server as per your development environment requirements.

# About the Author
This project is maintained by WildTech Team. For any inquiries or contributions, please refer to the repository's contact information.

