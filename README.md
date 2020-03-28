# Step to run mybatisgenerator application

## Prerequisite ##
1. Create Databases "metadesign" in postgres
2. Create a table "Users" (execute DB_query.sql file)
3. update database URL, username and password inside application.properties (for each key inside it)
4. Install mybatisgenerator plug-in in eclipse

### Step to TEST the application ###
1. Download/Clone repository from here and import as maven project in eclipse. (Ignore compilation error)
2. right click on "Maven" -> "Update Project" (it will fetch new/updated dependencies to local repo)
2. right click on "generatorconfig.xml" go to "Run As" -> "Run MyBatis Generator" (It will create Java Model class and Java Mapper files and now you can see all compilation error resolved.)
3. Now run UserServiceTest.java as jUnit test.
