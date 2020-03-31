DROP TABLE IF EXISTS Student;
DROP TABLE IF EXISTS Course;
DROP TABLE IF EXISTS Teacher;
DROP TABLE IF EXISTS Subscribed;

DROP view if exists all_information;


Create  table if not exists Student(
                                       StudentID INTEGER primary key,
                                       StudentName varchar not null,
                                       StudentTown varchar not null


);

create  table if not exists Course(
                                      CourseName varchar,
                                      ID integer not null,
                                      TeacherID integer,
                                      foreign key (TeacherID) references Teacher (TeacherID) ON DELETE RESTRICT ON UPDATE CASCADE,
                                          primary key (CourseName, ID)

);

create table if not exists Teacher(
                                      TeacherID INTEGER PRIMARY KEY ,
                                      TeacherName VARCHAR not null

);

create table if not exists Subscribed(

                                        StudentID integer,
                                        CourseID integer,
                                        Grades integer,
                                        CourseName Varchar,

                                        foreign key (StudentID) references Student (StudentID) ON DELETE RESTRICT ON UPDATE CASCADE,
                                        foreign key (CourseName, CourseID) references Course (CourseName, ID) ON DELETE RESTRICT ON UPDATE CASCADE,
                                        PRIMARY KEY (CourseID, CourseName, StudentID)

);



INSERT INTO Course (CourseName, ID, TeacherID) VALUES
                                                        ("SD",2019,1),
                                                        ("SD",2020,1),
                                                        ("ES1",2019,2);



INSERT INTO Student(StudentID, StudentName, StudentTown) VALUES
                                                                (1, "Aisha Lincoln", "Nykøbing F"),
                                                                (2, "Anya Nielsen", "Nykøbing F"),
                                                                (3, "Benjamin Jensen", "Camas"),
                                                                (4, "Berta Bertelsen", "Billund"),
                                                                (5, "Albert Antonsen", "Sorø"),
                                                                (6, "Eske Eriksen", "Eskildstrup"),
                                                                (7, "Olaf Olesen", "Odense"),
                                                                (8, "Salma Simonsen", "Stockholm"),
                                                                (9, "Theis Thomasen", "Tølløse"),
                                                                (10, "Janet Jensen", "Jyllinge");


INSERT INTO  Teacher(TeacherID, TeacherName) VALUES

                                                    (1, "Line"),
                                                    (2, "Ebbe");

INSERT INTO Subscribed(StudentID, CourseID, Grades, CourseName) VALUES

                                                                        (1,2019, 12, "SD"),
                                                                        (1,2019,10,"ES1"),
                                                                       (2,2020,null,"SD"),
                                                                       (2,2019,12,"ES1"),
                                                                       (3,2019,7,"SD"),
                                                                       (3,2019,10,"ES1"),
                                                                       (4,2020,null,"SD"),
                                                                       (4,2019,2,"ES1"),
                                                                       (5,2020,null,"SD"),
                                                                       (5, 2019,7,"ES1"),
                                                                       (6,2020,null,"SD"),
                                                                       (6,2019,10,"ES1"),
                                                                       (7,2019,4,"SD"),
                                                                       (7,2019,12,"ES1"),
                                                                       (8,2020,null,"SD"),
                                                                       (8,2019,12,"ES1"),
                                                                       (9,2019,12,"SD"),
                                                                       (9,2019,12,"ES1"),
                                                                       (10,2020,null,"SD"),
                                                                       (10,2019,7,"ES1");





