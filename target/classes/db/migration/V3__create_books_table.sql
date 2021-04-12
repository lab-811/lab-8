CREATE TABLE Books(
                      id BIGINT GENERATED ALWAYS AS IDENTITY,
                      title varchar,
                      author varchar,
                  PRIMARY KEY (id)
)