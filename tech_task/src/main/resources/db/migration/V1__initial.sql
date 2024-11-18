CREATE TABLE members
(
    id              SERIAL PRIMARY KEY,
    name            VARCHAR(255) UNIQUE NOT NULL,
    membership_date TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE books
(
    id               SERIAL PRIMARY KEY,
    title            VARCHAR(255) NOT NULL,
    author           VARCHAR(255) NOT NULL,
    description      VARCHAR(255) NOT NULL,
    publication_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    genre            VARCHAR[]    NOT NULL

);

CREATE TABLE member_books
(
    member_id SERIAL NOT NULL,
    book_id   SERIAL NOT NULL,
    FOREIGN KEY (member_id) REFERENCES members (id),
    FOREIGN KEY (book_id) REFERENCES books (id)
);

INSERT INTO members (name, membership_date)
VALUES ('Alice Smith', '2023-01-15 10:00:00'),
       ('Bob Johnson', '2022-05-22 14:30:00'),
       ('Charlie Brown', '2024-03-10 09:45:00'),
       ('Diana Prince', '2023-08-12 11:15:00'),
       ('Edward Elric', '2023-09-05 08:30:00'),
       ('Fiona Apple', '2024-01-20 12:00:00'),
       ('George Washington', '2023-12-01 15:00:00'),
       ('Hannah Montana', '2022-11-05 13:00:00'),
       ('Ian McKellen', '2023-06-17 09:30:00'),
       ('Julia Roberts', '2023-02-14 11:30:00'),
       ('Kevin Hart', '2023-04-02 10:45:00'),
       ('Liam Neeson', '2022-07-22 14:15:00'),
       ('Monica Bellucci', '2023-09-30 08:50:00'),
       ('Noah Centineo', '2022-12-15 12:45:00'),
       ('Olivia Wilde', '2023-03-25 09:00:00'),
       ('Peter Parker', '2024-02-10 15:30:00'),
       ('Quinn Fabray', '2023-07-04 10:15:00'),
       ('Rachel Green', '2022-08-21 14:50:00'),
       ('Steve Rogers', '2023-10-11 13:20:00'),
       ('Tony Stark', '2022-06-18 11:05:00');

INSERT INTO books (title, author, description, publication_date, genre)
VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 'A novel about the American dream.', '1925-04-10 00:00:00',
        '{"Fiction", "Classic"}'),
       ('1984', 'George Orwell', 'A dystopian novel about totalitarianism.', '1949-06-08 00:00:00',
        '{"Fiction", "Dystopian"}'),
       ('To Kill a Mockingbird', 'Harper Lee', 'A novel about racial injustice.', '1960-07-11 00:00:00',
        '{"Fiction", "Classic"}'),
       ('The Catcher in the Rye', 'J.D. Salinger', 'A story about teenage rebellion.', '1951-07-16 00:00:00',
        '{"Fiction", "Classic"}'),
       ('Brave New World', 'Aldous Huxley', 'A dystopian novel set in a technologically advanced future.',
        '1932-08-31 00:00:00', '{"Fiction", "Dystopian"}'),
       ('The Hobbit', 'J.R.R. Tolkien', 'A fantasy adventure.', '1937-09-21 00:00:00', '{"Fantasy", "Adventure"}'),
       ('Pride and Prejudice', 'Jane Austen', 'A romantic novel about manners.', '1813-01-28 00:00:00',
        '{"Fiction", "Romance"}'),
       ('Moby Dick', 'Herman Melville', 'A novel about the voyage of the whaling ship Pequod.', '1851-11-14 00:00:00',
        '{"Fiction", "Adventure"}'),
       ('The Picture of Dorian Gray', 'Oscar Wilde', 'A philosophical novel about vanity and moral duplicity.',
        '1890-07-01 00:00:00', '{"Fiction", "Classic"}'),
       ('War and Peace', 'Leo Tolstoy', 'A historical novel that chronicles the French invasion of Russia.',
        '1869-01-01 00:00:00', '{"Fiction", "Historical"}'),
       ('The Alchemist', 'Paulo Coelho', 'A novel about following your dreams.', '1988-05-01 00:00:00',
        '{"Fiction", "Philosophical"}'),
       ('The Da Vinci Code', 'Dan Brown', 'A mystery thriller that explores the hidden truths of Christianity.',
        '2003-03-18 00:00:00', '{"Mystery", "Thriller"}'),
       ('Harry Potter and the Sorcerer''s Stone', 'J.K. Rowling', 'A young boy discovers he is a wizard.',
        '1997-06-26 00:00:00', '{"Fantasy", "Adventure"}'),
       ('The Fault in Our Stars', 'John Green', 'A love story between two teenagers with cancer.',
        '2012-01-10 00:00:00', '{"Fiction", "Romance"}'),
       ('The Road', 'Cormac McCarthy', 'A post-apocalyptic novel about a father and son.', '2006-09-26 00:00:00',
        '{"Fiction", "Dystopian"}'),
       ('The Shining', 'Stephen King', 'A horror novel about a haunted hotel.', '1977-01-28 00:00:00',
        '{"Horror", "Fiction"}'),
       ('The Road Less Traveled', 'M. Scott Peck', 'A book about personal growth and spiritual development.',
        '1978-01-01 00:00:00', '{"Non-Fiction", "Self-Help"}'),
       ('Becoming', 'Michelle Obama', 'A memoir by the former First Lady of the United States.', '2018-11-13 00:00:00',
        '{"Non-Fiction", "Biography"}'),
       ('Educated', 'Tara Westover', 'A memoir about a woman who grows up in a strict and abusive household.',
        '2018-02-20 00:00:00', '{"Non-Fiction", "Memoir"}'),
       ('The Immortal Life of Henrietta Lacks', 'Rebecca Skloot',
        'A non-fiction book about the life of Henrietta Lacks and the immortal cell line.', '2010-02-02 00:00:00',
        '{"Non-Fiction", "Biography"}'),
       ('Sapiens: A Brief History of Humankind', 'Yuval Noah Harari', 'A book about the history of humankind.',
        '2011-01-01 00:00:00', '{"Non-Fiction", "History"}'),
       ('The Power of Habit', 'Charles Duhigg', 'A book about the science of habit formation.', '2012-02-28 00:00:00',
        '{"Non-Fiction", "Self-Help"}'),
       ('Born a Crime', 'Trevor Noah', 'A memoir about growing up in South Africa during apartheid.',
        '2016-11-15 00:00:00', '{"Non-Fiction", "Biography"}');

INSERT INTO member_books (member_id, book_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (3, 5),
       (3, 6),
       (4, 7),
       (4, 8),
       (5, 9),
       (5, 10),
       (6, 11),
       (6, 12),
       (7, 13),
       (7, 14),
       (8, 15),
       (8, 16),
       (9, 17),
       (9, 18),
       (10, 19),
       (10, 20),
       (11, 1),
       (11, 7),
       (12, 3),
       (13, 8),
       (14, 5),
       (15, 6),
       (16, 4),
       (17, 11),
       (18, 9);

