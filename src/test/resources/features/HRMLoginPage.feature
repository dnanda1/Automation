Feature: Login to HRM Application 
 
   @ValidCredentials
   Scenario: Login with valid credentials
     
    Given User is on HRMLogin page
    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login sucessfully and new page open
    
    @InvalidCredentials
    Scenario: Login with invalid credentials
     
    Given User is on HRMLogin page
    When User enters username as "Admin1" and password as "admin123"
    Then User should not be able to login sucessfully and new page should not open
    
    Scenario: Login and Logout successfully
     
    Given User is on HRMLogin page
    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login sucessfully and new page open
    Then User should successfully able to logout
    And User should be able to redirect to login screen
    
    Scenario: Login and Logout and Login again
     
    Given User is on HRMLogin page
    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login sucessfully and new page open
    Then User should successfully able to logout
    And User should be able to redirect to login screen
    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login sucessfully and new page open
    Then User should successfully able to logout