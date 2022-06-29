# Breach-Monitoring
# Data Breach Monitoring Web App

The aim of this project is to allow a user to easily monitor a list of credentials, giving them the option to notify them and/or each individual user
based on their use case)

##



[ done ] backend 


[ in progress ] Frontend with React 


## 
Backend for a web application built with Java Spring (Maven), MySQL and Redis 

Business logic fetches user defined lists of credentials and stored in a mySQL database to perform operations

_________________________________________________________________________________________________________________________________________________

_________________________________________________________________________________________________________________________________________________
## API Documentation
Base URL: {hostname}:8080/

Endpoints:

**GET** /credentials/ 
=======
Service layer logic grabs user list of credentials input and puts it in a redis database
uses redis search indexing, and other cloud tools to allow the user to look at the database, search it in an SPA

_________________________________________________________________________________________________________________________________________________
[to do]                     
Implement a cache with redis


_________________________________________________________________________________________________________________________________________________
##  RESOURCE 

Path:  <ip-address>:8080/credentials

**/getAll**

Retrieves all 
**/addnew**
>>>>>>> 91bf3372 (fixed new services and repos)

Lists all credentials

<<<<<<< HEAD
**PUT**  /credentials/{id} 
=======
**/recheck/id**
>>>>>>> 91bf3372 (fixed new services and repos)

Adds a credential to the user's list

<<<<<<< HEAD
**PUT**  /credentials/{id}
=======
**/delete/id**
>>>>>>> 91bf3372 (fixed new services and repos)

Refreshes compromised status

**DELETE**  /credentials/{id}

<<<<<<< HEAD
Removes credentials from the system
=======
**/notify/id***
>>>>>>> 91bf3372 (fixed new services and repos)

**PUT** /notify/

Sends an email to all breached high alert level credentials

**PUT** /notify/{id}/

Sends an email to a specific breached credential



_________________________________________________________________________________________________________________________________________________

