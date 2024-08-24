To run the Application, first add the database connectivity in application.properties file


example for connecting the mysql database in my case: provide url, username and password.

/*
spring.datasource.url=jdbc:mysql://localhost:3306/employee_directory 
spring.datasource.username=springstudent
spring.datasource.password=springstudent 
*/

and then run the sql script given below to create the database and table. 


/*

CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Sujeet','Singh','sujeet@code.com'),
	(2,'Navin','Kumar','navin@code.com'),
	(3,'Sarthak','Dahake','sarthak@code.com');
 
*/
