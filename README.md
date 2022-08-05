## Environment:
- Java version: 1.8
- Maven version: 3.*
- Spring Boot version: 2.2.1.RELEASE

## Data:

Description of a user data JSON object:
    
```json
{
   "id": "the unique ID of the user (Integer)",
   "name": "full name",
   "email": "unique email in format ^[A-z0-9+_\.-]+@[A-z]{1,}\.cl",
   "password": "",
   "isActive": "true if active and false if not",
   "phones": [{
     "country_code": "2 character country code",
     "city_code": "1 character city code",
     "number": "phone number"
   }],
  "auditTrail": {
     "created_on": "creation date and time",
     "updated_on": "last date and time modification",
     "last_login": "last date and time login"
  }
}
```

Note: The Audit information is filled automatically.

## Examples

Returns all users
```
GET https://localhost:8080/users
```
Returns only one user with id 1
```
GET https://localhost:8080/users/1
```
Remove a user with the id 1
```
DELETE https://localhost:8080/users/1
```
Replace or create a user with the id 1
```
PUT https://localhost:8080/users/1
```

`PATCH` is not supported:

* the response code is 405 because the API does not allow partial modifications

## Parameters

The regular expression with which the password is validated can be set in the **application.properties** 
under key **user.password.regexp**

## Commands
- run: 
```bash
mvn clean package -Dmaven.test.skip=true; java -jar target/springboot-github-users-api-1.0.jar
```
- install: 
```bash
mvn clean install
```
- test: 
```bash
mvn clean test
```
