CREATE TABLE IF NOT EXISTS users
(
    id              SERIAL PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    email           VARCHAR(255) NOT NULL,
    password        VARCHAR(255) NOT NULL,
    position        VARCHAR(100),
    create_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_driver       BOOLEAN   DEFAULT FALSE,
    phone           VARCHAR(20),
    personal_number VARCHAR(50),
    category_in_tm  VARCHAR(100)
);