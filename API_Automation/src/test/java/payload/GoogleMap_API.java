package payload;

import java.util.ArrayList;

import pojos.AddAPI_location;
import pojos.Add_API;

public class GoogleMap_API {

	public Add_API AddPlace_API(String name, String language, String address) {
			
		Add_API obj = new Add_API();
		obj.setAccuracy(80);
		obj.setAddress(address);
		obj.setLanguage(language);

		AddAPI_location loc = new AddAPI_location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		obj.setLocation(loc);

		obj.setName(name);
		obj.setPhone_number("(+91) 983 893 3937");

		// here we are creating a arraylist and passing the value or adding the value to
		// it.
		ArrayList<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		obj.setTypes(types);

		obj.setWebsite("http://google.com");

		return obj;
	}
}
