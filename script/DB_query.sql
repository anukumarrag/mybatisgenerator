CREATE TABLE "users" (
  "id" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "created_by" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "created_time" timestamp(6),
  "last_updated_by" varchar(50) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "last_updated_time" timestamp(6),
  "first_name" varchar(500) COLLATE "pg_catalog"."default",
  "last_name" varchar(500) COLLATE "pg_catalog"."default",
  "picture" varchar(500) COLLATE "pg_catalog"."default",
  "preferred_language" varchar(100) COLLATE "pg_catalog"."default",
  "background_check" int4
)
;
