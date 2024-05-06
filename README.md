## TASK 2

Application can be started with  

```
mvn spring-boot:run
```

For application to run we need MariaDB with created schema ```task2``` otherwise changes to application.properties are required. Also username and password should be changed.
```
spring.datasource.url=jdbc:mariadb://localhost:3306/task2?cachePrepStmts=true&useServerPrepStmts=true&rewriteBatchedStatements=true
spring.datasource.username=root
spring.datasource.password=root
```

Result is written to log, someting similar to this:
```
2024-05-06T14:13:21.109+02:00  INFO 104995 --- [paurus-task-1] [           main] si.primoz.App                            : Inserted 302536 records
2024-05-06T14:13:21.582+02:00  INFO 104995 --- [paurus-task-1] [           main] si.primoz.App                            : MIN timestamp: 2024-05-06T12:13:13.255554Z
2024-05-06T14:13:21.820+02:00  INFO 104995 --- [paurus-task-1] [           main] si.primoz.App                            : MAX timestamp: 2024-05-06T12:13:20.035807Z
2024-05-06T14:13:21.820+02:00  INFO 104995 --- [paurus-task-1] [           main] si.primoz.App                            : Duration: 5780 ms
```
