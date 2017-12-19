CREATE TABLE utilisateur (
    id INT(3) NOT NULL AUTO_INCREMENT,
    nom VARCHAR(90),
    prenom VARCHAR(90),
    email VARCHAR(50),
    psw VARCHAR(250),
    role VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE restaurant (
    id INT(3) NOT NULL AUTO_INCREMENT,
    nom VARCHAR(50),
    adresse VARCHAR(80),
    gerant VARCHAR(50),
    telephone INT(10),
    PRIMARY KEY (id)
);

CREATE TABLE produit (
    id INT(3) NOT NULL AUTO_INCREMENT,
    nom VARCHAR(50),
    quantite INT(50),
    prix INT(4),
    PRIMARY KEY (id)
);

CREATE TABLE commande (
    id INT(3) NOT NULL AUTO_INCREMENT,
    restaurant_destinataire VARCHAR(50),
    quantite INT(50),
    PRIMARY KEY (id)
);

INSERT INTO utilisateur (email, psw, role)
    VALUES ('superadmin@default.com', '@changeme@', 'admin');