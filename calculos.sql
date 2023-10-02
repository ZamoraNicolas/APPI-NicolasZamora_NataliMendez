-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-10-2023 a las 07:37:41
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `operaciones`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calculos`
--

CREATE TABLE `calculos` (
  `ID` varchar(10) NOT NULL,
  `Raiz_2` varchar(10) NOT NULL,
  `Raiz_3` varchar(10) NOT NULL,
  `Potencia_2` varchar(10) NOT NULL,
  `Potencia_3` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `calculos`
--

INSERT INTO `calculos` (`ID`, `Raiz_2`, `Raiz_3`, `Potencia_2`, `Potencia_3`) VALUES
('1', ' 1.4142', ' 1.2599', '1', '1'),
('10', '3.162', '2.154', '100', '1000'),
('2', '1.414', '1.259', '4', '8'),
('3', '1.732', '1.442', '9', '27'),
('4', '2', '1.587', '16', '64'),
('5', '2.236', '1.710', ' 25', '125'),
('6', ' 2.449', '1.817', '36', '216'),
('7', ' 2.646', '1.913', '49', '343'),
('8', ' 2.828', '2', '64', '512'),
('9', '3', '2.080', ' 81', '729');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `calculos`
--
ALTER TABLE `calculos`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
