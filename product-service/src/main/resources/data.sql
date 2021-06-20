CREATE TABLE IF NOT EXISTS product
(
    `id`           INT         NOT NULL,
    `code` VARCHAR(45) NOT NULL,
    `name`         VARCHAR(45) NOT NULL,
    `description`  VARCHAR(45) NULL,
    `price`        DOUBLE      NOT NULL,
    `quantity`     INT(11)     NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `code_UNIQUE` (`code` ASC)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_bin;


DELETE
FROM product;

insert into product(id, code, name, description, price, quantity)
VALUES (1, 'P001', 'NOKIA 1', 'NOKIA 1 description', 250, 25),
       (2, 'P002', 'NOKIA 2', 'NOKIA 2 description', 230, 32),
       (3, 'P003', 'NOKIA 3', 'NOKIA 3 description', 210, 50)
;
