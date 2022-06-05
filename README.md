# Breach-Monitoring
# Data Breach Monitoring Web App

[ done ] Backend - MVC style architecture Java Spring backend with a mySQL database
[ in progress ] Frontend - Mapping endpoints to React 
[ planned ] PWA functionality
_________________________________________________________________________________________________________________________________________________
Backend for a web application built with Java + Spring + Maven + Redis 

Exposes endpoints for a react front end to fetch

Business logic grabs user list of credentials input and puts it in a redis database
uses redis search indexing, and other cloud tools to allow the user to look at the database, search it in an SPA

allows users to individual/multiple select and click buttons that perform the respective requests to the RESTful endpoint
_________________________________________________________________________________________________________________________________________________
[to do]                     
implement a cache w/ redis

_________________________________________________________________________________________________________________________________________________
**MODEL**
credential schema

schema:
{
email
username
password
compromisedStatus
}

_________________________________________________________________________________________________________________________________________________
**CONTROLLER**
ENDPOINTS: Implemented this controller resource in Java Spring that performs specified functions in service layer

/addCredential

adds credential to your list
needs email || username

/recheckCredentials

pulls credentials and performs a check depending on what information is available, can check email, password, and/or both
updates compromisedStatus

/deleteCredential
deletes selected credentials from database
--add undo

/notify
Notifies selected emails with twilio sendgrid that their password showed up in a breach and should be updated



_________________________________________________________________________________________________________________________________________________
**VIEW**
React Frontend
<header>
  Navbar Component
  <Navbar />
  </header>
<body>
View Component: In Progress
<div id = view>
  <div id = search-bar/>
  <div id = credentialsTable>
</div>

  
Button Components: In Progress
 <button id=AddCredential />
 <button id=Recheck />
 <button id=Delete />
 <button id=Notify />
  </body>
  
 
