1. `/contracts/sample` - *POST*
    - Враћа нацрт уговора који клијент може да потпише и пошаље на одобравање
    - Ако корисник 

    ```js
    // Пример Request-a
    {
        "userId": "1AC977B1-FDAA-413C-99C4-F5D0571FE014",
        "carId": "39B750AB-505C-4DDE-8C99-D9633010C8A2",
        "startDate": "...",
        "endDate": "..."
    }

    // Пример Response-a
    {
        "userId": "1AC977B1-FDAA-413C-99C4-F5D0571FE014",
        "carId": "39B750AB-505C-4DDE-8C99-D9633010C8A2",
        "startDate": "2021-10-11", // YYYY-MM-DD
        "endDate": "2021-10-21",
        "totalPrice": 550.99,
        "signed": false
    }
    ```

<div style="page-break-after: always;"></div>

2. `/contracts` - *POST*
    - Додаје нови уговор (Клијент)
    - Ово је нека врста резервације датума за клијента
    - Након овога, администратор или одбија или одобрава
        - Одбијање уговора значи брисање из базе (описано касније)
    - Клијент може да има највише један уговор на чекању

    ```js
    // Пример Request-a (approved се аутоматски ставља на false)
    // contract_id се такође аутоматски поставља
    {
        "userId": "1AC977B1-FDAA-413C-99C4-F5D0571FE014",
        "carId": "39B750AB-505C-4DDE-8C99-D9633010C8A2",
        "startDate": "2021-10-11", // YYYY-MM-DD
        "endDate": "2021-10-21",
        "totalPrice": 550.99,
        "signed": true
    }

    // Пример Response-a - успешно
    {
        "successful": true,
        "info": "Уговор креиран, чека одобрење"
    }

    // Пример Response-a - неуспешно
    {
        "successful": false,
        "info" "Уговор није креиран, ..." // Већ је заузет аутомобил или user већ има уговор који чека одобрење
    }
    ```

<div style="page-break-after: always;"></div>

3. `/contracts` - *GET*
    - Администратори могу да виде све уговоре
    - Кроз header се прослеђује id админа - https://www.baeldung.com/spring-rest-http-headers

    ```js
    // Пример Response-a
    [
        {
            "contractId": "F3249839-44C2-4775-92BA-23BE7F66F8C7",
            "userId": "1AC977B1-FDAA-413C-99C4-F5D0571FE014",
            "carId": "39B750AB-505C-4DDE-8C99-D9633010C8A2",
            "startDate": "2021-10-11", // YYYY-MM-DD
            "endDate": "2021-10-21",
            "totalPrice": 550.99,
            "signed": true,
            "approved": false
        },
        {
           // ...
        }
    ]
    ```

4. `/contracts/pending` - *GET*
    - Администратори могу да виде све неразрешене уговоре
    - Кроз header се прослеђује id админа - https://www.baeldung.com/spring-rest-http-headers
    - Враћа исто као пример изнад, али само уговоре који имају approved постављено на false

5. `/contracts/{contractId}/approval` - *POST*
    - Администратор одобрава или одбија уговор
        - Ако га одбије - уговор се брише из базе
        - Ако га одобри - Уговор добија approved = true
    - Кроз header се прослеђује id админа - https://www.baeldung.com/spring-rest-http-headers

    ```js
    // Пример Request-a када је одобрен - У бази треба променити поље approved у true
    {
        "approved": true
    }

    // Пример Request-a када је одбијен - Из базе треба избрисати contract са тим id-јем
    {
        "approved": false
    }
    ```

6. `/contracts/{userId}/history` - *GET*
    - Дохвата се историја уговора за клијента са датим id

    ```js
    // Пример Response-a
    [
        {
            "contractId": "F3249839-44C2-4775-92BA-23BE7F66F8C7",
            "userId": "1AC977B1-FDAA-413C-99C4-F5D0571FE014",
            "carId": "39B750AB-505C-4DDE-8C99-D9633010C8A2",
            "startDate": "2021-10-11", // YYYY-MM-DD
            "endDate": "2021-10-21",
            "totalPrice": 550.99,
            "signed": true,
            "approved": true
        },
        {
           // ...
        }
    ]
    ```


