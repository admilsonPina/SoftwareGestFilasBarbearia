-- phpMyAdmin SQL Dump
-- version 5.2.2-dev+20230625.506175861a
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 10-Jul-2023 às 17:16
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `tracabelo`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `agendamento`
--

CREATE TABLE `agendamento` (
  `id` int(11) NOT NULL,
  `cliente_id` int(11) NOT NULL,
  `data_hora` datetime NOT NULL,
  `corte_id` int(11) NOT NULL,
  `barbeiro_id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `senha` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `agendamento`
--

INSERT INTO `agendamento` (`id`, `cliente_id`, `data_hora`, `corte_id`, `barbeiro_id`, `status`, `senha`) VALUES
(1, 6, '2023-06-29 15:35:09', 11, 1, 'finalizado', 'D001'),
(2, 3, '2023-06-29 15:36:12', 7, 2, 'cancelado', 'C001'),
(3, 7, '2023-06-29 15:51:12', 9, 2, 'agendado', 'C002'),
(4, 7, '2023-06-29 16:10:09', 9, 1, 'agendado', 'D002'),
(5, 7, '2023-07-08 23:39:05', 4, 1, 'agendado', 'D001'),
(6, 7, '2023-07-09 00:06:26', 2, 1, 'agendado', 'D001'),
(7, 7, '2023-07-09 00:36:26', 3, 1, 'agendado', 'D002'),
(8, 7, '2023-07-09 00:15:20', 1, 1, 'agendado', 'D001'),
(9, 7, '2023-07-09 00:40:20', 4, 1, 'agendado', 'D002'),
(10, 7, '2023-07-09 00:15:43', 4, 2, 'agendado', 'C001'),
(11, 7, '2023-07-09 00:40:43', 4, 2, 'agendado', 'C002'),
(12, 7, '2023-07-09 01:05:20', 4, 1, 'agendado', 'D003'),
(13, 7, '2023-07-09 01:05:43', 4, 2, 'agendado', 'C003'),
(14, 7, '2023-07-09 01:30:20', 4, 1, 'agendado', 'D004'),
(15, 7, '2023-07-09 01:30:43', 4, 2, 'agendado', 'C004'),
(16, 7, '2023-07-09 01:55:20', 4, 1, 'agendado', 'D005'),
(17, 7, '2023-07-09 00:19:04', 1, 1, 'agendado', 'D001'),
(18, 7, '2023-07-09 00:44:04', 3, 1, 'agendado', 'D002'),
(19, 7, '2023-07-09 12:10:25', 6, 1, 'finalizado', 'D001'),
(20, 7, '2023-07-09 12:20:25', 6, 1, 'finalizado', 'D002'),
(21, 7, '2023-07-09 12:10:43', 6, 2, 'finalizado', 'C001'),
(22, 7, '2023-07-09 12:20:43', 5, 2, 'finalizado', 'C002'),
(23, 7, '2023-07-09 12:30:25', 7, 1, 'finalizado', 'D003'),
(24, 7, '2023-07-09 12:40:43', 4, 2, 'finalizado', 'C003'),
(25, 7, '2023-07-09 12:45:25', 6, 1, 'finalizado', 'D004'),
(26, 7, '2023-07-09 13:05:43', 10, 2, 'finalizado', 'C004'),
(27, 7, '2023-07-09 12:55:25', 6, 1, 'finalizado', 'D005'),
(28, 7, '2023-07-09 13:05:25', 7, 1, 'finalizado', 'D006'),
(29, 7, '2023-07-09 13:20:25', 8, 1, 'finalizado', 'D007'),
(30, 7, '2023-07-09 13:45:43', 6, 2, 'finalizado', 'C005'),
(31, 7, '2023-07-09 12:17:24', 6, 1, 'finalizado', 'D008'),
(32, 7, '2023-07-09 12:27:24', 6, 1, 'finalizado', 'D009'),
(33, 7, '2023-07-09 12:37:24', 6, 1, 'finalizado', 'D010'),
(34, 7, '2023-07-09 12:43:19', 2, 1, 'agendado', 'D001'),
(35, 7, '2023-07-09 13:13:19', 3, 1, 'agendado', 'D002'),
(36, 7, '2023-07-09 12:43:57', 1, 1, 'agendado', 'D001'),
(37, 7, '2023-07-09 13:08:57', 1, 1, 'agendado', 'D002'),
(38, 7, '2023-07-09 13:33:57', 1, 1, 'agendado', 'D003'),
(39, 7, '2023-07-09 13:49:46', 4, 1, 'agendado', 'D001'),
(40, 7, '2023-07-09 14:14:46', 6, 1, 'agendado', 'D002'),
(41, 7, '2023-07-09 13:50:44', 3, 1, 'finalizado', 'D001'),
(42, 7, '2023-07-09 14:10:44', 7, 1, 'finalizado', 'D002'),
(43, 7, '2023-07-09 13:50:58', 7, 2, 'finalizado', 'C001'),
(44, 7, '2023-07-09 14:05:58', 7, 2, 'finalizado', 'C002'),
(45, 7, '2023-07-09 14:20:58', 7, 2, 'finalizado', 'C003'),
(46, 7, '2023-07-09 14:25:44', 7, 1, 'finalizado', 'D003'),
(47, 7, '2023-07-09 13:57:10', 4, 1, 'finalizado', 'D001'),
(48, 7, '2023-07-09 13:57:15', 7, 2, 'finalizado', 'C001'),
(49, 7, '2023-07-09 14:22:10', 4, 1, 'finalizado', 'D002'),
(50, 7, '2023-07-09 14:12:15', 6, 2, 'finalizado', 'C002'),
(51, 7, '2023-07-09 14:22:15', 7, 2, 'finalizado', 'C003');

-- --------------------------------------------------------

--
-- Estrutura da tabela `barbeiro`
--

CREATE TABLE `barbeiro` (
  `id` int(11) NOT NULL,
  `especialidade` varchar(100) NOT NULL,
  `MoradaBarber` varchar(150) NOT NULL,
  `CNIBarber` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `barbeiro`
--

INSERT INTO `barbeiro` (`id`, `especialidade`, `MoradaBarber`, `CNIBarber`) VALUES
(1, 'Corte Crianca', '', ''),
(2, 'Corte Masculino', '', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `tipoCliente` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `tipoCliente`) VALUES
(3, ''),
(4, ''),
(5, ''),
(6, ''),
(7, '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cortes`
--

CREATE TABLE `cortes` (
  `id` int(11) NOT NULL,
  `tipocorte` varchar(50) NOT NULL,
  `duracao` int(11) NOT NULL,
  `custo` decimal(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cortes`
--

INSERT INTO `cortes` (`id`, `tipocorte`, `duracao`, `custo`) VALUES
(1, 'Careca Maquina', 25, 150.00),
(2, 'Careca Lamina', 30, 200.00),
(3, 'Careca crianca', 20, 100.00),
(4, 'Escovinha', 25, 200.00),
(5, 'Escovinha crianca', 20, 150.00),
(6, 'Pe di cabelo', 10, 100.00),
(7, 'Lado', 15, 100.00),
(8, 'Pank crianca', 20, 150.00),
(9, 'Pank Adulto', 20, 200.00),
(10, 'Careca Lamina + Barba', 40, 300.00),
(11, 'Careca Maquina + Barba', 35, 250.00),
(12, 'Outros cortes + Barba', 35, 250.00),
(13, 'Barba', 15, 100.00);

-- --------------------------------------------------------

--
-- Estrutura da tabela `sistema`
--

CREATE TABLE `sistema` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `sistema`
--

INSERT INTO `sistema` (`id`, `username`, `password`) VALUES
(1, 'admin', 'password');

-- --------------------------------------------------------

--
-- Estrutura da tabela `utilizadores`
--

CREATE TABLE `utilizadores` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `tipoUtilizador` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `utilizadores`
--

INSERT INTO `utilizadores` (`id`, `nome`, `telefone`, `tipoUtilizador`) VALUES
(1, 'Dany', '9743647', 'barbeiro'),
(2, 'Carlos', '9735367', 'barbeiro'),
(3, 'Admilson', '5229491', 'cliente'),
(4, 'Kevin', '5978254', 'cliente'),
(5, 'Madu', '9743790', 'cliente'),
(6, 'Valerio', '', 'cliente'),
(7, '', '', 'cliente');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `agendamento`
--
ALTER TABLE `agendamento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cliente_id` (`cliente_id`),
  ADD KEY `corte_id` (`corte_id`),
  ADD KEY `barbeiro_id` (`barbeiro_id`);

--
-- Índices para tabela `barbeiro`
--
ALTER TABLE `barbeiro`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `cortes`
--
ALTER TABLE `cortes`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `sistema`
--
ALTER TABLE `sistema`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `utilizadores`
--
ALTER TABLE `utilizadores`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `agendamento`
--
ALTER TABLE `agendamento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT de tabela `cortes`
--
ALTER TABLE `cortes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de tabela `utilizadores`
--
ALTER TABLE `utilizadores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `agendamento`
--
ALTER TABLE `agendamento`
  ADD CONSTRAINT `agendamento_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `agendamento_ibfk_2` FOREIGN KEY (`corte_id`) REFERENCES `cortes` (`id`),
  ADD CONSTRAINT `agendamento_ibfk_3` FOREIGN KEY (`barbeiro_id`) REFERENCES `barbeiro` (`id`);

--
-- Limitadores para a tabela `barbeiro`
--
ALTER TABLE `barbeiro`
  ADD CONSTRAINT `barbeiro_ibfk_1` FOREIGN KEY (`id`) REFERENCES `utilizadores` (`id`);

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id`) REFERENCES `utilizadores` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
