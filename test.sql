DROP database IF EXISTS test;
CREATE database test;
USE test;

SET NAMES utf8mb4;

CREATE TABLE `computercomponent` (`id` int(11) NOT NULL AUTO_INCREMENT, `name` varchar(255) DEFAULT NULL, `necessary` tinyint(1) DEFAULT NULL, `number_component` int(11) DEFAULT NULL, PRIMARY KEY (`id`));

INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('Материнская плата', 1, 7);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('PCI Wifi адаптер', 0, 20);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('Блок питания', 1, 8);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('Подсветка корпуса', 0, 10);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('Жесткий диск', 0, 43);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('Корпус', 1, 200);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('Кулер процессора', 1, 32);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('Оптический привод', 0, 5);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('Видеокарта', 0, 9);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('Оперативная память', 1, 356);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('Кулер системы охлаждения корпуса', 0, 75);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('SSD диск', 1, 99);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('Процессор', 1, 487);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('PCI Bluetooth адаптер', 0, 15);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('Звуковая карта', 0, 6);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('Термопаста', 1, 745);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('Сетевая карта', 0, 11);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('Клавиатура', 1, 520);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('Мышь', 1, 369);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('ТВ-тюнер', 0, 0);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('Веб-камера', 0, 10);
INSERT INTO `computercomponent` (name, necessary, number_component) VALUES ('Акустическая система', 0, 42);
