# Task-1-Kaiburr-Assessment
#### This reposity is for Task 1 from the Kaiburr's Assessment submitted by Dev Bilaspure.


## REST API Endpoints
This project provides REST API endpoints to manage server documents.
### Endpoints
#### Get list of all servers
- URL: `/api/servers`
- Method: GET
- Description: Returns a list of all server documents.
- Screenshot of API Request from Insomnia client tool:
![getAllServers](screenshots/getAllServer.png)

#### Get server by ID
- URL: `/api/servers/{serverId}`
- Method: GET
- Description: Returns a server document by its ID.
- Screenshot of API Request from Insomnia client tool:
![getServerByID](screenshots/getServerByID.png)

#### Get list of servers by name
- URL: `/api/servers/name/{name}`
- Method: GET
- Description: Returns a list servers document by name.
- Screenshot of API Request from Insomnia client tool:
  ![getServersByName](screenshots/getServerName.png)

#### Add server
- URL: `/api/servers`
- Method: POST
- Description: Adds a new server document.
- Screenshot of API Request from Insomnia client tool:
  ![addANewServer](screenshots/addServer.png)

#### Update server
- URL: `/api/servers`
- Method: PUT
- Description: Updates an existing server document.
- Screenshot of API Request from Insomnia client tool:
  ![updateAnExistingServer](screenshots/updateAServer.png)

#### Delete server
- URL: `/api/servers/{serverId}`
- Method: DELETE
- Description: Deletes a server document by its ID.
- Screenshot of API Request from Insomnia client tool:
  ![deleteAServerByID](screenshots/deleteAServer.png)

### Request and Response
- All requests and responses are in JSON format.

#### Server document example

```json
{
	"_id": "641f19379f849b5cc399c25d",
	"name": "payments-server",
	"language": "C#",
	"framework": ".NET"
}
```

