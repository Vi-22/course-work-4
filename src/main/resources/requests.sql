-- создание таблицы Альпинист

CREATE TABLE IF NOT EXISTS tb_climbers(id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL,
address VARCHAR(255) NOT NULL, group_numbers INTEGER)

-- Добавление данных в таблицу Альпинист

 INSERT INTO tb_climbers (name, address) VALUES (?, ?) RETURNING id

-- Изменение имени альпиниста

 UPDATE tb_climbers SET name = ? WHERE id = ?

-- Получение идентификатором и имен альпинистов старше 30 и младше 50 лет

SELECT id, name FROM tb_climbers WHERE age > 30 AND age < 50

-- Получение названий гор, высота которых больше указанной

SELECT name FROM tb_mountains WHERE height > ?

-- Получение страны, в которой расположена гора с определенным названием

SELECT country FROM tb_mountains WHERE name = ?

-- Получение идентификаторов, которые совершали восхождения в прошлом

SELECT climber_id FROM tb_group WHERE climbDate < CURRENT_TIMESTAMP

-- Получение идентификаторов групп, которые совершали восхождения на гору с определенным названием

SELECT group_number FROM tb_mountains WHERE name = ?

-- Получение идентификатором и имен альпинистов, которые совершали
-- восхождения на горы, высота которых от ... до ...

SELECT climber_id, name FROM tb_climbers WHERE group_number =
(SELECT group_number FROM tb_mountains WHERE height <= ? AND height >= ?)