-- YenNhi HO TONG MINH

-- Base de donnée: dragon2

-- Structure de la table dragons


CREATE TABLE dragons (
    id int(11) NOT NULL AUTO_INCREMENT,
    dragon varchar(45) NOT NULL,
    sexe char(1) ,
    longueur int(11),
    nombreEcailles int(11) ,
    cracheDuFeu varchar(5),
    comportementAmoureux varchar(45) ,
    PRIMARY KEY (Id)
    );
-- Déchargement des données de la table `dragons`

INSERT INTO dragons(dragon,sexe,longueur,nombreEcailles,cracheDuFeu,comportementAmoureux) VALUES
('Smaug','M',152,1857,'oui','macho'),
('Birdurth','M',258,4787,'non','timide'),
('Négueth','F',128,1581,'oui','sincere'),
('MissToc','F',183,2781,'non','superflu'),
('Bolong','M',213,2751,'oui','macho'),
('Miloch','M',83,718,'oui','timide'),
('Nessie','M',168,1721,'non','absent'),
('Tarak','F',123,851,'oui','timide'),
('Solong','M',173,1481,'oui','sincere');


-- Structure de la table 'aime'


CREATE TABLE aime (
id_dragonAimant int(10)  NOT NULL,
id_dragonAime int(10)  NOT NULL,
forceNiveau varchar(15)  NOT NULL,
PRIMARY KEY (id_dragonAimant,id_dragonAime)    
);


-- Déchargement des données de la table 'aime'


INSERT INTO aime(id_dragonAimant,id_dragonAime,forceNiveau) VALUES
(1,3,'passionnement'),
(2,3,'beaucoup'),
(3,6,'a la folie'),
(6,3,'a la folie'),
(8,9,'un peu'),
(9,8,'beaucoup');


-- Structure de la table 'nourritures'


CREATE TABLE nourritures(
id int(10) NOT NULL AUTO_INCREMENT,
produit varchar(10) NOT NULL,
calories int(2) NOT NULL,
PRIMARY KEY ( Id)
);


-- Déchargement des données de la table 'nourritures'


INSERT INTO nourritures(produit,calories) VALUES 
('pomme',7),
('cacahuete',10),
('orange',25),
('oeuf',15),
('ver',3),
('poisson',35);


-- Structure de la table 'repas'


CREATE TABLE repas (
    id_dragon varchar(10) ,
    id_produit varchar(10) ,
    quantité int(11),
    PRIMARY KEY (id_dragon, id_produit)
    );

-- Déchargement des données de la table 'repas'

INSERT INTO repas (id_dragon, id_produit, quantité) VALUES
(1,'cacahuete',1000),
(1,'pomme',16),
(2,'oeuf',4),
(3,'orange',6),
(3,'oeuf',1),
(6,'ver',53),
(6,'cacahuete',100),
(7,'poisson',20),
(8,'pomme',10),
(8,'orange',10),
(9,'oeuf',6),
(9,'poisson',1),
(9,'orange',2);