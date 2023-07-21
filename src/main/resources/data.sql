INSERT INTO BLOG (id, title, content) VALUES (1, 'Economy', 'The economy of Colombia is the fourth largest in Latin America as measured by gross domestic product and the third-largest economic power in South America. Colombia has experienced a historic economic boom over the last decade.');
INSERT INTO BLOG (id, title, content) VALUES (2, 'Tech', 'The fourth industrial revolution refers to how technological advancements like artificial intelligence, autonomous vehicles and the internet of things are changing the way humans live.');
INSERT INTO BLOG (id, title, content) VALUES (3, 'Politics', 'Germany is a democratic and federal parliamentary republic, where federal legislative power is vested in the Bundestag.');


INSERT INTO COMMENT (id, post_id, author, content, created_at) VALUES (1, 1, 'Author 1', 'Nice', '2023-07-19');
INSERT INTO COMMENT (id, post_id, author, content, created_at) VALUES (2, 1, 'Author 2', 'Good 2', '2023-07-19');
INSERT INTO COMMENT (id, post_id, author, content, created_at) VALUES (3, 2, 'Author 3', 'Awesome 3', '2023-07-19');
INSERT INTO COMMENT (id, post_id, author, content, created_at) VALUES (4, 1, 'Author 1', 'Nice 4', '2023-07-19');
INSERT INTO COMMENT (id, post_id, author, content, created_at) VALUES (5, 2, 'Author 2', 'Wonderful 5', '2023-07-19');
INSERT INTO COMMENT (id, post_id, author, content, created_at) VALUES (6, 3, 'Author 3', 'Amazing 6', '2023-07-19');
INSERT INTO COMMENT (id, post_id, author, content, created_at) VALUES (7, 2, 'Author 1', 'True 7', '2023-07-19');
INSERT INTO COMMENT (id, post_id, author, content, created_at) VALUES (8, 2, 'Author 2', 'This is my POV and remains 8', '2023-07-19');
INSERT INTO COMMENT (id, post_id, author, content, created_at) VALUES (9, 2, 'Author 3', 'False 9', '2023-07-19');
INSERT INTO COMMENT (id, post_id, author, content, created_at) VALUES (10, 3, 'Author 1', 'Hola 10', '2023-07-19');