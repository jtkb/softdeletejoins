This Spring-Boot example requires a MariaDB/MySQL DB available on the localhost port 3306. A database named 'Test' should be created and can be populated with tables using the file `database.sql` located under the `resources` folder.

1. Build the application with:

    `mvn clean install`

2. The application can then be executed from the target directory with the command:

   `java -jar softdeletejoins-1.0.0-SNAPSHOT.jar`

3. Using the swagger interface on `http://localhost:8080/swagger-ui.html`  Employees and Departments can be created:

   `POST http://localhost:8080/departments`:
{
  "deleted": false,
  "name": "Physics"
}

    `POST http://localhost:8080/employees`:
{
  "deleted": false,
  "name": "Dr. No"
}

4. Employees can then be associated or dis-associated from a department using the PATCH APIs and providing their DB record ID. Provide the COMPLETE set of IDs that are to be associated with a department. E.g. to first associate Employees ID 1 & 2 provide the `memberIds` array as [1,2]. To then REMOVE Employee ID #2 provide the array [1]. Inspecting the `DEPARTMENT_EMPLOYEE` table at this point with reveal a soft-deleted record that associates department #1 with employee #2.There are TWO APIs available so as to demonstrate the hard deletion of join-records.

    Associate Employee ID #1 with Department ID #1:

    `PATCH http://localhost:8080/departments/{id}`:
{
  "id": 1,
  "memberIds": [
    1
  ]
}

5. To demonstrate the hard deletion call the 'harddelete' PATCH API with an empty `memberIds` array:

    `PATCH http://localhost:8080/departments/{id}/harddelete`:
{
  "id": 1,
  "memberIds": [
    
  ]
}

6. Inspect the `DEPARTMENT_EMPLOYEE` table and the previous join(s) record between `Department` and `Employee` that were marked as NOT deleted are now HARD deleted. This behaviout would appear to be inconsistent with that exhibited in step 4 above.
