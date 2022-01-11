-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 04-Dez-2019 às 03:51
-- Versão do servidor: 10.3.15-MariaDB
-- versão do PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `obrajava`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `licitacoes`
--

CREATE TABLE `licitacoes` (
  `idlicitacoes` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idObra` int(11) NOT NULL,
  `QuantidadeMeses` int(11) DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `licitacoes`
--

INSERT INTO `licitacoes` (`idlicitacoes`, `idUsuario`, `idObra`, `QuantidadeMeses`, `descricao`, `status`) VALUES
(8, 6, 3, 2, 'Pintura do Colegio', NULL),
(9, 7, 3, 2, 'Pintura do Colegio', 'Finalizado'),
(10, 6, 1, 5, 'Construir 1 leito por mês .', 'Em andamento'),
(11, 7, 1, 1, 'Construir os 5 leitos', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `obra`
--

CREATE TABLE `obra` (
  `idobra` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `prazo` date DEFAULT NULL,
  `prioridade` varchar(45) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `tipoObra` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `obra`
--

INSERT INTO `obra` (`idobra`, `idUsuario`, `prazo`, `prioridade`, `valor`, `descricao`, `status`, `tipoObra`) VALUES
(1, 5, '2019-12-27', 'Media', 0, 'Construir 5 leitos no Hospital 9 de Julho', 'Em andamento', 'Hospitalar'),
(2, 5, '2019-12-28', 'Baixa', 0, 'Criação de campo de futebol na escola Jorge J', 'Em aberto', 'Escolar'),
(3, 5, '2019-12-12', 'Baixa', 0, 'Pintar Colegio Jorge J', 'Finalizado', 'Escolar'),
(4, 5, '2019-12-02', 'Baixa', 0, 'Pintar Hospital Magalhaes', 'Em aberto', 'Hospitalar'),
(6, 5, '2019-12-31', 'Baixa', 0, 'Asfaltamento da Rua três de julho no Bairro Benfica.', 'Em aberto', 'Rodoviaria'),
(7, 5, '2020-04-30', 'Media', 0, 'Manutenção da Ponte Aguiar, reforçar estrutura metálicas.', 'Em aberto', 'Pontes');

-- --------------------------------------------------------

--
-- Estrutura da tabela `resumolicitacao`
--

CREATE TABLE `resumolicitacao` (
  `idresumoLicitacao` int(11) NOT NULL,
  `idLicitacao` int(11) NOT NULL,
  `mes` int(11) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `unidade` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `resumolicitacao`
--

INSERT INTO `resumolicitacao` (`idresumoLicitacao`, `idLicitacao`, `mes`, `valor`, `descricao`, `unidade`, `status`) VALUES
(6, 8, 1, 2000, 'Limpeza da Parede para efetuar as pinturas', '1', NULL),
(7, 8, 2, 3000, 'Pintura do Colegio', '20', NULL),
(8, 9, 1, 1800, 'Limpeza do Local', '2', 'Finalizado'),
(9, 9, 2, 1900, 'Pintura do Local', '20', 'Finalizado'),
(10, 10, 1, 1000, 'Construir o Primeiro Leito', '1', 'Finalizado'),
(11, 10, 2, 1000, 'Construir o Segundo Leito', '1', 'Finalizado'),
(12, 10, 3, 1000, 'Construir o Terceiro Leito', '1', 'Em andamento'),
(13, 10, 4, 1000, 'Construir o Quarto Leito', '1', 'Em andamento'),
(14, 10, 5, 1000, 'Construir Quinto Leito', '1', 'Em andamento'),
(15, 11, 1, 7000, 'Construir os 5 leitos', '5', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `tipoUsuario` varchar(45) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `cpf_cnpj` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `tipoUsuario`, `nome`, `email`, `telefone`, `cpf_cnpj`, `senha`) VALUES
(4, 'Secretario', 'Wellikiandre', 'Wellikiandre@oi', '3232397158', '3333', '3333'),
(5, 'Funcionario', 'Carlos', 'Wellikiandre@oi', '323423123', '0000', '0000'),
(6, 'Construtora', 'Empreteira1 ', 'emp@1', '32097651', '1111', '1111'),
(7, 'Construtora', 'Empreteira2', 'wmep@3', '23141312', '2222', '2222');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `licitacoes`
--
ALTER TABLE `licitacoes`
  ADD PRIMARY KEY (`idlicitacoes`),
  ADD KEY `hf87` (`idUsuario`),
  ADD KEY `jhgg5678` (`idObra`);

--
-- Índices para tabela `obra`
--
ALTER TABLE `obra`
  ADD PRIMARY KEY (`idobra`),
  ADD KEY `jhg898` (`idUsuario`);

--
-- Índices para tabela `resumolicitacao`
--
ALTER TABLE `resumolicitacao`
  ADD PRIMARY KEY (`idresumoLicitacao`),
  ADD KEY `jh9000` (`idLicitacao`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `licitacoes`
--
ALTER TABLE `licitacoes`
  MODIFY `idlicitacoes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `obra`
--
ALTER TABLE `obra`
  MODIFY `idobra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `resumolicitacao`
--
ALTER TABLE `resumolicitacao`
  MODIFY `idresumoLicitacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `licitacoes`
--
ALTER TABLE `licitacoes`
  ADD CONSTRAINT `hf87` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `jhgg5678` FOREIGN KEY (`idObra`) REFERENCES `obra` (`idobra`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `obra`
--
ALTER TABLE `obra`
  ADD CONSTRAINT `jhg898` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `resumolicitacao`
--
ALTER TABLE `resumolicitacao`
  ADD CONSTRAINT `jh9000` FOREIGN KEY (`idLicitacao`) REFERENCES `licitacoes` (`idlicitacoes`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
