Feature: Google Maps API 

Scenario Outline: Adding a Placenusing AddPlaceAPI 

	Given Add Place payload "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" using "POST" http request 
	Then API call is success with status code 200 
	And "status" in response body is "OK" 
	
	Examples: 
	
		| name |language | address|
		|Umakanth| Englis|Lakshmipuram|
		|Chandrahas|Spanish|Lakshmipuram|