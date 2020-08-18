package payload;

public enum AddPlace_enum {

	
	AddPlaceAPI("maps/api/place/add/json"),
	GetPlaceAPI("maps/api/place/get/json"),
	DeletePlaceAPI("maps/api/place/delete/json");

	private String resource_url;
	
	AddPlace_enum(String resource_url) {
		this.resource_url = resource_url;
	}
	
	public String Resource_url(){
		return resource_url;
	}
}
