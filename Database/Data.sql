/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data Department
INSERT INTO Department	(DepartmentName, author_id	,	CreateDate)
VALUES                  (N'Marketing'	,	5		,	'2020-03-05'),
						(N'Sale'		,	1		,	'2020-03-07'),
						(N'Bảo vệ'		,	2		,	'2020-03-08'),
						(N'Nhân sự'		,	3		,	'2020-03-10'),
						(N'Kỹ thuật'	,	4		,	NOW()),
						(N'Tài chính'	,	6		,	NOW()),
						(N'Phó giám đốc',	7		,	'2020-04-07'),
						(N'Giám đốc'	,	8		,	'2020-04-07'),
						(N'Thư kí'		,	9		,	'2020-04-09'),
						(N'Bán hàng'	,	5		,	'2020-04-09');

-- Add data Account
INSERT INTO `Account`(Email								, Username			, FirstName,	LastName,		 DepartmentID	,	CreateDate)
VALUES 				('haidang29productions@gmail.com'	, 'dangblack'		,'Dang'	,		'Nguyen Hai'	,   '5'			,	'2020-03-05'),
					('account1@gmail.com'				, 'quanganh'		,'Anh'	,		'Tong Quang'	,   '1'			,	'2020-03-05'),
                    ('account2@gmail.com'				, 'vanchien'		,'Chien',		'Nguyen Van'	,   '2'			,	'2020-03-07'),
                    ('account3@gmail.com'				, 'cocoduongqua'	,'Do'	,		'Duong'			,   '3'			,	'2020-03-08'),
                    ('account4@gmail.com'				, 'doccocaubai'		,'Thang',		'Nguyen Chien'  ,   '4'			,	'2020-03-10'),
                    ('dapphatchetngay@gmail.com'		, 'khabanh'			,'Kha'	,		'Ngo Ba'		,   '6'			,	NOW()),
                    ('songcodaoly@gmail.com'			, 'huanhoahong'		,'Huan'	,		'Bui Xuan'		,   '7'			,	NOW()),
                    ('sontungmtp@gmail.com'				, 'tungnui'			,'Tung'	,		'Nguyen Thanh'	,   '8'			,	'2020-04-07'),
                    ('duongghuu@gmail.com'				, 'duongghuu'		,'Huu'	,		'Duong Van'		,   '9'			,	'2020-04-07'),
                    ('vtiaccademy@gmail.com'			, 'vtiaccademy'		,'Ai'	,		'Vi Ti'			,   '10'		,	'2020-04-09');

ALTER TABLE Department
ADD FOREIGN KEY (author_id) REFERENCES `Account`(AccountID);