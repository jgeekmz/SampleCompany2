# SampleCompany2

Test Scenarios:

Test Case Create Computer:
curl -d "{\"id\": 1,\"computerName\": \"PC01\",\"macAddress\": \"TT:45:G6:36:AB\",\"ipAddress\": \"192.168.0.1\",\"employeeAbbreviation\": \"zla\",\"description\": \"Test Postman Case\"}" -H "Content-Type: application/json" http://localhost:8080/api//computers/createPC

curl -d "{\"id\": 2,\"computerName\": \"PC02\",\"macAddress\": \"TT:45:G6:36:AB\",\"ipAddress\": \"192.168.0.1\",\"employeeAbbreviation\": \"zla\",\"description\": \"Test Postman Case\"}" -H "Content-Type: application/json" http://localhost:8080/api//computers/createPC

curl -d "{\"id\": 3,\"computerName\": \"PC02\",\"macAddress\": \"TT:45:G6:36:AB\",\"ipAddress\": \"192.168.0.1\",\"employeeAbbreviation\": \"zla\",\"description\": \"Test Postman Case\"}" -H "Content-Type: application/json" http://localhost:8080/api//computers/createPC

curl -d "{\"id\": 4,\"computerName\": \"PC03\",\"macAddress\": \"TT:45:G6:36:AB\",\"ipAddress\": \"192.168.0.1\",\"employeeAbbreviation\": \"zla\",\"description\": \"Test Postman Case\"}" -H "Content-Type: application/json" http://localhost:8080/api//computers/createPC

curl -d "{\"id\": 5,\"computerName\": \"PC04\",\"macAddress\": \"TT:45:G6:36:AB\",\"ipAddress\": \"192.168.0.1\",\"employeeAbbreviation\": \"idi\",\"description\": \"Test Postman Case\"}" -H "Content-Type: application/json" http://localhost:8080/api//computers/createPC

curl -d "{\"id\": 6,\"computerName\": \"PC05\",\"macAddress\": \"TT:45:G6:36:AB\",\"ipAddress\": \"192.168.0.1\",\"employeeAbbreviation\": \"kka\",\"description\": \"Test Postman Case\"}" -H "Content-Type: application/json" http://localhost:8080/api//computers/createPC

Test Case: Create Employee wit one pc:
curl -d "{\"id\": 1,\"firstname\": \"Test\",\"lastname\": \"Test Emp\",\"description\": \"Test\",\"computersToEmployee\": [{\"id\": 1,\"computerName\": \"PC01\",\"macAddress\": \"TT:45:G6:36:AB\",\"ipAddress\": \"192.168.0.1\",\"employeeAbbreviation\": \"zla\",\"description\": \"Test Postman Case\"}]}" -H "Content-Type: application/json" http://localhost:8080/api/employees/createEmployee

curl -d "{\"id\": 2,\"firstname\": \"Test 2\",\"lastname\": \"Test Emp\",\"description\": \"Test\",\"computersToEmployee\": [{\"id\": 2,\"computerName\": \"PC01\",\"macAddress\": \"TT:45:G6:36:AB\",\"ipAddress\": \"192.168.0.1\",\"employeeAbbreviation\": \"zla\",\"description\": \"Test Postman Case\"},{\"id\": 3,\"computerName\": \"PC02\",\"macAddress\": \"TT:45:G6:36:AB\",\"ipAddress\": \"192.168.0.1\",\"employeeAbbreviation\": \"zla\",\"description\": \"Test Postman Case\"}"]}" -H "Content-Type: application/json" http://localhost:8080/api/employees/createEmployee
