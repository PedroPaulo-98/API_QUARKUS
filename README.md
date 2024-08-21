# CREATE API using Quarkus + POST


## Running and using the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8081>.

> **_NOTE2:_**  Access the API to make get/post/put <http://localhost:8081/api/products>.


Body API in JSON:

```shell script
[
  {
    "name": "",
    "description": "",
    "category": "",
    "price": 1.00
]
```


