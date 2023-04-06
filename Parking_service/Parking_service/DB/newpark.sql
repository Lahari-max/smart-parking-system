/*
SQLyog - Free MySQL GUI v5.13
Host - 5.0.22-community-nt : Database - newpark
*********************************************************************
Server version : 5.0.22-community-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `newpark`;

USE `newpark`;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `bankdetails` */

DROP TABLE IF EXISTS `bankdetails`;

CREATE TABLE `bankdetails` (
  `name` varchar(20) default NULL,
  `accountno` varchar(200) default NULL,
  `cvv` varchar(200) default NULL,
  `expirydate` varchar(200) default NULL,
  `password` varchar(200) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `bankdetails` */

insert into `bankdetails` (`name`,`accountno`,`cvv`,`expirydate`,`password`) values ('sri','1234567890','999','12/2024','asdf');

/*Table structure for table `slots` */

DROP TABLE IF EXISTS `slots`;

CREATE TABLE `slots` (
  `Place` varchar(200) default NULL,
  `slots` varchar(200) default NULL,
  `price` varchar(200) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `slots` */

insert into `slots` (`Place`,`slots`,`price`) values ('tnagar','5','20.00');
insert into `slots` (`Place`,`slots`,`price`) values ('gundiy','5','20.00');
insert into `slots` (`Place`,`slots`,`price`) values ('pilar','5','20.00');
insert into `slots` (`Place`,`slots`,`price`) values ('porur','5','20.00');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(30) default NULL,
  `password` varchar(30) default NULL,
  `mail` varchar(30) default NULL,
  `mobile` varchar(30) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert into `user` (`username`,`password`,`mail`,`mobile`) values ('sri','asdf',NULL,'9884113466');

SET SQL_MODE=@OLD_SQL_MODE;