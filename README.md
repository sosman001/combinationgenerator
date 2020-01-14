# combinationgenerator
To start up the combination generator, run the following command:

java -jar target/combinations-0.0.1.jar

To execute the service perform the following REST call (3 being the number of balls):

GET http://localhost:8080/combinations/3

Response example (JSON format):

{
  "combinations": 3
}
