-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER katherine
WITH PASSWORD 'katherine';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO katherine;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO katherine;

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO katherine;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO katherine;
