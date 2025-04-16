Project Title:

 GitHub OAuth2 Login with JWT Token – Assignment 4 (CST8277)
 
Student name:
 Yazid Mohamed
 
 Submission Date: April/16/2025
 Prof Name: Eugen Zimin
 
Description:
 This project is a simple Spring Boot application that demonstrates OAuth 2.0 Authorization Code Grant Flow using GitHub as the authentication provider. After a successful login through GitHub, the application generates a JWT (JSON Web Token) that includes the user's GitHub username. The token can be used to authorize access to other services or protected resources.
Technologies Used:
Java 21


Spring Boot


Spring Security


OAuth 2.0 Client (GitHub)


JSON Web Token (jjwt)


Maven


How It Works:
The user visits a protected endpoint like /token.


They are redirected to GitHub to log in and authorize the app.


After authorization, the app receives the user's details from GitHub.


A JWT is generated and returned to the user as a JSON response.


Endpoints:
/  Home page


/token – Returns a JWT after successful login


How to Run the App:
Clone the repository.


Make sure Java and Maven are installed.


Run the command mvn spring-boot:run.


Visit http://localhost:8080 in the browser.


Log in with GitHub and access /token.

 Client ID and secret for the GitHub OAuth App should be added to application.yml.
