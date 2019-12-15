CREATE TABLE users
(
    id            BIGINT              NOT NULL AUTO_INCREMENT,
    name          VARCHAR(40)         NOT NULL,
    version       INTEGER   DEFAULT 0 NOT NULL,
    created       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (id)
);

CREATE TABLE projects
(
    id            BIGINT              NOT NULL AUTO_INCREMENT,
    name          VARCHAR(40)         NOT NULL,
    hourly_rate   DECIMAL(10,2)       NOT NULL,
    version       INTEGER   DEFAULT 0 NOT NULL,
    created       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (id)
);

CREATE TABLE timereports
(
    id            BIGINT              NOT NULL AUTO_INCREMENT,
    hours         DECIMAL(10,2)       NOT NULL,
    user_id       BIGINT              NOT NULL,
    project_id    BIGINT              NOT NULL,
    version       INTEGER   DEFAULT 0 NOT NULL,
    created       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (id),
    CONSTRAINT fk_timereports_users FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_timereports_projects FOREIGN KEY (project_id) REFERENCES projects(id)
);