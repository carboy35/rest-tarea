CREATE TABLE `prueba`.`tar_tarea` (
  `tar_id` INT NOT NULL AUTO_INCREMENT,
  `tar_descripcion` VARCHAR(100) NULL,
  `tar_fecha_creacion` DATE NULL,
  `vigente` TINYINT NULL,
  PRIMARY KEY (`tar_id`),
  UNIQUE INDEX `tar_id_UNIQUE` (`tar_id` ASC) VISIBLE);



