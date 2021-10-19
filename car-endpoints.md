1. `/cars` - *GET*
    - Враћа све аутомобиле

    ```js
    // Пример Response-a
    [
        {
            "carId": "39B750AB-505C-4DDE-8C99-D9633010C8A2"
            "licencePlate": "NI-XXXX-YY"
            "make": "Honda",
            "model": "Civic",
            "year": 2018
            "engineCapacity": 1498,
            "color": "Aegean Blue Metallic"
            "price": 51.99,
            "doors": 4,
            "size": "M",
            "power": 174,
            "automatic": true,
            "fuel": "Gasoline",
            "image": "..."
        },
        ...
    ]

    ```

2. `/cars/search` - *GET*
    - Query параметри:
        - year - int - Више или једнако
        - make - string - Да ли садржи неки текст
        - model - string
        - automatic - boolean
        - price - double - Мање или једнако прослеђеној вредности
        - power - int - Мање или једнако
        - doors - int

    https://www.baeldung.com/spring-request-param

    ```js
    // Враћа исто као у примеру изнад, али само ако су услови испуњени
    // !Важно! - Клијент не мора да проследи све параметре
    ```

<div style="page-break-after: always;"></div>

3. `/cars/{carId}` - *GET*
    - Дохвата информације о једном аутомобилу

    ```js
    // Пример Response-a
    {
        "carId": "39B750AB-505C-4DDE-8C99-D9633010C8A2"
        "licencePlate": "NI-XXXX-YY"
        "make": "Honda",
        "model": "Civic",
        "year": 2018
        "engineCapacity": 1498,
        "color": "Aegean Blue Metallic"
        "price": 51.99,
        "doors": 4,
        "size": "M",
        "power": 174,
        "automatic": true,
        "fuel": "Gasoline",
        "image": "..."
    }
    
    ```

4. `/cars/{carId}` - *PATCH*
    - Мења аутомобил (Ово може да ради само администратор)
    - Кроз header се прослеђује id админа - https://www.baeldung.com/spring-rest-http-headers

    ```js
    // Пример Request-a
    {
        "licencePlate": "NI-XXXX-YY"
        "make": "Honda",
        "model": "Civic",
        "year": 2018
        "engineCapacity": 1498,
        "color": "Aegean Blue Metallic"
        "price": 51.99,
        "doors": 4,
        "size": "M",
        "power": 174,
        "automatic": true,
        "fuel": "Gasoline",
        "image": "..."
    }
    ```




<div style="page-break-after: always;"></div>

5. `/cars/{carId}` - *DELETE*
    - Брише аутомобил са датим id - (Само админ)
    - Кроз header се прослеђује id админа - https://www.baeldung.com/spring-rest-http-headers

6. `/cars` - *POST*
    - Додаје нови аутомобил - (Само админ)
    - Кроз header се прослеђује id админа - https://www.baeldung.com/spring-rest-http-headers

    ```js
    // Пример Request-a (Напомена: id се аутоматски генерише, UUID random)
    {
        "licencePlate": "NI-XXXX-YY"
        "make": "Honda",
        "model": "Civic",
        "year": 2018
        "engineCapacity": 1498,
        "color": "Aegean Blue Metallic"
        "price": 51.99,
        "doors": 4,
        "size": "M",
        "power": 174,
        "automatic": true,
        "fuel": "Gasoline",
        "image": "..."
    }
    ```



7. `/cars/available?` - *GET*
    - Дохвата све доступне аутомобиле
    - `startDate` и `endDate` се прослеђују као query параметри

8. `/cars/available/search?` - *GET*
    - Дохвата све доступне аутомобиле
    - `startDate` и `endDate` се прослеђују као query параметри (обавезни)
    - Query параметри који нису обавезни:
        - year - int - Више или једнако
        - make - string - Да ли садржи неки текст
        - model - string
        - automatic - boolean
        - price - double - Мање или једнако прослеђеној вредности
        - power - int - Мање или једнако
        - doors - int

<div style="page-break-after: always;"></div>

9. `/cars/{carId}/calendar` - *GET*
    - Враћа листу свих датума који нису доступни за одређени аутомобил
    - Ову информацију имамо у уговорима
        - Чак и ако нису одобрени уговори, те датуме сматрамо заузетим

    ```js
    // Пример Response-a
    [
        "2021-11-01",
        "2021-11-02",
        "2021-11-03",
        "2021-11-04",
        "2021-11-05",
        "2021-11-06",
        "2021-12-10",
        "2021-12-11",
        "2021-12-12",
        "2021-12-13",
        "2021-12-14"
    ]
    ```


