# Place Order Program
This project takes a csv file full of Delivery information in the devtest.csv format and uses this to place orders on a system using a series of APIs.
The initial is the authenitication api in which a username and password is sent in the body of the api and a token is retrieved in the response which can be used for access to following apis.
The second api is the place order api which sends the delivery information alongside the product order to the appropriate system giving further infomation back.
The name of each person ordering and the appropriate order number is then returned. These Apis are NOT opensource so did not add them into the program :)

- To Run this Project navigate to the target directory and run the following command:
  - java -jar Run_Place_Order.jar "path to csv file being processed"
- For example:
  - java -jar Run_TechAssessment.jar "C://Users/will_/IdeaProjects/Place_Order_Program/src/main/java/Place/Order/Program/devtest.csv"
 
- If the above does not work navigate to the root of the project and run the following command:
  - mvn clean compile assembly:single
- Then run the generated Jar file in the same way as above using the appropriate jar filename
       
*NOTE:* 
- The commenting frequency is not usually this frequent this was carried out to try and show my thinking during the exercise 
- If this was a piece of work to be put into production I would have written more testing on each method and 
     the whole program end to end. Please see a couple of the basic unit tests I have written as an 
     example in test\java\Place.Order.Program.PLaceOrderTest



