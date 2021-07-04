CREATE DATABASE `java` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
CREATE TABLE `asistente` (
  `rut` varchar(20) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `edad` int(11) NOT NULL,
  `empresa` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `region` varchar(45) NOT NULL,
  PRIMARY KEY (`rut`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


