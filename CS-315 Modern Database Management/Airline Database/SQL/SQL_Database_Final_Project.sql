/* Samuel Puchinskiy */




/* Droping Tables */
DROP TABLE IF EXISTS Origin_Airport;
DROP TABLE IF EXISTS Destination_Airport;
DROP TABLE IF EXISTS Airline;
DROP TABLE IF EXISTS Hours;
DROP TABLE IF EXISTS Flight;




/* Creating Tables */
CREATE TABLE Origin_Airport
(
    oriA_id INT AUTO_INCREMENT,
	oriA_name VARCHAR(30),
	oriA_country VARCHAR(30),
	oriA_state VARCHAR(30),
	oriA_city VARCHAR(30),
	oriA_zipcode INT(10),
	PRIMARY KEY (oriA_id)
);

CREATE TABLE Destination_Airport
(
    destA_id INT AUTO_INCREMENT,
	destA_name VARCHAR(30),
	destA_country VARCHAR(30),
	destA_state VARCHAR(30),
	destA_city VARCHAR(30),
	destA_zipcode INT(10),
	PRIMARY KEY (destA_id)
);

CREATE TABLE Airline
(
    air_id INT AUTO_INCREMENT,
	air_name VARCHAR(30),
	air_totalEconomyCapacity INT(2), 
	air_totalBusinessCapacity INT(2), 
	air_totalFirstClassCapacity INT(2), 
	air_economyTicketCost DECIMAL(7,2), 
	air_businessTicketCost DECIMAL(7,2), 
	air_firstClassTicketCost DECIMAL(7,2),
	PRIMARY KEY (air_id)
);

CREATE TABLE Hours
(
	hour_id INT AUTO_INCREMENT,
	hour_depature VARCHAR(5), 
	hour_arrival VARCHAR(5),
	PRIMARY KEY (hour_id)
);

CREATE TABLE Flights
(
	oriA_id INT,
	destA_id INT,
	air_id INT,
	hour_id INT,
	FOREIGN KEY (oriA_id) REFERENCES Origin_Airport(oriA_id),
	FOREIGN KEY (destA_id) REFERENCES Destination_Airport(destA_id),
	FOREIGN KEY (air_id) REFERENCES Airline(air_id),
	FOREIGN KEY (hour_id) REFERENCES Hours(hour_id),
	PRIMARY KEY (oriA_id, destA_id, air_id, hour_id),
	flight_id VARCHAR(50) DEFAULT 'FLIGHT_ID-OA00-DA00-AR00-HR00'
);




/* Inserting Data to Tables */
INSERT INTO Origin_Airport (oriA_name, oriA_country, oriA_state, oriA_city, oriA_zipcode)
VALUES
    ('Ohare', 'United States', 'Illinois', 'Chicago', 60666),
    ('Midway', 'United States', 'Illinois', 'Chicago', 60638),
	('LAX', 'United States', 'California', 'Los Angeles', 90045),
	('JFK', 'United States', 'New York', 'Queens', 11430),
	('Hanedakuko', 'Japan', 'Tokyo', 'Ota City', 1440041),
	('London City', 'United Kingdom', 'London', 'Royal Docks', 72046),
	('Charles de Gaulle', 'France', 'Paris ', 'Charles de Gaulle', 95700),
	('Heydar Aliyev', 'Azerbaijan', 'Baku', 'Settlement', 1109),
	('Toronto Pearson', 'Canada', 'Toronto', 'Ontario', 906),
	('Ben Gurion', 'Israel', 'Tel Aviv', 'Ben Gurion', 70100);
	
	

INSERT INTO Destination_Airport (destA_name, destA_country, destA_state, destA_city, destA_zipcode)
VALUES
    ('Ohare', 'United States', 'Illinois', 'Chicago', 60666),
    ('Midway', 'United States', 'Illinois', 'Chicago', 60638),
	('LAX', 'United States', 'California', 'Los Angeles', 90045),
	('JFK', 'United States', 'New York', 'Queens', 11430),
	('Hanedakuko', 'Japan', 'Tokyo', 'Ota City', 1440041),
	('London City', 'United Kingdom', 'London', 'Royal Docks', 72046),
	('Charles de Gaulle', 'France', 'Paris ', 'Charles de Gaulle', 95700),
	('Heydar Aliyev', 'Azerbaijan', 'Baku', 'Settlement', 1109),
	('Toronto Pearson', 'Canada', 'Toronto', 'Ontario', 906),
	('Ben Gurion', 'Israel', 'Tel Aviv', 'Ben Gurion', 70100);
	
INSERT INTO Hours (hour_depature, hour_arrival)
VALUES
	('00:00', '13:00'),
	('01:00', '14:00'),
	('03:00', '15:00'),
	('04:00', '16:00'),
	('05:00', '17:00'),
	('06:00', '18:00'),
	('07:00', '19:00'),
	('08:00', '20:00'),
	('09:00', '21:00'),
	('10:00', '22:00'),
	('11:00', '23:00'),
	('12:00', '24:00');
	
INSERT INTO Airline (air_name, air_totalEconomyCapacity, air_totalBusinessCapacity, air_totalFirstClassCapacity, air_economyTicketCost, air_businessTicketCost, air_firstClassTicketCost)
Values
		('United Airlines', 50, 30, 10, 250.00, 500.00, 1000.00),
		('Hawaiian Airlines', 30, 0, 20, 2500.00, 0.00, 10000.00),
		('Southwest Airlines', 90, 25, 10, 500.00, 1000.00, 25000.00),
		('British Airways', 60, 40, 0, 50.00, 500.00, 0.00),
		('Air France', 40, 80, 20, 2500.00, 5000.00, 50000.00),
		('Japan Airlines', 20, 40, 35, 500.00, 1000.00, 25000.00),
		('Air Canada', 90, 20, 10, 250.00, 500.00, 1000.00),
		('Air India', 80, 30, 20, 300.00, 1000.00, 8000.00)
    
	
INSERT INTO Flights (oriA_id, destA_id, air_id, hour_id, flight_id)
VALUES	
	(1, 3, 3, 4, 'FLIGHT_ID-OA01-DA03-AR03-HR04'),
	(5, 3, 6, 12, 'FLIGHT_ID-OA05-DA03-AR06-HR12'),
	(6, 8, 4, 11, 'FLIGHT_ID-OA06-DA08-AR04-HR11'),
	(10, 9, 7, 8, 'FLIGHT_ID-OA10-DA09-AR07-HR08'),
	(7, 2, 5, 2, 'FLIGHT_ID-OA07-DA02-AR05-HR02'),
	(4, 6, 4, 7, 'FLIGHT_ID-OA04-DA06-AR04-HR07'),
	(10, 8, 8, 3, 'FLIGHT_ID-OA10-DA08-AR08-HR03'),
	(3, 4, 1, 1, 'FLIGHT_ID-OA03-DA04-AR01-HR01')



	
/* Creating a View with Joins */
CREATE OR REPLACE VIEW Flights_Info AS
SELECT oriA_name AS 'Origin Airport', destA_name AS 'Destination Airport', air_name AS 'Airline', hour_depature AS 'Depature Time', hour_arrival AS 'Arrival Time', flight_id AS 'Flight ID'
FROM Origin_Airport INNER JOIN Destination_Airport INNER JOIN Airline INNER JOIN Hours INNER JOIN Flights
ON Origin_Airport.oriA_id = Flights.oriA_id AND Destination_Airport.destA_id = Flights.destA_id AND Airline.air_id = Flights.air_id AND Hours.hour_id = Flights.air_id;