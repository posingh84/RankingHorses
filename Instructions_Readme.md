ATG Assignment Application

Steps to build,deploy and test: 

Prerequisites :

1. Maven 3.6 or higher version
2. Java 8 or higher
3.Docker 2.3.0 or higher version (OPTIONAL)

Steps to run the application :

1. Unzip the distribution file ATG_ASSIGNMENT_POONAM.rar to a folder on your local machine.

2. Set the distribution folder as your present working directory

3. Build the application using maven with the following command
 >mvn clean install
 
4. Run the SpringBoot Application as a standalone Application using the following command:
 >cd target
 >java -jar HarryKartApplication.jar
 
 Alternatively to run the application as a docker application run the follwoing command
 >mvn clean install -Ddocker
 >docker run -p 8080:8080 harry-kart:latest 

5. To test the application, use one of the following approached

 1.Execute the below URL using postman, a web browser 
   POST  http://localhost:8080/api/play
   Include the xml file in the request body as a raw xml file
 2.Use the curl CLI utility
	Eg: curl -X POST "http://localhost:8080/api/play" -H "accept: application/json" -H "Content-Type: application/xml" -d "<harryKart> <numberOfLoops>3</numberOfLoops> <startList> <participant> <lane>1</lane> <name>TIMETOBELUCKY</name> <baseSpeed>10</baseSpeed> </participant> <participant> <lane>2</lane> <name>CARGO DOOR</name> <baseSpeed>10</baseSpeed> </participant> <participant> <lane>3</lane> <name>HERCULES BOKO</name> <baseSpeed>10</baseSpeed> </participant> <participant> <lane>4</lane> <name>WAIKIKI SILVIO</name> <baseSpeed>10</baseSpeed> </participant> </startList> <powerUps> <loop number=\"1\"> <lane number=\"1\">0</lane> <lane number=\"2\">0</lane> <lane number=\"3\">1</lane> <lane number=\"4\">3</lane> </loop> <loop number=\"2\"> <lane number=\"1\">10</lane> <lane number=\"2\">0</lane> <lane number=\"3\">0</lane> <lane number=\"4\">1</lane> </loop> </powerUps></harryKart>"		
  3.Use the url http://localhost:8080/swagger-ui.html to look at the swagger   documentation of the API.To execute the POST API launch the url: 
  
    http://localhost:8080/swagger-ui.html#/HarryKart_Ranking_System
	Pass the Xml data in the request body.



