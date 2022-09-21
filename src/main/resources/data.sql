INSERT INTO users (firstname, lastname, civility, role) VALUES
    ('Jonnhy', 'Silverhand', true, 'Artiste musicale'),
    ('Albert', 'Einstein', true, 'Physicien');

INSERT INTO disciplines (name) VALUES
    ('Gestion de projet'),
    ('Programmation Web');

INSERT INTO courses (name, description, idDiscipline, idUser) VALUES
    ('Javascript', 'un cours de Javascript', 2, 1),
    ('PhP', 'un cours de PhP', 2, 1);

INSERT INTO chapters (title, content, idCourse) VALUES
    ('Fondamentaux du Javascript', 'Un contenu ...', 1),
    ('Javascript côté navigateur', 'Un autre contenu', 1),
    ('Architecture Client-Serveur', 'Un contenu PhP', 2);
