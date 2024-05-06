DROP SEQUENCE IF EXISTS fo_random_seq;
CREATE SEQUENCE fo_random_seq START WITH 1 INCREMENT BY 200;

DROP TABLE IF EXISTS fo_random;
CREATE TABLE `fo_random` (
     `id` bigint(20) NOT NULL,
     `insert_time` datetime(6) DEFAULT NOW(),
     `market_id` varchar(255) DEFAULT NULL,
     `match_id` varchar(255) DEFAULT NULL,
     `outcome_id` varchar(255) DEFAULT NULL,
     `specifiers` varchar(255) DEFAULT NULL,
     PRIMARY KEY (`id`)
);