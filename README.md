# 📌 Kotlin + Spring Boot 게시판 API 프로젝트

이 프로젝트는 **Kotlin**과 **Spring Boot**를 사용하여 제작된 간단한 **게시판 REST API 백엔드**입니다.  
MySQL과 연동되며, CRUD 기능과 예외 처리, 유효성 검증 기능이 포함되어 있습니다.

---

## 📁 프로젝트 구조

```
📦backend
 ┣ 📂src/main/kotlin/com/example/backend
 ┃ ┣ 📜BackendApplication.kt         ← 애플리케이션 메인 실행 클래스
 ┃ ┣ 📜Post.kt                      ← 게시글 Entity 정의
 ┃ ┣ 📜PostRepository.kt            ← JPA Repository 인터페이스
 ┃ ┣ 📜PostController.kt            ← 게시글 CRUD API 컨트롤러
 ┃ ┣ 📜User.kt                      ← 사용자 예시 모델
 ┃ ┣ 📜UserController.kt            ← 사용자 예시 컨트롤러
 ┃ ┣ 📜GlobalExceptionHandler.kt    ← 전역 예외 핸들러
 ┣ 📂resources
 ┃ ┗ 📜application.properties       ← DB 설정, JPA 설정 등
 ┣ 📜build.gradle.kts               ← Gradle 빌드 스크립트
 ┗ 📜README.md
```

---

## ⚙️ 사용 기술

- **Language**: Kotlin
- **Framework**: Spring Boot 3.4.5
- **Database**: MySQL 8.0
- **ORM**: Spring Data JPA
- **Build Tool**: Gradle (Kotlin DSL)
- **Validation**: Hibernate Validator
- **Test Tool**: Postman

---

## 📌 주요 기능

| 메소드 | URL | 설명 |
|--------|-----|------|
| GET    | `/posts` | 게시글 전체 조회 |
| GET    | `/posts/{id}` | 특정 게시글 조회 |
| POST   | `/posts` | 게시글 생성 |
| PUT    | `/posts/{id}` | 게시글 수정 |
| DELETE | `/posts/{id}` | 게시글 삭제 |

---

## ✅ DB 연동 설정

### MySQL 설정 예시
```sql
CREATE DATABASE testdb;
```

### application.properties
```properties
spring.application.name=backend
spring.datasource.url=jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=Asia/Seoul
spring.datasource.username=root
spring.datasource.password=1234
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

> 환경에 따라 username, password, DB명은 변경하세요.

---

## ▶️ 실행 방법

1. Gradle 빌드
```bash
./gradlew build
```

2. Spring Boot 실행
```bash
./gradlew bootRun
```

3. 접속
[http://localhost:8080](http://localhost:8080)

---

## 🔎 Postman 테스트 예시

### 게시글 생성
- URL: `POST /posts`
- Body (JSON):
```json
{
  "title": "첫 게시글",
  "content": "내용입니다"
}
```

### 게시글 조회
- URL: `GET /posts/1`

---

## ⚠️ 예외 처리

- `@Valid`로 유효성 검사
- 전역 예외 처리 `GlobalExceptionHandler` 구현
- 존재하지 않는 게시글 요청 시 404 응답 반환

---

## 🧑‍💻 Git 커밋 이력

- MySQL 연동 및 JPA 설정
- Post Entity 및 API CRUD 구현
- 유효성 검증 및 예외 처리 적용
- README 및 Git 설정

---

## 🙋‍♂️ 만든 사람

- **김민수 (kimmi)**
- 2025.05.01 개발 시작
