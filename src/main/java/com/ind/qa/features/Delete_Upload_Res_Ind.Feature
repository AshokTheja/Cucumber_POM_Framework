Feature: Ind App Delete Upload Resume Automation 

Scenario: JobSeeker Logsin into the application with Valid creds 

	#Login
	Given JobSeeker opens Browser and navigates to Application 
	When JobSeeker is on LoginPage 
	And JobSeeker enters username and password and clicks on login 
	Then JobSeeker is on FindJobs page 
	
	#Navigate to Profile Page and decide to upload / not upload the reusme
	Given JobSeeker click on Account Menu and clicks on Profile 
	When JobSeeker navigates to Ind_Resume page 
	Then JobSeeker validates and decides to upload the resume or not 
	
	#Logout
	Given JobSeeker will navigate to FindJobs page 
	Then JobSeeker Logsout and closes the browser 
	
