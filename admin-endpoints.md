1. `/admin/update/{id}` - *PATCH*
    - Администраторско мењање корисника са `id`-јем из путање
    - Водити рачуна о валидности добијених података
        - Радити `update` само валидних поља
    - Кроз header се прослеђује id админа - https://www.baeldung.com/spring-rest-http-headers

    ```js
    // Пример Request-a (Све се шаље кроз request body)
    {
        "username": "Ana1234",
        "email": "nekinoviemail@lala.com"
        "firstName": "",
        "lastName": "",
        "phoneNumber": "",
        "personalNumber": "2606987123654"
        "image": ""
    }

    // Пример Response-a
    {
        "successful": true,
        "info": "Changed ..." // Набројати промењена поља* (Није неопходно)
    }
    ```