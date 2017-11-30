
DROP TABLE IF EXISTS student;

create table student
(
   id integer not null,
   name varchar(255) not null,
   surname varchar(255),
   primary key(id)
);

INSERT INTO STUDENT (ID, NAME, SURNAME ) 
VALUES(100,  'John', 'Smith');
INSERT INTO STUDENT (ID, NAME, SURNAME ) 
VALUES(101,  'Emre', 'Eker');
INSERT INTO STUDENT (ID, NAME, SURNAME ) 
VALUES(102,  'Cemre', 'Eker');

