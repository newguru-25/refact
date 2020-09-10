-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-09-2020 a las 13:42:11
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `test`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `log`
--

CREATE TABLE `log` (
  `ID` int(10) NOT NULL,
  `DESC_LOG` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `log`
--

INSERT INTO `log` (`ID`, `DESC_LOG`) VALUES
(6, 'warning 5 de septiembre de 2020mi mensaje'),
(7, 'warning 5 de septiembre de 2020mi mensajemessage 5 de septiembre de 2020mi mensaje'),
(8, 'error 5 de septiembre de 2020mi mensaje'),
(9, 'error 5 de septiembre de 2020mi mensajewarning 5 de septiembre de 2020mi mensaje'),
(10, 'error 5 de septiembre de 2020mi mensajewarning 5 de septiembre de 2020mi mensajemessage 5 de septiembre de 2020mi mensaje'),
(11, 'error 5 de septiembre de 2020mi mensaje'),
(12, 'error 5 de septiembre de 2020mi mensajewarning 5 de septiembre de 2020mi mensaje'),
(13, 'error 5 de septiembre de 2020mi mensajewarning 5 de septiembre de 2020mi mensajemessage 5 de septiembre de 2020mi mensaje'),
(14, 'error 5 de septiembre de 2020mi mensaje'),
(15, 'error 5 de septiembre de 2020mi mensajewarning 5 de septiembre de 2020mi mensaje'),
(16, 'error 5 de septiembre de 2020mi mensajewarning 5 de septiembre de 2020mi mensajemessage 5 de septiembre de 2020mi mensaje'),
(17, 'error 5 de septiembre de 2020mi mensaje'),
(18, 'error 5 de septiembre de 2020mi mensajewarning 5 de septiembre de 2020mi mensaje'),
(19, 'error 5 de septiembre de 2020mi mensajewarning 5 de septiembre de 2020mi mensajemessage 5 de septiembre de 2020mi mensaje'),
(20, 'message 5 de septiembre de 2020mi mensaje'),
(21, 'error 5 de septiembre de 2020mi mensaje'),
(22, 'error 5 de septiembre de 2020mi mensajewarning 5 de septiembre de 2020mi mensaje'),
(23, 'error 5 de septiembre de 2020mi mensajewarning 5 de septiembre de 2020mi mensajemessage 5 de septiembre de 2020mi mensaje'),
(24, 'error 5 de septiembre de 2020mi mensaje'),
(25, 'error 5 de septiembre de 2020mi mensajewarning 5 de septiembre de 2020mi mensaje'),
(26, 'error 5 de septiembre de 2020mi mensajewarning 5 de septiembre de 2020mi mensajemessage 5 de septiembre de 2020mi mensaje'),
(27, 'error 5 de septiembre de 2020mi mensaje'),
(28, 'error 5 de septiembre de 2020mi mensajewarning 5 de septiembre de 2020mi mensaje'),
(29, 'error 5 de septiembre de 2020mi mensajewarning 5 de septiembre de 2020mi mensajemessage 5 de septiembre de 2020mi mensaje'),
(30, 'error 5 de septiembre de 2020mi mensaje'),
(31, 'error 5 de septiembre de 2020mi mensajewarning 5 de septiembre de 2020mi mensaje'),
(32, 'error 5 de septiembre de 2020mi mensajewarning 5 de septiembre de 2020mi mensajemessage 5 de septiembre de 2020mi mensaje'),
(33, 'MESSAGE5 de septiembre de 2020mi mensaje'),
(34, 'MESSAGE5 de septiembre de 2020mi mensajeWANING5 de septiembre de 2020mi mensaje'),
(35, 'MESSAGE5 de septiembre de 2020mi mensajeWANING5 de septiembre de 2020mi mensajeERROR5 de septiembre de 2020mi mensaje'),
(36, 'MESSAGE5 de septiembre de 2020mi mensaje'),
(37, 'MESSAGE5 de septiembre de 2020mi mensajeWANING5 de septiembre de 2020mi mensaje'),
(38, 'MESSAGE5 de septiembre de 2020mi mensajeWANING5 de septiembre de 2020mi mensajeERROR5 de septiembre de 2020mi mensaje'),
(39, 'MESSAGE5 de septiembre de 2020mi mensaje'),
(40, 'MESSAGE5 de septiembre de 2020mi mensajeWANING5 de septiembre de 2020mi mensaje'),
(41, 'MESSAGE5 de septiembre de 2020mi mensajeWANING5 de septiembre de 2020mi mensajeERROR5 de septiembre de 2020mi mensaje'),
(42, 'ERROR5 de septiembre de 2020mi mensaje'),
(43, 'ERROR5 de septiembre de 2020mi mensajeWANING5 de septiembre de 2020mi mensaje'),
(44, 'ERROR5 de septiembre de 2020mi mensaje'),
(45, 'ERROR5 de septiembre de 2020mi mensajeWANING5 de septiembre de 2020mi mensaje'),
(46, 'ERROR5 de septiembre de 2020mi mensaje'),
(47, 'ERROR5 de septiembre de 2020mi mensajeWANING5 de septiembre de 2020mi mensaje'),
(48, 'ERROR5 de septiembre de 2020mi mensaje'),
(49, 'ERROR5 de septiembre de 2020mi mensajeWANING5 de septiembre de 2020mi mensaje'),
(50, 'MESSAGE5 de septiembre de 2020mi mensaje'),
(51, 'MESSAGE5 de septiembre de 2020mi mensajeWANING5 de septiembre de 2020mi mensaje'),
(52, 'MESSAGE5 de septiembre de 2020mi mensajeWANING5 de septiembre de 2020mi mensajeERROR5 de septiembre de 2020mi mensaje'),
(53, 'MESSAGE5 de septiembre de 2020mi mensaje'),
(54, 'MESSAGE5 de septiembre de 2020mi mensajeWANING5 de septiembre de 2020mi mensaje'),
(55, 'MESSAGE5 de septiembre de 2020mi mensaje'),
(56, 'MESSAGE5 de septiembre de 2020mi mensajeERROR5 de septiembre de 2020mi mensaje'),
(57, 'ERROR5 de septiembre de 2020mi mensaje'),
(58, 'ERROR5 de septiembre de 2020mi mensaje'),
(59, 'ERROR5 de septiembre de 2020mi mensajeWANING5 de septiembre de 2020mi mensaje'),
(60, 'ERROR9 de septiembre de 2020mi mensaje'),
(61, 'ERROR9 de septiembre de 2020mi mensajeWANING9 de septiembre de 2020mi mensaje'),
(62, 'MESSAGE9 de septiembre de 2020mi mensaje'),
(63, 'MESSAGE9 de septiembre de 2020mi mensajeWANING9 de septiembre de 2020mi mensaje'),
(64, 'MESSAGE9 de septiembre de 2020mi mensajeWANING9 de septiembre de 2020mi mensajeERROR9 de septiembre de 2020mi mensaje'),
(65, 'ERROR9 de septiembre de 2020mi mensaje'),
(66, 'ERROR9 de septiembre de 2020mi mensajeWANING9 de septiembre de 2020mi mensaje'),
(67, 'ERROR9 de septiembre de 2020mi mensaje'),
(68, 'ERROR9 de septiembre de 2020mi mensajeWANING9 de septiembre de 2020mi mensaje'),
(69, 'ERROR9 de septiembre de 2020mi mensaje'),
(70, 'ERROR9 de septiembre de 2020mi mensaje'),
(71, 'ERROR9 de septiembre de 2020mi mensaje'),
(72, 'MESSAGE9 de septiembre de 2020mi mensaje'),
(73, 'MESSAGE9 de septiembre de 2020mi mensajeWANING9 de septiembre de 2020mi mensaje'),
(74, 'MESSAGE9 de septiembre de 2020mi mensajeWANING9 de septiembre de 2020mi mensajeERROR9 de septiembre de 2020mi mensaje'),
(75, 'MESSAGE9 de septiembre de 2020mi mensaje'),
(76, 'MESSAGE9 de septiembre de 2020mi mensajeWANING9 de septiembre de 2020mi mensaje'),
(77, 'MESSAGE9 de septiembre de 2020mi mensajeWANING9 de septiembre de 2020mi mensajeERROR9 de septiembre de 2020mi mensaje'),
(78, 'MESSAGE10 de setiembre de 2020mi mensaje'),
(79, 'MESSAGE10 de setiembre de 2020mi mensajeWANING10 de setiembre de 2020mi mensaje'),
(80, 'MESSAGE10 de setiembre de 2020mi mensajeWANING10 de setiembre de 2020mi mensajeERROR10 de setiembre de 2020mi mensaje'),
(81, 'MESSAGE10 de setiembre de 2020mi mensaje'),
(82, 'MESSAGE10 de setiembre de 2020mi mensajeWANING10 de setiembre de 2020mi mensaje'),
(83, 'MESSAGE10 de setiembre de 2020mi mensajeWANING10 de setiembre de 2020mi mensajeERROR10 de setiembre de 2020mi mensaje');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `log`
--
ALTER TABLE `log`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
