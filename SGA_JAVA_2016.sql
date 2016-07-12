/*
SQLyog Ultimate v9.02 
MySQL - 5.5.5-10.1.13-MariaDB : Database - sga_java
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sga_java` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `sga_java`;

/*Table structure for table `alu_mat` */

DROP TABLE IF EXISTS `alu_mat`;

CREATE TABLE `alu_mat` (
  `am_alu_dni` bigint(10) unsigned NOT NULL,
  `am_mat_cod` int(5) NOT NULL,
  `am_nota` int(2) DEFAULT NULL,
  PRIMARY KEY (`am_alu_dni`,`am_mat_cod`),
  KEY `FK_alu_mat` (`am_mat_cod`),
  CONSTRAINT `FK_alu_mat` FOREIGN KEY (`am_mat_cod`) REFERENCES `materia` (`mat_cod`),
  CONSTRAINT `FK_alu_mat1` FOREIGN KEY (`am_alu_dni`) REFERENCES `alumno` (`alu_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `alu_mat` */

/*Table structure for table `alumno` */

DROP TABLE IF EXISTS `alumno`;

CREATE TABLE `alumno` (
  `alu_dni` bigint(10) unsigned NOT NULL,
  `alu_nom` varchar(30) NOT NULL,
  `alu_ape` varchar(30) NOT NULL,
  `alu_dir` varchar(100) DEFAULT NULL,
  `alu_tel` varchar(50) DEFAULT NULL,
  `alu_sex` int(1) unsigned DEFAULT NULL,
  PRIMARY KEY (`alu_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `alumno` */

/*Table structure for table `materia` */

DROP TABLE IF EXISTS `materia`;

CREATE TABLE `materia` (
  `mat_cod` int(5) NOT NULL AUTO_INCREMENT,
  `mat_nom` varchar(50) NOT NULL,
  `mat_dur` int(2) unsigned DEFAULT NULL,
  `mat_prof_dni` bigint(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`mat_cod`),
  KEY `FK_materia` (`mat_prof_dni`),
  CONSTRAINT `FK_materia` FOREIGN KEY (`mat_prof_dni`) REFERENCES `profesor` (`prof__dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `materia` */

/*Table structure for table `profesor` */

DROP TABLE IF EXISTS `profesor`;

CREATE TABLE `profesor` (
  `prof__dni` bigint(10) unsigned NOT NULL,
  `prof_nom` varchar(30) NOT NULL,
  `prof_ape` varchar(30) NOT NULL,
  `prof_dir` varchar(100) DEFAULT NULL,
  `prof_tel` varchar(50) DEFAULT NULL,
  `prof_sex` int(1) DEFAULT NULL,
  `prof_tit` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`prof__dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `profesor` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
