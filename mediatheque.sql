-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 04 juin 2021 à 00:17
-- Version du serveur :  10.4.13-MariaDB
-- Version de PHP : 7.4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `mediatheque`
--

-- --------------------------------------------------------

--
-- Structure de la table `auteur`
--

CREATE TABLE `auteur` (
  `idAuteur` int(10) NOT NULL,
  `idDoc` int(11) DEFAULT NULL,
  `Nom` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idClient` int(11) NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `Prenom` varchar(45) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `TypeClient` varchar(20) DEFAULT NULL,
  `CIN` varchar(10) DEFAULT NULL,
  `CNE` varchar(11) DEFAULT NULL,
  `Login` varchar(11) DEFAULT NULL,
  `password` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `document`
--

CREATE TABLE `document` (
  `idDocument` int(11) NOT NULL,
  `ISBN` varchar(45) DEFAULT NULL,
  `titre` varchar(45) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  `anneeEdition` int(11) DEFAULT NULL,
  `editeur` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `emprunt`
--

CREATE TABLE `emprunt` (
  `idEmprunt` int(11) NOT NULL,
  `IdClient` int(11) NOT NULL,
  `IdKindle` int(11) NOT NULL,
  `dateRetour` date DEFAULT NULL,
  `dateEmprunt` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `kindle`
--

CREATE TABLE `kindle` (
  `idKindle` int(11) NOT NULL,
  `Modele` varchar(45) DEFAULT NULL,
  `Mac` varchar(45) DEFAULT NULL,
  `Emprunte` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `auteur`
--
ALTER TABLE `auteur`
  ADD PRIMARY KEY (`idAuteur`),
  ADD KEY `idDoc_auteur` (`idDoc`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`);

--
-- Index pour la table `document`
--
ALTER TABLE `document`
  ADD PRIMARY KEY (`idDocument`);

--
-- Index pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD PRIMARY KEY (`idEmprunt`),
  ADD KEY `idClient_empr` (`IdClient`),
  ADD KEY `idKindle_empr` (`IdKindle`);

--
-- Index pour la table `kindle`
--
ALTER TABLE `kindle`
  ADD PRIMARY KEY (`idKindle`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `auteur`
--
ALTER TABLE `auteur`
  MODIFY `idAuteur` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `document`
--
ALTER TABLE `document`
  MODIFY `idDocument` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78;

--
-- AUTO_INCREMENT pour la table `emprunt`
--
ALTER TABLE `emprunt`
  MODIFY `idEmprunt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `kindle`
--
ALTER TABLE `kindle`
  MODIFY `idKindle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `auteur`
--
ALTER TABLE `auteur`
  ADD CONSTRAINT `idDoc_auteur` FOREIGN KEY (`idDoc`) REFERENCES `document` (`idDocument`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD CONSTRAINT `idClient_empr` FOREIGN KEY (`IdClient`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `idKindle_empr` FOREIGN KEY (`IdKindle`) REFERENCES `kindle` (`idKindle`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
