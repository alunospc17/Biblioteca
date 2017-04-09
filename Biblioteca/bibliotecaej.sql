-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 09-Abr-2017 às 20:21
-- Versão do servidor: 5.7.11
-- PHP Version: 7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bibliotecaej`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `emprestimos`
--

CREATE TABLE `emprestimos` (
  `id` int(6) NOT NULL,
  `nome_aluno` varchar(45) NOT NULL,
  `serie_aluno` varchar(45) DEFAULT NULL,
  `nome_livro` varchar(45) DEFAULT NULL,
  `data_emprestimo` timestamp NULL DEFAULT NULL,
  `data_devolucao` timestamp NULL DEFAULT NULL,
  `devolvido` varchar(3) DEFAULT NULL,
  `id_livro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `emprestimos`
--

INSERT INTO `emprestimos` (`id`, `nome_aluno`, `serie_aluno`, `nome_livro`, `data_emprestimo`, `data_devolucao`, `devolvido`, `id_livro`) VALUES
(1, 'local', '22', 'oi', '2017-04-01 03:00:00', '2017-04-08 03:00:00', 'sim', 0),
(2, 'cristiano', 'GOT', 'Item 1', '2017-03-06 03:00:00', '2017-03-17 03:00:00', 'sim', 0),
(3, 'Cristiano', 'Angry Birds', 'Item 4', '2017-03-01 03:00:00', '2017-03-10 03:00:00', 'sim', 0),
(4, 'Joao', 'Sansung', '7°ano', '2017-03-03 03:00:00', '2017-03-18 03:00:00', 'sim', 0),
(5, 'ze', 'Sansung', '6°ano', '2017-04-03 00:11:49', '2017-04-10 00:11:49', 'sim', 0),
(6, 'Eu', 'Como Programar', '7°ano', '2017-04-09 19:58:00', '2017-04-16 19:58:00', 'sim', 0),
(7, 'Fulano', 'Angry Pardals', '6°ano', '2017-04-09 20:04:19', '2017-04-16 20:04:19', 'sim', 0),
(8, 'Zeee', 'Angry Pardals', '8°ano', '2017-04-09 20:06:32', '2017-04-16 20:06:32', 'sim', 0),
(9, 'Zeee', 'Angry Pardals', '8°ano', '2017-04-09 20:08:41', '2017-04-16 20:08:41', 'sim', 0),
(10, 'Zeee', 'Hardware', '9°ano', '2017-04-09 20:17:11', '2017-04-16 20:17:11', 'sim', 12),
(11, 'Zeee', 'Game of Thrones', '7°ano', '2017-04-09 20:20:11', '2017-04-16 20:20:11', 'sim', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `livros`
--

CREATE TABLE `livros` (
  `id` int(11) NOT NULL,
  `genero` varchar(45) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `autor` varchar(45) NOT NULL,
  `prateleira` varchar(45) NOT NULL,
  `bibliotecario` varchar(45) NOT NULL,
  `data` timestamp NOT NULL,
  `situacao` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `livros`
--

INSERT INTO `livros` (`id`, `genero`, `titulo`, `autor`, `prateleira`, `bibliotecario`, `data`, `situacao`) VALUES
(1, 'Ação', 'Game of Thrones', 'MARTIM', '2', 'eu', '2017-03-30 18:35:47', 'livre'),
(2, 'Ação', 'Angry Pardals', 'Rovio', '4', 'eu', '2017-03-17 03:00:00', 'livre'),
(3, 'Ação', 'Angry Birds', 'Rovio', '3', 'eu', '2017-03-17 03:00:00', 'livre'),
(4, 'Ação', 'Angry Birds', 'Rovio', '3', 'eu', '2017-03-17 03:00:00', 'livre'),
(5, 'Ação', 'Angry Birds', 'Rovio', '3', 'eu', '2017-03-17 03:00:00', 'livre'),
(6, 'Ação', 'Angry Birds', 'Rovio', '3', 'eu', '2017-03-17 03:00:00', 'livre'),
(7, 'tv', 'Sansung', 'smith', '5', 'crgd', '2017-03-17 03:00:00', 'livre'),
(8, 'tv', 'Sansung', 'smith', '4', 'crgd', '2017-03-17 03:00:00', 'livre'),
(9, 'informatica', 'Como Programar', 'Java', '4', 'crgd', '2017-03-17 03:00:00', 'livre'),
(10, 'informatica', 'Como Programar', 'Java', '4', 'crgd', '2017-03-17 03:00:00', 'livre'),
(11, 'informatica', 'Como Programar', 'Java', '4', 'crgd', '2017-03-17 03:00:00', 'livre'),
(12, 'info', 'Hardware', 'James', '3', 'crgd', '2017-03-17 03:00:00', 'livre'),
(13, 'info', 'Hardware', 'James', '3', 'crgd', '2017-03-17 03:00:00', 'livre'),
(14, 'info', 'Hardware', 'James', '3', 'crgd', '2017-03-17 03:00:00', 'livre'),
(15, 'info', 'Hardware', 'James', '3', 'crgd', '2017-03-17 03:00:00', 'livre'),
(16, 'acao', 'Joao e Maria', 'Grim', '2', 'crgd', '2017-03-17 03:00:00', 'livre'),
(17, 'acao', 'Joao e Maria', 'Grim', '2', 'crgd', '2017-03-17 03:00:00', 'livre'),
(18, 'acao', 'Joao e Maria', 'Grim', '2', 'crgd', '2017-03-17 03:00:00', 'livre');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(6) UNSIGNED NOT NULL,
  `login` varchar(30) NOT NULL,
  `senha` varchar(30) NOT NULL,
  `tipo` varchar(3) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `login`, `senha`, `tipo`) VALUES
(1, 'crgd', '123', 'usr');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `emprestimos`
--
ALTER TABLE `emprestimos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `livros`
--
ALTER TABLE `livros`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `emprestimos`
--
ALTER TABLE `emprestimos`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `livros`
--
ALTER TABLE `livros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
