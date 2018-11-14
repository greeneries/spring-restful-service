# spring-restful-service



#### GET

요청방식 : `GET`
URL : `http://localhost:8080/emps`

응답결과
```json
{
    "status": "Success",
    "message": null,
    "data": [
        {
            "id": 1,
            "firstName": "Adam",
            "lastName": "Sandler"
        },
        {
            "id": 2,
            "firstName": "Bob",
            "lastName": "Ross"
        },
        {
            "id": 3,
            "firstName": "Chris",
            "lastName": "Evans"
        }
    ],
    "errorCode": null,
    "errorMessage": null
}
```

#### POST

요청방식 : `POST`
URL : `http://localhost:8080/emps`
Content-Type : `application/json`
Body(raw) : 
```json
{
    "id": 0,
    "firstName": "Seokwon",
    "lastName": "Song"
}
```

응답결과
```json
{
    "status": "Success",
    "message": null,
    "data": {
        "id": 4,
        "firstName": "Seokwon",
        "lastName": "Song"
    },
    "errorCode": null,
    "errorMessage": null
}
```

변화를 한번 더 확인해 보고 싶다면 다시 GET을 요청해 보자.

#### DELETE

요청방식 : `DELETE`
URL : `http://localhost:8080/emps/4`

응답결과
```json
{
    "status": "Success",
    "message": null,
    "data": null,
    "errorCode": null,
    "errorMessage": null
}
```

변화를 한번 더 확인해 보고 싶다면 다시 GET을 요청해 보자.

#### PUT

요청방식 : `PUT`
URL : `http://localhost:8080/emps/3`
Content-Type : `application/json`
Body(raw) : 
```json
{
    "id": 3,
    "firstName": "Seokwon",
    "lastName": "Song"
}
```

응답결과
```json
{
    "status": "Success",
    "message": null,
    "data": {
        "id": 3,
        "firstName": "Seokwon",
        "lastName": "Song"
    },
    "errorCode": null,
    "errorMessage": null
}
```
