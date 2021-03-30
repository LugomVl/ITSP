Application " Rooms with light bulbs”
By visiting a web page, the user has the opportunity to:
- create a room by entering its name and country from the list. The country is needed to restrict users ' access to the room.
- view a list of created rooms (including rooms created by other users)
- "go" to one of the rooms and turn on / off the light bulb located in it.

If the user's country is different from the country of the room, an error is shown to the user when trying to enter the room.
The country is determined by the user's IP address.
Changing the status of the light bulb should be displayed to all users in the room (as quickly as possible, without reloading the
page)

Technologies used :

* Spring Boot 2.3.3
* Hibernate
* H2
* JUnit 4
* Maven
* IntelliJ IDEA

To launch the application, type in the command line:
java -jar target/ItsPartnerApp-1.0-SNAPSHOT.jar

After launching, it goes to the address:
http://localhost:8080/

The function of switching to a room is implemented from the "All rooms" page.
