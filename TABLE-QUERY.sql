CREATE TABLE users(
			id SERIAL PRIMARY KEY,
			username VARCHAR(100),
			email VARCHAR(100),
			gender VARCHAR(1),
			phonenumber VARCHAR(100),
			status VARCHAR(1),
			user_hash VARCHAR(100),
			created_date TIMESTAMP
);