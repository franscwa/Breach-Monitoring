# Breach-Monitoring
# Data Breach Monitoring Web App

The aim of this project is to allow a user to easily monitor a list of credentials, giving them the option to notify them and/or each individual user
based on their use case (personal / enterprise)

##



[ done ] backend 


[ in progress ] Frontend - Mapping endpoints to React 


## 
Backend for a web application built with Java Spring, Maven, MySQL and Redis 

Business logic fetches user defined lists of credentials and stored in a mySQL database to perform operations

_________________________________________________________________________________________________________________________________________________
[to do]                     
Caching with Redis
_________________________________________________________________________________________________________________________________________________
## API Documentation
Base URL: {hostname}:8080/

Endpoints:

**GET** /credentials/ 

Lists all credentials

**PUT**  /credentials/{id} 

Adds a credential to the user's list

**PUT**  /credentials/{id}

Refreshes compromised status

**DELETE**  /credentials/{id}

Removes credentials from the system

**PUT** /notify/

Sends an email to all breached high alert level credentials

**PUT** /notify/{id}/

Sends an email to a specific breached credential



_________________________________________________________________________________________________________________________________________________

