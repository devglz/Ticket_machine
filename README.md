# Biletomat
A simple ticket vending machine simulator written in Java. The program is designed to simulate two ticket vending machines, each identified by a unique ID and located at a different address. The vending machines can issue two types of tickets: a regular ticket and a reduced ticket.

## Implementation details
The program consists of the following components:
• Bilet - an interface representing a ticket, with two implementing classes:

• BiletNormalny - a class representing a regular ticket

•	BiletUlgowy - a class representing a reduced ticket

•	Serwis - an interface representing a maintenance service, with two methods:

•	napraw() - a method simulating the maintenance of the vending machine

•	wypiszLog() - a method for displaying a log of transactions performed on the machine

•	Pieniadz - an interface representing a money processing service, with one method:

•	odejmijKwote(double kwota) - a method for subtracting a given amount of money from the total balance of the machine

•	Biletomat - the main class representing the vending machine, with the following properties:

•	identyfikator - a unique identifier of the machine

•	adres - an address of the machine

•	CENA_NORMALNEGO - a constant representing the price of a regular ticket

•	CENA_ULGOWEGO - a constant representing the price of a reduced ticket

•	listaTransakcji - an ArrayList holding a log of transactions performed on the machine

•	main() - the main method of the program, which simulates the user interface

•	obsluzBiletomat() - a method simulating the operation of the machine

•	dodajTransakcje(Transakcja transakcja) - a method for adding a transaction to the log

•	drukujBilet(Bilet bilet) - a method for printing a ticket

•	zwrocReszte(double reszta) - a method for giving back change

•	wyswietlTransakcje() - a method for displaying the log of transactions performed on the machine

## How to use
The program simulates two ticket vending machines, which can be selected by the user. After selecting a vending machine, the user is prompted to select a ticket type: regular or reduced. If the selected ticket type requires a payment, the program prompts the user to enter the amount of money. The machine checks whether the amount of money is sufficient and, if it is, subtracts the ticket price from the balance and adds a transaction to the log. Finally, the machine prints the ticket and returns the change if needed. The user can also display the log of transactions or exit the program.

## Future improvements
•	Add support for more types of tickets
•	Implement a graphical user interface
•	Add support for online payments

