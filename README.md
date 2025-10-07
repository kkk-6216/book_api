REST API для учёта книг, читателей и выдачи книг в библиотеке

Стек технологий
     1. Java 17
     2. Spring Boot 3
     3. Spring Data JPA
     4. PostgreSQL - в качестве базы данных
     5. MapStruct — для преобразования
     6. Hibernate Validation — для валидации
     7. Springdoc OpenAPI (Swagger UI) — для документации API
     8. Lombok — для сокращения шаблонного кода
     9. Maven — управление зависимостями

Инструкция по запуску:
1. Клонировать
git clone https://github.com/kkk-6216/book_api.git
cd book_api

2. Создать базу данных (В нашем случае PgSQL):
CREATE DATABASE book_api;
либо через интейфейс

3. Настроить application.yml, а именно:
        username
        password
        url (в случае если создали базу другим именем)

4. Запуск приложения
   Если консоль то : mvn spring-boot:run
   Либо через интерфейс IDE

5. Проект доступен по http://localhost:8080
6. Также тест: http://localhost:8080/swagger-ui/index.html

Описание по API:
Книги (/books)
POST	     /books	     Добавить новую книгу
GET	     /books	     Получить список всех книг
GET	     /books/{id}	Получить книгу по ID
PUT	     /books/{id}	Обновить данные книги
DELETE	/books/{id}	Удалить книгу

Читатели (/readers)
POST	     /readers	     Зарегистрировать читателя
GET	     /readers	     Получить список всех читателей
GET	     /readers/{id}	Получить читателя по ID

Выдачи (/loans)
POST	     /loans	               Выдать книгу читателю
POST	     /loans/{id}/return	     Вернуть книгу
GET	     /loans	               Список всех выдач

Реализовано:
1. CRUD для Book
2. CRUD для Reader
3. Выдача и возврат книги (Loan)
4. Валидация (@NotNull, @Email, @Size)
5. Обработка ошибок через @ControllerAdvice
6. HTTP-коды: 400, 404, 409
7. MapStruct для маппинга
8. Swagger подключил

Не реализовано и планы на доработку:
1. Добавить миграции с Flyway
2. Добавить юнит-тесты для сервисов (LoanService)
3. Добавить Dockerfile и Docker compose
4. остальное за рамками требований (например, безопастность, поиск и т.д.)



