-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema escritorioadvg
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema escritorioadvg
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `escritorioadvg` DEFAULT CHARACTER SET utf8mb3 ;
USE `mydb` ;
USE `escritorioadvg` ;

-- -----------------------------------------------------
-- Table `escritorioadvg`.`advogados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escritorioadvg`.`advogados` (
  `idAdvogados` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `numeroOAB` VARCHAR(45) NOT NULL,
  `especializacao` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(45) NOT NULL,
  `logradouro` VARCHAR(45) NOT NULL,
  `numCasa` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAdvogados`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `escritorioadvg`.`advogados_processos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escritorioadvg`.`advogados_processos` (
  `ProcessosPrevidenciarios_idProcessosPrevidenciarios` INT NOT NULL,
  `ProcessosTrabalhistas_idProcessosTrabalhistas` INT NOT NULL,
  `ProcessosPenais_idProcessosPenais` INT NOT NULL,
  `ProcessosCiveis_idProcessosCiveis` INT NOT NULL,
  `Advogados_idAdvogados1` INT NOT NULL,
  INDEX `fk_Advogados_has_ProcessosPrevidenciarios_ProcessosPreviden_idx` (`ProcessosPrevidenciarios_idProcessosPrevidenciarios` ASC) VISIBLE,
  INDEX `fk_Advogados_has_ProcessosPrevidenciarios_ProcessosTrabalhi_idx` (`ProcessosTrabalhistas_idProcessosTrabalhistas` ASC) VISIBLE,
  INDEX `fk_Advogados_has_ProcessosPrevidenciarios_ProcessosPenais1_idx` (`ProcessosPenais_idProcessosPenais` ASC) VISIBLE,
  INDEX `fk_Advogados_has_ProcessosPrevidenciarios_ProcessosCiveis1_idx` (`ProcessosCiveis_idProcessosCiveis` ASC) VISIBLE,
  INDEX `fk_Advogados_Processos_Advogados1_idx` (`Advogados_idAdvogados1` ASC) VISIBLE,
  CONSTRAINT `fk_Advogados_has_ProcessosPrevidenciarios_ProcessosCiveis1`
    FOREIGN KEY (`ProcessosCiveis_idProcessosCiveis`)
    REFERENCES `mydb`.`processosciveis` (`idProcessosCiveis`),
  CONSTRAINT `fk_Advogados_has_ProcessosPrevidenciarios_ProcessosPenais1`
    FOREIGN KEY (`ProcessosPenais_idProcessosPenais`)
    REFERENCES `mydb`.`processospenais` (`idProcessosPenais`),
  CONSTRAINT `fk_Advogados_has_ProcessosPrevidenciarios_ProcessosPrevidenci1`
    FOREIGN KEY (`ProcessosPrevidenciarios_idProcessosPrevidenciarios`)
    REFERENCES `mydb`.`processosprevidenciarios` (`idProcessosPrevidenciarios`),
  CONSTRAINT `fk_Advogados_has_ProcessosPrevidenciarios_ProcessosTrabalhist1`
    FOREIGN KEY (`ProcessosTrabalhistas_idProcessosTrabalhistas`)
    REFERENCES `mydb`.`processostrabalhistas` (`idProcessosTrabalhistas`),
  CONSTRAINT `fk_Advogados_Processos_Advogados1`
    FOREIGN KEY (`Advogados_idAdvogados1`)
    REFERENCES `mydb`.`advogados` (`idAdvogados`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `escritorioadvg`.`cadastro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escritorioadvg`.`cadastro` (
  `idCadastro` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  PRIMARY KEY (`idCadastro`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `escritorioadvg`.`clientefisico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escritorioadvg`.`clientefisico` (
  `idClienteFisico` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(45) NOT NULL,
  `logradouro` VARCHAR(45) NOT NULL,
  `numCasa` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idClienteFisico`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `escritorioadvg`.`clientejuridico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escritorioadvg`.`clientejuridico` (
  `idClienteJuridico` INT NOT NULL AUTO_INCREMENT,
  `razaoSocial` VARCHAR(45) NOT NULL,
  `CNPJ` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(45) NOT NULL,
  `logradouro` VARCHAR(45) NOT NULL,
  `numCasa` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idClienteJuridico`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `escritorioadvg`.`processosciveis`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escritorioadvg`.`processosciveis` (
  `idProcessosCiveis` INT NOT NULL AUTO_INCREMENT,
  `numeroProcesso` INT NOT NULL,
  `dataInicio` DATE NULL DEFAULT NULL,
  `partesEnvolvidas` VARCHAR(45) NOT NULL,
  `tipoAcao` VARCHAR(45) NOT NULL,
  `valorCausa` VARCHAR(45) NULL DEFAULT NULL,
  `faseProcesso` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProcessosCiveis`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `escritorioadvg`.`processospenais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escritorioadvg`.`processospenais` (
  `idProcessosPenais` INT NOT NULL AUTO_INCREMENT,
  `numeroProcesso` INT NOT NULL,
  `dataInicio` DATE NOT NULL,
  `nomeReu` VARCHAR(45) NOT NULL,
  `tipoCrime` VARCHAR(45) NOT NULL,
  `faseProcesso` VARCHAR(45) NOT NULL,
  `Cadastro_idCadastro` INT NOT NULL,
  PRIMARY KEY (`idProcessosPenais`),
  INDEX `fk_ProcessosPenais_Cadastro1_idx` (`Cadastro_idCadastro` ASC) VISIBLE,
  CONSTRAINT `fk_ProcessosPenais_Cadastro1`
    FOREIGN KEY (`Cadastro_idCadastro`)
    REFERENCES `mydb`.`cadastro` (`idCadastro`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `escritorioadvg`.`processosprevidenciarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escritorioadvg`.`processosprevidenciarios` (
  `idProcessosPrevidenciarios` INT NOT NULL AUTO_INCREMENT,
  `numeroProcesso` INT NOT NULL,
  `dataInicio` DATE NOT NULL,
  `partesEnvolvidas` VARCHAR(45) NOT NULL,
  `tipoAcao` VARCHAR(45) NOT NULL,
  `faseProcesso` VARCHAR(45) NOT NULL,
  `Cadastro_idCadastro` INT NOT NULL,
  PRIMARY KEY (`idProcessosPrevidenciarios`),
  INDEX `fk_ProcessosPrevidenciarios_Cadastro1_idx` (`Cadastro_idCadastro` ASC) VISIBLE,
  CONSTRAINT `fk_ProcessosPrevidenciarios_Cadastro1`
    FOREIGN KEY (`Cadastro_idCadastro`)
    REFERENCES `mydb`.`cadastro` (`idCadastro`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `escritorioadvg`.`processostrabalhistas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escritorioadvg`.`processostrabalhistas` (
  `idProcessosTrabalhistas` INT NOT NULL AUTO_INCREMENT,
  `numeroProcesso` INT NOT NULL,
  `reclamante` VARCHAR(45) NOT NULL,
  `tipoAcao` VARCHAR(45) NOT NULL,
  `valorReivindicado` VARCHAR(45) NULL DEFAULT NULL,
  `faseProcesso` VARCHAR(45) NOT NULL,
  `dataInicio` VARCHAR(45) NOT NULL,
  `Cadastro_idCadastro` INT NOT NULL,
  PRIMARY KEY (`idProcessosTrabalhistas`),
  INDEX `fk_ProcessosTrabalhistas_Cadastro1_idx` (`Cadastro_idCadastro` ASC) VISIBLE,
  CONSTRAINT `fk_ProcessosTrabalhistas_Cadastro1`
    FOREIGN KEY (`Cadastro_idCadastro`)
    REFERENCES `mydb`.`cadastro` (`idCadastro`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
