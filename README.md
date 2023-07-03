# expense-tracker-rest-api

This project taught me the following:
- how to set up a Spring project from scratch
- add MongoDB as a database
- create a rest API with Spring Boot

## How set up:
clone this repository:
```shell
gh repo clone s-dousse/expense-tracker-rest-api
```

Ensure you [Java](https://www.java.com/en/download/help/index_installing.html), [Maven](https://formulae.brew.sh/formula/maven) and [MongoDB](brew services stop mongodb-community@6.0) installed

start you db:
```shell
brew services stop mongodb-community@6.0
```

From your IDE (I used IntelliJ IDEA)
compile with `mvn compile` (ensure you have no compiler errors) and run SpringBootMongodbTutorialApplication.java as a simple Java application and stop it. This will generate the seed data
your logs should look similar to this:
```shell
2023-07-03T21:06:44.136+01:00  INFO 2420 --- [           main] i.m.r.core.executor.ChangeExecutorBase   : APPLIED - {"id"="changeWithoutArgs", "type"="execution", "author"="mongock", "class"="DatabaseChangeLog", "method"="seedDatabase"}
2023-07-03T21:06:44.162+01:00  INFO 2420 --- [           main] i.m.driver.core.lock.LockManagerDefault  : Mongock waiting to release the lock
2023-07-03T21:06:44.162+01:00  INFO 2420 --- [           main] i.m.driver.core.lock.LockManagerDefault  : Mongock releasing the lock
2023-07-03T21:06:44.185+01:00  INFO 2420 --- [           main] i.m.driver.core.lock.LockManagerDefault  : Mongock released the lock
2023-07-03T21:06:44.185+01:00  INFO 2420 --- [           main] i.m.r.c.e.o.migrate.MigrateExecutorBase  : Mongock has finished
```

compile (you should not get any compilation error) and start the server
```shell
mvn spring-boot:run 
```

## How to use:
You can use Postman or cURL to manually test this api,yay

1. See all the expenses:
GET http://localhost:8080/api/expense
```shell
[
    {
        "id": "64a3291504f81d6c4ae5e65a",
        "expenseName": "Audible sub",
        "expenseCategory": "ENTERTAINEMENT",
        "expenseAmount": 9
    },
    {
        "id": "64a32a548bccd804bfb245b5",
        "expenseName": "My local Veggie Shop",
        "expenseCategory": "GROCERIES",
        "expenseAmount": 14.87
    },
    {
        "id": "64a32a548bccd804bfb245b6",
        "expenseName": "MyGym Yay",
        "expenseCategory": "ENTERTAINEMENT",
        "expenseAmount": 45
    },
    {
        "id": "64a32a548bccd804bfb245b7",
        "expenseName": "Little Sicily",
        "expenseCategory": "RESTAURANT",
        "expenseAmount": 35.6
    },
    {
        "id": "64a32a548bccd804bfb245b8",
        "expenseName": "Broadband",
        "expenseCategory": "UTILITIES",
        "expenseAmount": 40
    },
    {
        "id": "64a32a548bccd804bfb245b9",
        "expenseName": "Subscription I forgot to cancel",
        "expenseCategory": "MISCELLANEOUS",
        "expenseAmount": 15
    }
]
```

2. See a specific Expense (by name)
GET http://localhost:8080/api/expense/{name}

3. Create a new expense
POST http://localhost:8080/api/expense
with body params as json
```
{   
    "ExpenseName": "Saturday pottery class",
    "ExpenseCateory": "ENTERTAINEMENT",
    "ExpenseAmount": 42
}
```

4. Update an expense
PUT http://localhost:8080/api/expense/
with body params as json
```
{
    "expenseName": "Spinning class",
    "expenseCategory": "MISCELLANEOUS",
    "expenseAmount": 15
 }
```

5. Delete an expense
DELETE http://localhost:8080/api/expense/{id}




Tutorial by [programmingtechie](https://github.com/SaiUpadhyayula) 👏
