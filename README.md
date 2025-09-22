Provides information about Authors that are downloaded by webCrawler parsed and loaded by streamLoader  
Technical requirements:  
Java 21 or higher  
Apache Maven 3.9.x or later  
MongoDB 4.4+  
  
To Run a Project :  
mvn clean install  
java -jar teamsWebApi-1.0-VERSION.jar  
  
curl -X GET http://localhost:8080/authors  
[  
    { "name": "J.K. Rowling" },  
    { "name": "George Orwell" },  
    { "name": "Agatha Christie" }  
]  

    
curl -X GET http://localhost:8080/authors/George%20Orwell  
{  
    "id": 5,  
    "uid": "author-005",  
    "version": 1,  
    "name": "George Orwell",  
    "birthDate": "1903-06-25",  
    "birthLocation": "Motihari, India",  
    "description": "English novelist and essayist..."  
}  
  

