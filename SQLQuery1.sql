CREATE Database loginTest;
Go

USE loginTest
GO

Create table account(
	username nvarchar(20) primary key,
	password nvarchar(20) not null
)
GO

INSERT INTO account values('vuaga1260','123456789','admin');
INSERT INTO account values('cuaga1260','123456789','nole');

TRUNCATE TABLE account

SELECT * from account where username = 'vuaga1260' and password = '123456789'

ALTER TABLE account ADD role nvarchar(10)