# Notification Service

Microservicio de notificaciones basado en eventos. Escucha eventos de usuario publicados en Kafka, envía emails transaccionales y registra cada notificación en base de datos.

## Arquitectura

```
Kafka (user.events)
       │
       ▼
UserKafkaEventConsumer
       │  (Avro + Schema Registry)
       ▼
  [Consumer específico]
       │  MapStruct
       ▼
   Command
       │  Mediator
       ▼
   Handler
       │
   ┌───┴───┐
   ▼       ▼
Email    PostgreSQL
(SMTP)  (registro)
```

El servicio sigue **Clean Architecture** y el patrón **CQRS**:

- `domain/` — entidades y puertos (sin dependencias externas)
- `application/` — handlers y commands (casos de uso)
- `infrastructure/` — adaptadores: Kafka, JPA, SMTP

## Eventos consumidos

| Topic | Evento | Acción |
|-------|--------|--------|
| `user.events` | `UserCreatedEvent` | Email de bienvenida + registro |
| `user.events` | `UserUpdatedEvent` | Email de actualización + registro |
| `user.events` | `UserDeletedEvent` | Email de despedida + registro |
| `user.events` | `UserPasswordUpdatedEvent` | Email de contraseña actualizada + registro |

Los esquemas Avro provienen del repositorio `kafka-spring-user-service` vía GitHub Packages.

## Requisitos

- Java 21
- Docker y Docker Compose
- Kafka + Confluent Schema Registry accesibles
- Acceso a GitHub Packages (`GH_PACKAGES_TOKEN`)

## Variables de entorno

| Variable | Descripción | Default |
|----------|-------------|---------|
| `DB_HOST` | Host de PostgreSQL | `localhost` |
| `DB_PORT` | Puerto de PostgreSQL | `5432` |
| `DB_NAME` | Nombre de la base de datos | `notification_db` |
| `DB_USER` | Usuario de PostgreSQL | `sricart` |
| `DB_PASSWORD` | Contraseña de PostgreSQL | — |
| `KAFKA_BOOTSTRAP_SERVERS` | Brokers de Kafka | `localhost:9092` |
| `SCHEMA_REGISTRY_URL` | URL del Schema Registry | `http://localhost:8081` |
| `MAIL_HOST` | Host SMTP | `sandbox.smtp.mailtrap.io` |
| `MAIL_PORT` | Puerto SMTP | `2525` |
| `MAIL_USERNAME` | Usuario SMTP | — |
| `MAIL_PASSWORD` | Contraseña SMTP | — |
| `MAIL_FROM` | Dirección remitente | `noreply@notification-service.com` |
| `SERVER_PORT` | Puerto HTTP del servicio | `8080` |

## Ejecución local

### 1. Levantar la base de datos

```bash
docker-compose up -d
```

### 2. Configurar credenciales de GitHub Packages

```xml
<!-- ~/.m2/settings.xml -->
<settings>
  <servers>
    <server>
      <id>sergioricart-commons</id>
      <username>TU_USUARIO</username>
      <password>TU_GH_TOKEN</password>
    </server>
    <server>
      <id>sergioricart-user-events</id>
      <username>TU_USUARIO</username>
      <password>TU_GH_TOKEN</password>
    </server>
  </servers>
</settings>
```

### 3. Arrancar el servicio

```bash
./mvnw spring-boot:run
```

## Tests

```bash
./mvnw clean test
```

Los tests son unitarios (JUnit 5 + Mockito) y no requieren Kafka ni base de datos activos.

## CI/CD

| Pipeline | Disparador | Acción |
|----------|------------|--------|
| CI | Pull Request → `main` / `development` | Ejecuta tests |
| CD | Merge → `main` / `development` | Tests + build + publish a GitHub Packages |

## Tecnologías

- **Java 21** + Spring Boot 3
- **Apache Kafka** + Avro + Confluent Schema Registry
- **Spring Data JPA** + PostgreSQL
- **Spring Mail** (SMTP)
- **MapStruct** + Lombok
- **Docker** + Docker Compose