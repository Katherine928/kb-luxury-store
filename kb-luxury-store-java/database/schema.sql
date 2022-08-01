BEGIN TRANSACTION;

DROP TABLE IF EXISTS bags;
--DROP SEQUENCE IF EXISTS seq_user_id;

--CREATE SEQUENCE seq_user_id
--  INCREMENT BY 1
--  NO MAXVALUE
--  NO MINVALUE
--  CACHE 1;

 CREATE TABLE bags (
 	bag_id varchar (8) NOT NULL,
 	bag_name varchar (64) NOT NULL,
 	color varchar (64) NOT NULL,
 	price decimal(12,2) NOT NULL,
 	material varchar (64) NOT NULL,
 	bag_length decimal(12,1) NOT NULL,
 	bag_height decimal(12,1) NOT NULL,
 	bag_width decimal(12,1) NOT NULL,
 	description varchar (256) NOT NULL,
 	image_url varchar(128),
 	online int,
 	categories varchar(128),
 	iconic varchar(128)
 );


 INSERT INTO bags (bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url, online, categories, iconic) VALUES('M68750', 'TWIST BELT CHAIN WALLET', 'black', 1960.00, 'Epi grained cowhide leather', 7.5, 5.3, 1.7, 'The Twist belt chain wallet is crafted from black Epi leather, complemented by gold-tone hardware. This modern design can be carried as a clutch, on the shoulder, or - thanks to a loop at the back - on a belt.', 'https://i.postimg.cc/d3FTvCwW/bag.png', 1, 'Louis Vuitton', 'women');
 INSERT INTO bags (bag_id, bag_name, color, price, material, bag_length, bag_height, bag_width, description, image_url, online, categories, iconic) VALUES('M45958', 'DAUPHINE', 'black', 3800.00, 'Epi grained cowhide leather', 9.8, 6.7, 4.1, 'Elegant styling and practical features like multiple inside compartments and a removable braided leather-chain strap make it an ideal everyday bag. In classic black or a lustrous shade of blue, it adds a stylish accent to any outfit.', 'https://i.postimg.cc/W1r02077/dapu.png', 0,'Louis Vuitton', 'women');



 COMMIT TRANSACTION;