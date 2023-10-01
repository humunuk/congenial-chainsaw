# Dependancies
 - Java 17
 - Docker
 - Maven

# Getting started

```
./mvnw spring-boot:run
```

# Endpoints

### GET /sanctioned/search?name={name}
### GET /sanctioned/
### GET /sanctioned/{id}
### POST /sanctioned
```
{
  "name" : "String",
  "reason" : "String",
  "activeFrom" : "2022-04-22T00:00:00.000+00:00",
}
```
### PATCH /sanctioned/{id}
### DELETE /sanctioned/{id}

# Missing features

If I had taken more time then I would have implemented:

- Security
- Proper error handling
- Tests
- Caching
- Automated API Docs

