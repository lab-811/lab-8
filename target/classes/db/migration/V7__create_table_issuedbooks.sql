CREATE TABLE IssuedBooks(
                            id BIGINT GENERATED ALWAYS AS  IDENTITY,
                            book_id BIGINT,
                            user_id BIGINT,
                            PRIMARY KEY(id),
                            CONSTRAINT fk_registration
                                FOREIGN KEY (book_id)
                                    REFERENCES Books(id),
                            CONSTRAINT fk_product
                                FOREIGN KEY (user_id)
                                    REFERENCES Users(id)
)