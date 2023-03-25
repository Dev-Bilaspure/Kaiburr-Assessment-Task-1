# Kaiburr-Assessment-By-Dev-B
This is a Spring Boot application.

## REST API Endpoints
This project provides REST API endpoints to manage server documents.
### Endpoints
#### Get all servers
- URL: `/api/servers`
- Method: GET
- Description: Returns a list of all server documents.

#### Get server by ID
- URL: `/api/servers/{serverId}`
- Method: GET
- Description: Returns a server document by its ID.

#### Get server by name
- URL: `/api/servers/name/{name}`
- Method: GET
- Description: Returns a server document by its name.

#### Add server
- URL: `/api/servers`
- Method: POST
- Description: Adds a new server document.

#### Update server
- URL: `/api/servers`
- Method: PUT
- Description: Updates an existing server document.

#### Update server
- URL: `/api/servers/{serverId}`
- Method: DELETE
- Description: Deletes a server document by its ID.

### Request and Response
- All requests and responses are in JSON format.

#### Server document example

```json
{
  "serverId": "1",
  "name": "Server1",
  "framework": "Spring",
  "language": "Java"
}
```

