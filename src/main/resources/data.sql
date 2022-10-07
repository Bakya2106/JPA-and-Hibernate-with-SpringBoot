

insert into idproof
(ID, IDPROOF)
VALUES (40001, 'AADHAR');
insert into idproof
(ID, IDPROOF)
VALUES (40002, 'PAN CARD');

insert into clubs
(ID, clubname)
VALUES (1, 'YOGA CLUB');
insert into clubs
(ID, clubname)
VALUES (2, 'DANCE CLUB');

insert into student
(ID, NAME,IDP_ID)
VALUES (2001, 'BAKYA',40001);
insert into student
(ID, NAME,IDP_ID)
VALUES (2002, 'DHARSHANA',40002);


insert into course
(ID, COURSE)
VALUES (221, 'CORE JAVA COURSE');
insert into course
(ID, COURSE, REVIEW)
VALUES (222, 'SQL COURSE', '5 -Very Good');


insert into student_clubs
(student_id,clubs_id)
VALUES (2001, 1);
insert into student_clubs
(student_id,clubs_id)
VALUES (2002, 1);
insert into student_clubs
(student_id,clubs_id)
VALUES (2002, 2);

