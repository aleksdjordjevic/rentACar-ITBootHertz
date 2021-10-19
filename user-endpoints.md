1. `/users/register` - *POST*
    - username и email морају бити јединствени
    - email мора бити валидан
    - username мора имати барем 3 карактера
    - password мора имати барем 8 карактера, 1 број и 1 слово
    - *password желимо да чувамо у бази енкриптован (на било који начин)
        - https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt

    ```js
    // Пример Request-a (Све се шаље кроз request body) - user_id се аутоматски генерише
    {
        "username": "Pera",
        "email": "peraperic@perica.com",
        "password": "nekasifra"
    }

    // Пример Response-a када је успешно регистрован
    {
        "successful": true,
        "message": "Pera - peraperic@perica.com је успешно регистрован"
    }

    // Пример Response-a када није успешно регистрован
    {
        "successful": false,
        "message": "Username је заузет" // Или било која друга порука грешке
    }
    ```

<div style="page-break-after: always;"></div>

2. `/users/login` - *POST*
    - Прослеђујемо или username или email 

    ```js
    // Пример Request-a (Све се шаље кроз request body)
    {
        "identification": "Pera", // Може и email
        "password": "nekasifra"
    }

    // Пример Response-a када је успешно пријављен
    {
        "successful": true,
        "info": "1AC977B1-FDAA-413C-99C4-F5D0571FE014" // id пријављеног корисника
    }

    // Пример Response-a када није успешно пријављен
    {
        "successful": false,
        "info": "Погрешан username/email или password"
    }
    ```

<div style="page-break-after: always;"></div>

3. `/users/{id}` - *PATCH*
    - Корисник сам мења на основу свог `id`-a
    - Мењају се све прослеђене информације за корисника 
        - Не можемо мењати email и personal_number (Те ствари мења директно администратор)
    - Водити рачуна о валидности добијених података
        - Радити `update` само валидних поља
    - Ако шифра није валидна, не радити `update` уопште

    ```js
    // Пример Request-a (Све се шаље кроз request body)
    {
        "username": "Ana1234",
        "password": "nekasifra",
        "new_password": "nekanovasifra",
        "first_name": "",
        "last_name": "",
        "phone_number": "",
        "image": ""
    }

    // Пример успешног Response-a
    {
        "successful": true,
        "info": "Changed ..." // Набројати промењена поља* (Није неопходно)
    }

    // Пример неуспешног Response-a
    {
        "successful": false,
        "info": "Password not valid"
    }
    ```

4. `/users/{id}` - *GET*
    - Дохватамо све информације о кориснику

    ```js
    // Пример Response-a када је id валидан
    {
        "username": "Ana1234",
        "email": "anaana@ana.com"
        "firstName": "...",
        "lastName": "...",
        "phoneNumber": "...",
        "personalNumber": "...",
        "image": "..."
    }
    ```

5. `/users` - *GET*
    - Дохвата листу свих корисника
    - Кроз header се прослеђује id админа - https://www.baeldung.com/spring-rest-http-headers

    ```js
    // Пример Response-a
    [
        {
            "username": "Ana1234",
            "email": "anaana@ana.com",
            "firstName": "...",
            "lastName": "...",
            "phoneNumber": "...",
            "personalNumber": "...",
            "image": "..."
        },
        {
            "username": "...",
            "email": "...",
            "firstName": "...",
            "lastName": "...",
            "phoneNumber": "...",
            "personalNumber": "...",
            "image": "..."
        }
    ]
    ```