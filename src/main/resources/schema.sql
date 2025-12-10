CREATE TABLE DEPT
       (DEPTNO INT PRIMARY KEY,
        DNAME VARCHAR(14),
        LOC VARCHAR(13) );
		
		
	CREATE TABLE EMP
       (EMPNO INT PRIMARY KEY,
        ENAME VARCHAR(10),
        JOB VARCHAR(9),
        MGR INT,
        HIREDATE DATE,
        SAL DOUBLE,
        COMM DOUBLE,
        DEPTNO INT references dept(deptno));