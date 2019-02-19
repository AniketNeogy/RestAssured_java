var faker = require('faker')

function generateMockAPI(){
	var Users = []
	var Admins = []
	var Clients = []
	var userCount = 100
	var clientCount = 25
	var adminCount = 10
	for (var id = 0; id < userCount; id++){
		
		var firstName = faker.name.firstName();
		var lastName = faker.name.lastName();
		var email = faker.internet.email();
		var designation = faker.name.jobTitle();
		var phoneNumber = faker.name.phoneNumber;
		var companyName = faker.company.companyName();
		var department = faker.commerce.department();
		var Address = [];
		var Skills = [];
		var streetName = faker.address.streetName();
		var streetAddress = faker.address.streetAddress();
		var country = faker.address.country();
		var city = faker.address.city();
		var state = faker.address.state();
		var zipCode = faker.address.zipCode();
		var Permanent_Address = {
						"Address Line1": streetName,
						"Address Line2": streetAddress,
						"City": city,
						"State": state,
						"Country" : country,
						"zipCode" : zipCode
						};
						
		var streetName1 = faker.address.streetName();
		var streetAddress1 = faker.address.streetAddress;
		var country1 = faker.address.country();
		var city1 = faker.address.city();
		var state1 = faker.address.state();
		var zipCode1 = faker.address.zipCode();
		var Temporary_Address = {
						"Address Line1": streetName1,
						"Address Line2": streetAddress1,
						"City": city1,
						"State": state1,
						"Country" : country1,
						"zipCode" : zipCode1
						};
		if(id%2==0){
		Skills.push("Java", "DevOps", "Python");
		}
		else{
		Skills.push("Java", "Selenium", "Rest Assured","Selenium");
		}
		
		
		
		Address.push({"Permanent Address" : Permanent_Address,
					  "Temporary Address" : Temporary_Address});
		
		Users.push({
			"id": "User" +"-" + id,
			"first_name" : firstName,
			"last_name" : lastName,
			"email" : email,
			"companyName" : companyName,
			"department" : department,
			"designation" : designation,
			"phoneNumber" : phoneNumber,
			"Address": Address,
			"Skills" : Skills,
			"message" : department+" department user data."
		})
	}
	for (var id = 0; id < clientCount; id++){
		var clientName = faker.company.companyName();
		var clientOfficeAddress = faker.address.secondaryAddress() + " , " + faker.address.city()+ " , " + faker.address.state()+ " , " + faker.address.country();
		var clientCountry = faker.address.country();
		var portfolio = faker.finance.account();
		var contactInfo = faker.internet.email();
		var clientContactNumber = faker.phone.phoneNumber();
		
		Clients.push({
			"id": "Client" +"-" + id,
			"Name" : clientName,
			"portfolio" : portfolio,
			"country" : clientCountry,
			"email" : contactInfo,
			"phoneNumber" : clientContactNumber,
			"Address": clientOfficeAddress,
			"message" : "Client data successfully retrieved."
		})
	}
	
	for (var id = 0; id < adminCount; id++){
		var firstName = faker.name.firstName();
		var lastName = faker.name.lastName();
		var email = faker.internet.email();
		var Permanent_Address = {
						"Address Line1": faker.address.streetName(),
						"Address Line2": faker.address.streetAddress(),
						"City": faker.address.city(),
						"State": faker.address.state(),
						"Country" : faker.address.country(),
						"zipCode" : faker.address.zipCode()
						};
		Admins.push({
			"id": "Adm" +"-" + id,
			"firstName" : firstName,
			"lastName" : lastName,
			"email" : email,
			"Address": Permanent_Address,
			"message" : "Admin data successfully retrieved."
		})
	}
	
	return{"Users" : Users, "Clients" : Clients, "Admins" : Admins}
}

module.exports = generateMockAPI