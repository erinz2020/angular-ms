# House Cost Calculator

A minimal sample project that demonstrates:

- How an Angular frontend submits a form
- How a Spring Boot backend exposes a REST API
- How the backend connects to SQL Server and saves calculation records

## Project Structure

```text
house-cost-calculator/
  frontend/              Angular page
  backend/               Spring Boot API
  docker-compose.yml     Local SQL Server
```

## Start SQL Server

```bash
docker compose up -d
docker exec -i house-cost-sqlserver /opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P 'YourStrong!Passw0rd' -C -i /docker-entrypoint-initdb.d/init.sql
```

Default connection:

- Host: `localhost`
- Port: `1433`
- Database: `HouseCostDb`
- User: `sa`
- Password: `YourStrong!Passw0rd`

## Start Backend

```bash
cd backend
mvn spring-boot:run
```

Backend URL: `http://localhost:8080`

If your SQL Server image does not include `/opt/mssql-tools18/bin/sqlcmd`, run `docker/sqlserver/init.sql` with Azure Data Studio or SQL Server Management Studio.

## Start Frontend

```bash
cd frontend
npm install
npm start
```

Frontend URL: `http://localhost:4200`

## API

### POST `/api/costs/calculate`

Request example:

```json
{
  "landArea": 300,
  "buildingArea": 180,
  "floors": 2,
  "constructionCostPerSqm": 1600,
  "permitRate": 0.03,
  "utilityFee": 8000,
  "inspectionFee": 2500
}
```

Response example:

```json
{
  "id": 1,
  "baseConstructionCost": 288000,
  "permitFee": 8640,
  "utilityFee": 8000,
  "inspectionFee": 2500,
  "totalCost": 307140
}
```
