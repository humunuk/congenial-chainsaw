CREATE TABLE IF NOT EXISTS `sanctioned_person` (

                                          `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                          `name` varchar(120),
                                          `reason` TEXT,
                                          `created` timestamp,
                                          `active_from` timestamp,
                                          `deleted_at` timestamp

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;