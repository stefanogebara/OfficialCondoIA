CREATE DATABASE  IF NOT EXISTS `Condo3` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `Condo3`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: dbmysql-condo.mysql.database.azure.com    Database: condodb
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `apartments`
--

DROP TABLE IF EXISTS `apartments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apartments` (
  `ApartmentId` int NOT NULL AUTO_INCREMENT,
  `Number` varchar(5) NOT NULL,
  `CondoId` int DEFAULT NULL,
  `Floor` int DEFAULT NULL,
  `Block` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ApartmentId`),
  KEY `CondoId` (`CondoId`),
  CONSTRAINT `apartments_ibfk_1` FOREIGN KEY (`CondoId`) REFERENCES `condominium` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apartments`
--

LOCK TABLES `apartments` WRITE;
/*!40000 ALTER TABLE `apartments` DISABLE KEYS */;
INSERT INTO `apartments` VALUES (2,'112',6,1,'A'),(4,'114',6,2,'A'),(5,'1',10,1,'A'),(6,'2',10,1,'B'),(7,'10',11,1,'A'),(8,'11',11,1,'A'),(9,'12',11,1,'A'),(10,'13',11,1,'A');
/*!40000 ALTER TABLE `apartments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chathasmessages`
--

DROP TABLE IF EXISTS `chathasmessages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chathasmessages` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ChatID` int DEFAULT NULL,
  `MessageDate` datetime DEFAULT NULL,
  `UserName` varchar(200) DEFAULT NULL,
  `Message` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chathasmessages`
--

LOCK TABLES `chathasmessages` WRITE;
/*!40000 ALTER TABLE `chathasmessages` DISABLE KEYS */;
/*!40000 ALTER TABLE `chathasmessages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `condohasadmin`
--

DROP TABLE IF EXISTS `condohasadmin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `condohasadmin` (
  `IdCondoId` int NOT NULL,
  `IdAdminId` int NOT NULL,
  PRIMARY KEY (`IdCondoId`,`IdAdminId`),
  KEY `IdAdminId` (`IdAdminId`),
  CONSTRAINT `condohasadmin_ibfk_1` FOREIGN KEY (`IdCondoId`) REFERENCES `condominium` (`ID`),
  CONSTRAINT `condohasadmin_ibfk_2` FOREIGN KEY (`IdAdminId`) REFERENCES `manager` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `condohasadmin`
--

LOCK TABLES `condohasadmin` WRITE;
/*!40000 ALTER TABLE `condohasadmin` DISABLE KEYS */;
INSERT INTO `condohasadmin` VALUES (8,12),(6,13),(10,14),(11,15);
/*!40000 ALTER TABLE `condohasadmin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `condominium`
--

DROP TABLE IF EXISTS `condominium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `condominium` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `condominium`
--

LOCK TABLES `condominium` WRITE;
/*!40000 ALTER TABLE `condominium` DISABLE KEYS */;
INSERT INTO `condominium` VALUES (6,'Residencial 2'),(8,'Teste'),(10,'Teste 2'),(11,'MarcusTestCondo');
/*!40000 ALTER TABLE `condominium` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ideas`
--

DROP TABLE IF EXISTS `ideas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ideas` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Description` text,
  `IsStructural` tinyint(1) DEFAULT NULL,
  `Budget` float DEFAULT NULL,
  `ResidentID` int DEFAULT NULL,
  `Type` enum('Idea','Suggestion') DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ResidentID` (`ResidentID`),
  CONSTRAINT `ideas_ibfk_1` FOREIGN KEY (`ResidentID`) REFERENCES `resident` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ideas`
--

LOCK TABLES `ideas` WRITE;
/*!40000 ALTER TABLE `ideas` DISABLE KEYS */;
INSERT INTO `ideas` VALUES (4,'PINGPONG TABLE ',0,1500,1,'Idea'),(5,'CREATE A NEW POOL',1,1500,1,'Idea'),(7,'CREATE NEW ARCADE',0,100,11,'Idea'),(8,'New Arcarde',0,1000,15,'Idea'),(10,'New hot pool ',1,100000,15,'Idea');
/*!40000 ALTER TABLE `ideas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ideashasvotes`
--

DROP TABLE IF EXISTS `ideashasvotes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ideashasvotes` (
  `IdeaID` int NOT NULL,
  `ResidentID` int NOT NULL,
  PRIMARY KEY (`IdeaID`,`ResidentID`),
  KEY `ResidentID` (`ResidentID`),
  CONSTRAINT `ideashasvotes_ibfk_1` FOREIGN KEY (`IdeaID`) REFERENCES `ideas` (`ID`),
  CONSTRAINT `ideashasvotes_ibfk_2` FOREIGN KEY (`ResidentID`) REFERENCES `resident` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ideashasvotes`
--

LOCK TABLES `ideashasvotes` WRITE;
/*!40000 ALTER TABLE `ideashasvotes` DISABLE KEYS */;
INSERT INTO `ideashasvotes` VALUES (4,1),(5,1),(4,15),(5,15),(10,15);
/*!40000 ALTER TABLE `ideashasvotes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manager` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `loginAdmin` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `IsEnable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,'user1','teste',1),(8,'Jopitcho','123456',1),(9,'Jopitcho','123456',1),(10,'Jopitchon','123456',1),(11,'Jopitchon','123456',1),(12,'Jopitcho','123456',1),(13,'Manager','123456',1),(14,'Henrique','123456',1),(15,'marcus','1234',1);
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resident`
--

DROP TABLE IF EXISTS `resident`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resident` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Pass` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resident`
--

LOCK TABLES `resident` WRITE;
/*!40000 ALTER TABLE `resident` DISABLE KEYS */;
INSERT INTO `resident` VALUES (1,'Stefano','Stefano','email@teste.com','teste'),(2,'Jopitchon','RMI','teste@gmail.com','123456'),(3,'Jopitcho','Jopintchon','teste@gmail.com','123456'),(4,'Jopitcho','Jopitcho','teste@gmail.com','123456'),(5,'Jopintchon','Jopitchon','teste@gmail.com','123456'),(6,'John','Travolta','teste@hotmail.com','123456'),(7,'John','Travolts','teste@hotmail.com','123456'),(8,'John','Travolts','teste@hotmail.com','123456'),(9,'John','Travolts','teste@hotmail.com','123456'),(10,'John','Travolts','teste@hotmail.com','123456'),(11,'Ideia','Boa','ideia@boa.com','123456'),(12,'Ideia','Boa','ideia@boa.com','123456'),(13,'Morador','Condo Teste 2','morador@teste.com','123456'),(14,'Morador','Condo Teste 2','morador@teste.com','123456'),(15,'Henrique 1','Souza 1','henrique@condo.com','123456'),(16,'Henrique','Souza','henrique@condo.com','123456');
/*!40000 ALTER TABLE `resident` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `residenthasapartments`
--

DROP TABLE IF EXISTS `residenthasapartments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `residenthasapartments` (
  `ResidentID` int NOT NULL,
  `ApartmentId` int NOT NULL,
  PRIMARY KEY (`ResidentID`,`ApartmentId`),
  KEY `ApartmentId` (`ApartmentId`),
  CONSTRAINT `residenthasapartments_ibfk_1` FOREIGN KEY (`ResidentID`) REFERENCES `resident` (`ID`),
  CONSTRAINT `residenthasapartments_ibfk_2` FOREIGN KEY (`ApartmentId`) REFERENCES `apartments` (`ApartmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residenthasapartments`
--

LOCK TABLES `residenthasapartments` WRITE;
/*!40000 ALTER TABLE `residenthasapartments` DISABLE KEYS */;
INSERT INTO `residenthasapartments` VALUES (1,2),(2,2),(9,4),(11,5),(13,6),(15,10);
/*!40000 ALTER TABLE `residenthasapartments` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-29 18:35:28
