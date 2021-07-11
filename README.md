# Web applications for adding data from XML to the table of organizations
### Expected XML format
```
<organiztions>
	<organiztion>
		<id>1</id>
		<name>Scelerisque Neque Sed Ltd</name>
		<email>auctor@sagittis.edu</email>
	</organiztion>
</organiztions>
```
### Expected table in database
| id  | name | email |
| ------------- | ------------- |-------------|
| 1 | Scelerisque Neque Sed Ltd  | auctor@sagittis.edu |
| 2  | Nullam Suscipit Inc.  | lorem.auctor@iaculisenim.co.uk |

Where **id** is the unique digital code of the organization
### Setup
Specify the data to connect to the database in [application.properties](https://github.com/mezzong/xml-to-db/blob/main/src/main/resources/application.properties)

---
### Demo application UI
Home page
![alt text](https://i.ibb.co/xSkWpzW/p1.jpg "Index page")

Result on successful execution
![alt text](https://i.ibb.co/fD2rhqC/p2.jpg "Result page")

Error page
![alt text](https://i.ibb.co/NCvgt75/p3.jpg "Error page")



