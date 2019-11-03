## Spring Postgres Notifications 
How to subscribe to notifications in Spring app on database change via [Reactive PostgreSQL client](https://github.com/eclipse-vertx/vertx-sql-client/tree/3.8/vertx-pg-client).

## What it does
1. Runs docker container with postgres db. 
2. Creates and seeds table `users`
3. Creates trigger on table `users` on CREATE/UPDATE operations
4. Subscribes to notifications on `user_update` topic from Postgres
5. Every time table `users` is appended/updated from *any* source (even manual command execution), Spring app 
receives 
this event 
and 
prints it to stdout
## Tech/framework used
- [Spring](https://spring.io/projects/spring-boot)
- [Kotlin](https://kotlinlang.org/)
- [Docker](https://www.docker.com/)
- [Postgres](https://www.postgresql.org/) with [reactive-pg-client](https://github.com/eclipse-vertx/vertx-sql-client/tree/3.8/vertx-pg-client)
- [Gradle](https://gradle.org/)


## Installation
1. Install Docker
2. Install Java 8+
3. Install Gradle
4. Clone project to local machine.

## How to use?
1. Go to project root directory.  
2. Run `docker-compose up -d` to init container with database.  
3. Run `gradle bootRun` in terminal to start project.  
Or [import and run project in IntelliJ IDEA](https://www.jetbrains.com/help/idea/running-applications.html)

4. Connect to database: 
    - host: `localhost`  
    - port: `54320`  
    - db name: `postgres`  
    - username: `postgres` 
    - password: `test` 
    
    In [resources/data.sql](https://github.com/pavelgordon/spring-postgres-reactive-pg-client/blob/master/src/main/resources/data.sql) you can find already created users.

5. Make some changes in `users`, e.g. execute this SQL query:  
`update users set role='test1' where first_name = 'Pavel'`

6. In terminal you will see message like:  
`user has been updated {"operation" : "UPDATE", "user" : {"id":1,"first_name":"Pavel","last_name":"Gordon","role":"test1"}}`

7. Run `docker-compose down` to tear down container with database.
