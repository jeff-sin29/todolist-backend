create database if not exists todo_db;

use todo_db;

CREATE TABLE IF NOT EXISTS Todo_tasks
(
    id        BIGINT NOT NULL AUTO_INCREMENT,
    text     VARCHAR(255) NOT NULL,
    done BIT DEFAULT 0,
    PRIMARY KEY (id)
);