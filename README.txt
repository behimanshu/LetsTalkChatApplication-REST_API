Pre-requisites:
----------------
-----------------


MYSql installation:

 - Install MYSQL workbench 6.3
 - Run the given query to set up the database
 - Start the MYSQL Server


Installation of REST API Client:

 - Consider installing a browser enabled REST API Client, to run all the REST calls for the application
	For example: RESTED Chrome extension
	Link to download - https://chrome.google.com/webstore/detail/rested/eelcnbccaccipfolokglfhhmapdchbfg?hl=en-US

Double click on the SQLScript file that has been attached to create a database

Running the User API Calls: 
--------------------------------
--------------------------------

This chat webservice is a 2-way messaging system, that allows the users to send messages to each other and check
their respective messages.


Only authenticated users, who have registered and have a valid userID and password, can access the Resource URIs


1) API call to get all the users in the database:

As individual calls require authentication, please run this URL on the browser first, enter loginID and password, and then run the URL on REST API client,
throughout the session.

 - Select GET as the API call from the dropdown in REST API Client, and run this call
	http://localhost:8080/letsTalk/users
-------------------------------------------------------------------------------


2) API call to get a users of a particular username

 - Select GET as the API call from the dropdown in REST API Client, and run this call
	Format: http://localhost:8080/letsTalk/users/{username}
	Sample: http://localhost:8080/letsTalk/users/test_20
--------------------------------------------------------------------------------------
3) API call to register a new user into the database

 - Select POST as the API call from the dropdown in REST API Client
 - Go to Headers section and write
	Key: Content-type
	Value: application/json
- Fill the body with JSON content of a new department
 	Eg: {
    
		"username": "test_13",
  
 		"name": "Test",
    
		"password": "Test",
    
		"age": 20,
    
		"gender": "M",
    
		"email_address": "h@gmail.com",
   
 		"profession": "searching"
 
	    }
****Make sure password entry and userName entry is definitely filled, otherwise exception would be thrown

- Run this below mentioned call and hit send
	http://localhost:8080/letsTalk/register
-----------------------------------------------------------------------------------------------------------------------------------------------------
4) API call to update any user details

 - Select PUT as the API call from the dropdown in REST API Client
 - Go to Headers section and write
	Key: Content-type
	Value: application/json
- Fill the body with JSON content of a new department
 	Eg: {
    
		"username": "test_13",
  
 		"name": "Test20",
    
		"password": "Test14",
    
		"age": 24,
    
		"gender": "F",
    
		"email_address": "h@gmail.com",
   
 		"profession": "searching"
 
	    }

- Run this below mentioned call and hit send
	Format: http://localhost:8080/letsTalk/users/{username}
	Sample: http://localhost:8080/letsTalk/users/test_13
------------------------------------------------------------------------------------------------------------------------------------------------------	
5) API call to remove a user of a particular username

 - Select DELETE as the API call from the dropdown in REST API Client, and run this call
	Format: http://localhost:8080/letsTalk/users/{username}
	Sample: http://localhost:8080/letsTalk/users/test_13
--------------------------------------------------------------------------------------------------------------------------------------------------------





Running the Message API Calls: 
--------------------------------
--------------------------------

1) API call to get all the messages sent by a particular user

 - Select GET as the API call from the dropdown in REST API Client, and run this call
	Format: http://localhost:8080/letsTalk/users/{username}/sentMessages
	Sample: http://localhost:8080/letsTalk/users/test_13/sentMessages
------------------------------------------------------------------------------------------------
2) API call to get all the messages recevied by a particular user

 - Select GET as the API call from the dropdown in REST API Client, and run this call
	Format: http://localhost:8080/letsTalk/users/{username}/receivedMessages
	Sample: http://localhost:8080/letsTalk/users/test_13/receivedMessages
-------------------------------------------------------------------------------------------------
3) API call to send a message from one user to another

 - Select POST as the API call from the dropdown in REST API Client
 - Go to Headers section and write
	Key: Content-type
	Value: application/json
- Fill the body with JSON content of a new department
 	Eg: {
    "messageContent":"This is a sample text"
  }

- Run this below mentioned call and hit send
	Format: http://localhost:8080/letsTalk/{username}/sendMessage/{username}
	Sample: http://localhost:8080/letsTalk/test_13/sendMessage/west_13
-----------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------	
4) API call by admin to remove a message 

 - Select DELETE as the API call from the dropdown in REST API Client, and run this call
	Format: http://localhost:8080/letsTalk/messages/{messageId}
	Sample: http://localhost:8080/letsTalk/messages/1
--------------------------------------------------------------------------------------------------------------------------------------------------------

	