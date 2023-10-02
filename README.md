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
- Search person by name, wether they are on sanctioned list, returns single instance

### GET /sanctioned/
- Get all sanctioned persons list, paginated
   
### GET /sanctioned/{id}
- Get info about snactioned person by id

### POST /sanctioned
```
{
  "name" : "String",
  "reason" : "String",
  "activeFrom" : "2022-04-22T00:00:00.000+00:00",
}
```
### PATCH /sanctioned/{id}
- Update sanctioned person by id

### DELETE /sanctioned/{id}
- Delete sanctioned person (adds timestamp to deleted_at column in database)

# Missing features

If I had taken more time then I would have implemented:

- Security
- Proper error handling
- Tests
- Caching
- Automated API Docs

