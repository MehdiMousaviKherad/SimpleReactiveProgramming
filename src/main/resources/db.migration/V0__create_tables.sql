create table Students (
    id serial primary key not null  ,
    firstname varchar(250) ,
    name varchar(250)
);
create table Courses(
    id serial not null primary key  ,
    name varchar(250)
);
create table StudentWithCourse(
    id serial not null primary key  ,
    student_id integer not null  ,
    course_id integer not null
)