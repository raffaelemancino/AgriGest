BEGIN TRANSACTION;
CREATE TABLE "Rotazione" (
	`idFamiglia`	INTEGER,
	`idFamigliaRot`	INTEGER,
	PRIMARY KEY(`idFamiglia`,`idFamigliaRot`),
	FOREIGN KEY(`idFamiglia`) REFERENCES `Famiglia`(`id`),
	FOREIGN KEY(`idFamigliaRot`) REFERENCES `Famiglia`(`id`)
);
CREATE TABLE `Operaio` (
	`CF`	TEXT,
	`nome`	TEXT,
	`cognome`	TEXT,
	`nascita`	DATE,
	PRIMARY KEY(`CF`)
);
CREATE TABLE `Mezzo` (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`targa`	TEXT,
	`nome`	TEXT
);
CREATE TABLE `Masseria` (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`nome`	TEXT NOT NULL
);
CREATE TABLE "GiornataLavoro" (
	`CFOperaio`	TEXT,
	`idGiornata`	INTEGER,
	`idMezzo`	INTEGER,
	PRIMARY KEY(`CFOperaio`,`idGiornata`),
	FOREIGN KEY(`CFOperaio`) REFERENCES `Operaio`(`CF`),
	FOREIGN KEY(`idGiornata`) REFERENCES `Giornata`(`id`),
	FOREIGN KEY(`idMezzo`) REFERENCES `Mezzo`(`id`)
);
CREATE TABLE "Giornata" (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`idAppezzamento`	INTEGER,
	`data`	DATE,
	`descrizione`	TEXT NOT NULL,
	FOREIGN KEY(`idAppezzamento`) REFERENCES `Appezzamento`(`id`)
);
CREATE TABLE `Famiglia` (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`nome`	TEXT
);
CREATE TABLE "Coltura" (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`nome`	TEXT,
	`idFamiglia`	INTEGER,
	FOREIGN KEY(`idFamiglia`) REFERENCES `Famiglia`(`id`)
);
CREATE TABLE `AppezzamentoColtura` (
	`idAppezzamento`	INTEGER,
	`idColtura`	INTEGER,
	`dataSemina`	DATA NOT NULL,
	`dataRaccolta`	DATA,
	PRIMARY KEY(`idAppezzamento`,`idColtura`),
	FOREIGN KEY(`idAppezzamento`) REFERENCES Appezzamento(id),
	FOREIGN KEY(`idColtura`) REFERENCES Coltura(id)
);
CREATE TABLE `Appezzamento` (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`nome`	TEXT NOT NULL,
	`dimensione`	REAL,
	`idMasseria`	INTEGER,
	FOREIGN KEY(`idMasseria`) REFERENCES Masseria(id)
);
COMMIT;
