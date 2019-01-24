Feature: feature description 
Scenario: scenario description 
	Login Profresh
	Given open browser And Enter URL 
	And move mouse to Login 
	When I enter valid username and password for Login 
		|username|password|
		|priyanka.mane@coditas.com|password|
	Then I can able to Login successfully 
	Given Click on Account Information tab and update the contact details 
	When I update the 
		|mobile_number|company website|Insta ID|
		|0453567656|www.test.com|test@123|
	Then click on save button 
	Then Contact details successfully updated. 
	
	
	
	
	
	
