DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id         INTEGER PRIMARY KEY,
    first_name text NOT NULL,
    last_name  text NOT NULL,
    role       text
);

INSERT INTO users VALUES (1, 'Pavel', 'Gordon', 'dev');
INSERT INTO users VALUES (2, 'Ilya', 'Lyamkin', 'dev');



CREATE OR REPLACE FUNCTION notify_user_changes()
RETURNS trigger AS $$
BEGIN
    PERFORM pg_notify(
                    'user_update',
                    json_build_object(
                            'operation', TG_OP,
                            'user', row_to_json(NEW)
                        )::text
                );
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER scenario_updated
    AFTER INSERT OR UPDATE OR DELETE
    ON users
    FOR EACH ROW
EXECUTE PROCEDURE notify_user_changes();