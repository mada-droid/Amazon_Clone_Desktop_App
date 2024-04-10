# Amazon_Clone_Desktop_App

### Technologies Used:
- IDE: Eclipse
- To run the program, the IDE must have all Java AWT and Swing branches.
- SDK version 15 or higher.

### Administrative Access Credentials:
Username: admin
Password: admin

### Project Objective:
- Design an application for managing shipments of a company.
- The program has a graphical interface for interacting with the program itself.
- Utilize encapsulation, inheritance, and polymorphism mechanisms.
- Abstract classes and interfaces are used for inheritance.
- Utilize Java system classes for input/output management.
- Make use of library data structures and generics.
- The program is executable from the command line.

### Project Description:

### Features:
- Login and registration for customers to enter their shipment details.
- Specific login for the administrator (admin) of the shipping branch.
- Ability to update the status of each individual shipment.
- Personalized views (for customers and administrators) of shipment history and ongoing shipments.

### Login and Registration Management:
Upon launching the program, it will prompt whether to enter as an administrator or a customer.
This should be done through a specially designed graphical interface.
The administrator can enter with their username and password, defined statically within the code. It should not be possible to add additional administrators.
The customer can choose to register by providing their username, password, and address, or log in if they have already completed the registration process.
- The system must prohibit the registration of multiple users with the same username.
- The system must persistently save information regarding registered users.
- Login is performed using the username and password.
There should be an option to log out as a customer or admin and log in with a different account without necessarily closing the program.

### Shipment Characteristics:
An authenticated customer should be able to create one or more shipment requests associated with their account. The request for a shipment is completed by the customer by providing meaningful values to the following fields:
- A code, generated by concatenating the user's username with a progressive number and/or a string derived from other shipment characteristics (listed below).
- A destination.
- Weight in kg.
- Date of entry into the system.
- A status, described later.
- The date on which each shipment was made.

### A normal shipment is characterized by:
``` IN PREPARATION ```
‵‵‵ IN TRANSIT ‵‵‵
‵‵‵ RECEIVED or FAILED ‵‵‵

### An insured shipment, in addition to the fields of a normal shipment, adds the characteristic of insured value, which represents the amount of money a customer can request from the shipping company in case of shipment failure.

Once a normal shipment is entered into the system, it will have the following states:
- IN PREPARATION
- IN TRANSIT
- RECEIVED or FAILED

If the shipment is insured, two additional possible states are added:
‵‵‵ REFUND REQUESTED ‵‵‵
‵‵‵ REFUND ISSUED ‵‵‵

Upon the first entry of shipment data by the user, the shipment will be assigned the "IN PREPARATION" state. It will then be the responsibility of the admin to transition the shipment's state to one of the other states, following the detailed logic in the next section.

### Updating Shipment Status:
Once authenticated, the admin can view shipments from all customers in tabular format.
The admin must be able to change the status of each shipment.
The admin can remove shipments from the system that are in a final state. Removing an entry by the admin makes the shipment no longer visible to the customer.
Once authenticated, the customer can only view shipments entered with reference to their account in tabular format. The customer cannot change the status of shipments, with one exception: if the shipment was insured and is now in a FAILED state, they can change the status of that shipment. From FAILED, it can transition to REFUND REQUESTED.
