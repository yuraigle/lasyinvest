DROP TABLE IF EXISTS `indicators`;
DROP TABLE IF EXISTS `day_candles`;
DROP TABLE IF EXISTS `assets`;
DROP TABLE IF EXISTS `asset_sectors`;

CREATE TABLE `asset_sectors`
(
    `id`   BIGINT       NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) COLLATE = 'utf8mb3_general_ci';

CREATE TABLE `assets`
(
    `id`        BIGINT       NOT NULL AUTO_INCREMENT,
    `symbol`    VARCHAR(20)  NOT NULL,
    `name`      VARCHAR(100) NULL,
    `icon`      VARCHAR(255) NULL,
    `country`   INT          NULL,
    `sector_id` BIGINT       NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `IDX_ASSETS_SECTOR_ID` (`sector_id`) USING BTREE,
    CONSTRAINT `FK_ASSETS_SECTOR_ID` FOREIGN KEY (`sector_id`) REFERENCES `asset_sectors` (`id`)
        ON UPDATE RESTRICT ON DELETE RESTRICT,
    CONSTRAINT `IDX_ASSETS_SYMBOL_UNIQ` UNIQUE KEY (`symbol`)
) COLLATE = 'utf8mb3_general_ci';

CREATE TABLE `indicators`
(
    `id`          BIGINT       NOT NULL AUTO_INCREMENT,
    `name`        VARCHAR(20)  NOT NULL,
    `description` VARCHAR(255) NULL,
    PRIMARY KEY (`id`) USING BTREE
) COLLATE = 'utf8mb3_general_ci';

CREATE TABLE `day_candles`
(
    `id`       BIGINT          NOT NULL AUTO_INCREMENT,
    `date`     DATE            NULL,
    `open`     DECIMAL(30, 15) NULL,
    `close`    DECIMAL(30, 15) NULL,
    `low`      DECIMAL(30, 15) NULL,
    `high`     DECIMAL(30, 15) NULL,
    `volume`   BIGINT          NULL,
    `asset_id` BIGINT          NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `IDX_DAY_CANDLES_ASSET_ID` (`asset_id`) USING BTREE,
    CONSTRAINT `FK_DAY_CANDLES_ASSET_ID` FOREIGN KEY (`asset_id`) REFERENCES `assets` (`id`)
        ON UPDATE RESTRICT ON DELETE RESTRICT,
    CONSTRAINT `IDX_DAY_CANDLES_UNIQ` UNIQUE KEY (`asset_id`, `date`)
) COLLATE = 'utf8mb3_general_ci';
