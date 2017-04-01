-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 01-Abr-2017 às 13:56
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
  `data_emprestimos` timestamp NULL DEFAULT NULL,
  `data_devolucao` timestamp NULL DEFAULT NULL,
  `devolvido` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `emprestimos`
--

INSERT INTO `emprestimos` (`id`, `nome_aluno`, `serie_aluno`, `nome_livro`, `data_emprestimos`, `data_devolucao`, `devolvido`) VALUES
(1, 'local', NULL, NULL, NULL, NULL, NULL),
(2, 'cristiano', 'GOT', 'Item 1', '2017-03-10 03:00:00', '2017-03-17 03:00:00', NULL);

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
(1, 'Ação', 'GOT', 'MARTIM', '1', 'eu', '2017-03-30 18:35:47', 'emprestado');

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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `emprestimos`
--
ALTER TABLE `emprestimos`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `livros`
--
ALTER TABLE `livros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
