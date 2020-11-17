
``` query
-- CREATE DATABASE springdata
-- CREATE USER 'springuser'@'%' IDENTIFIED by 'springpass'
grant all privileges on springdata.* to 'springuser'@'%'
show grants for 'jb'@'localhost';
-- revoke all on springdata.* from 'springuser'@'%';
```