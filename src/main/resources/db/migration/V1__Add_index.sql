DROP INDEX IF EXISTS idx_voter_names;
CREATE INDEX idx_voter_name
    ON voter(first_name);
CREATE INDEX idx_voter_surname
    ON voter(last_name);
CREATE INDEX idx_voter_patronymic
    ON voter(middle_name);