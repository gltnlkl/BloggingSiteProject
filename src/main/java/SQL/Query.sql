CREATE DATABASE blogproject
	WITH
	OWNER = postgres
	ENCODING = 'UTF8'
	CONNECTION LIMIT = -1;

BEGIN;



CREATE TABLE IF NOT EXISTS public.admin_blog
(
admin_id serial NOT NULL,
admin_name character varying,
admin_surname character varying,
admin_tel_number character varying,
admin_email_addres character varying,
admin_password character varying,
admin_number_of_records integer,
created_date timestamp with time zone default current_timestamp,
PRIMARY KEY (admin_id)
);



CREATE TABLE IF NOT EXISTS public.user_blog
(
user_id serial NOT NULL,
user_name character varying,
user_surname character varying,
user_tel_number character varying,
user_email_address character varying,
user_password character varying,
user_is_active boolean,
user_hescode character varying,
created_date timestamp with time zone default current_timestamp,
admin_id integer NOT NULL,
PRIMARY KEY (user_id)
);



ALTER TABLE public.user_blog
ADD FOREIGN KEY (admin_id)
REFERENCES public.admin_blog (admin_id)
NOT VALID;



END;