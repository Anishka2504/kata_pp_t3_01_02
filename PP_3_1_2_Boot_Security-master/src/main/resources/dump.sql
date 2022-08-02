SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP DATABASE IF EXISTS `task312`;
CREATE DATABASE `task312`;
USE `task312`;

CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO `role` (`id`, `name`) VALUES
(1,	'ROLE_ADMIN'),
(2,	'ROLE_USER');

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `middle_name` varchar(255) NOT NULL,
  `login` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password_hash` varchar(1000) NOT NULL,
  `non_expired` bit(1) NOT NULL DEFAULT b'0',
  `non_locked` bit(1) NOT NULL DEFAULT b'0',
  `credentials_non_expired` bit(1) NOT NULL DEFAULT b'0',
  `enabled` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO `user` (`id`, `name`, `last_name`, `middle_name`, `login`, `password_hash`, `non_expired`, `non_locked`, `credentials_non_expired`, `enabled`) VALUES
(1,	'admin',	'adminln',	'adminmd',	'admin@localhost',	'$2a$10$qk3x2MdLGQhGZnn8nkP3Z.hSB42ZKK5RTTXXaVgR0BtEmqtvYYhgi',	CONV('1', 2, 10) + 0,	CONV('1', 2, 10) + 0,	CONV('1', 2, 10) + 0,	CONV('1', 2, 10) + 0),
(2,	'user',	'userln',	'usermd',	'user@localhost',	'$2a$10$yslPzDN6rzoOcO7uZO0xluk.M6nci/7AEvlB.MvXKFJHOxD./CMXm',	CONV('1', 2, 10) + 0,	CONV('1', 2, 10) + 0,	CONV('1', 2, 10) + 0,	CONV('1', 2, 10) + 0);

CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1,	1),
(1,	2),
(2,	2);