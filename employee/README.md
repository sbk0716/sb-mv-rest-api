# sb-mvn-rest-api

## Run Spring Application

1. mvn command
```sh
admin@gw-mac employee % mvn spring-boot:run
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< com.example:employee >------------------------
[INFO] Building employee 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
...
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  25.103 s
[INFO] Finished at: 2022-08-31T17:28:47+09:00
[INFO] ------------------------------------------------------------------------
admin@gw-mac employee % 
```

2. java command
```sh
admin@gw-mac employee % mvn package                                  
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< com.example:employee >------------------------
[INFO] Building employee 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
...
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.590 s
[INFO] Finished at: 2022-08-31T17:27:09+09:00
[INFO] ------------------------------------------------------------------------
admin@gw-mac employee % 
admin@gw-mac employee % java -jar target/employee-0.0.1-SNAPSHOT.jar
...
...
^C2022-08-31 17:30:14.463  INFO 7885 --- [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
2022-08-31 17:30:14.464  INFO 7885 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2022-08-31 17:30:14.467  INFO 7885 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
admin@gw-mac employee % 
```
