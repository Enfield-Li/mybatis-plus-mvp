CREATE TABLE `user` (
                        `id` BIGINT(20) NOT NULL COMMENT '主键ID',
                        `name` VARCHAR(30) COMMENT '名字',
                        `age` INT(11) COMMENT '年龄',
                        `email` VARCHAR(50) COMMENT '邮箱',
                        PRIMARY KEY (`id`)
);