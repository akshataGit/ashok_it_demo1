
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        String jsonString = "{\"coffee\":{\"region\":[{\"id\":1,\"name\":\"John Doe\"},{\"id\":2,\"name\":\"Don Joeh\"}],\"country\":{\"id\":2,\"company\":\"ACME\"}},\"brewing\":{\"region\":[{\"id\":1,\"name\":\"John Doe\"},{\"id\":2,\"name\":\"Don Joeh\"}],\"country\":{\"id\":2,\"company\":\"ACME\"}}}";

        JSONObject jsonObject = new JSONObject(jsonString);

        // Find the "country" object with id 2 in "coffee" and "brewing"
        JSONObject countryObject = jsonObject
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals("coffee") || entry.getKey().equals("brewing"))
                .map(entry -> ((JSONObject) entry.getValue()).getJSONObject("country"))
                .filter(country -> country.getInt("id") == 2)
                .findFirst()
                .orElse(null);

        if (countryObject != null) {
            String company = countryObject.getString("company");
            System.out.println("Company for id 2 in country: " + company);
        } else {
            System.out.println("Country with id 2 not found.");
        }
    }
}
























====================================================
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParsingExample {

    public static void main(String[] args) {
        // Assuming the JSON string is provided
        String jsonString = "{ \"coffee\": { \"region\": [ { \"id\":1 , \"name\": \"John Doe\" }, { \"id\": 2, \"name\": \"Don Joeh\" } ], \"country\":{ \"id\": 2, \"company\": \"ACME\" } }, \"brewing\": { \"region\": [ { \"id\": 1, \"name\": \"John Doe\" }, { \"id\": 2, \"name\": \"Don Joeh\" } ], \"country\": { \"id\": 2, \"company\": \"ACME\" } } }";

        // Parse the JSON string
        JSONObject jsonObject = new JSONObject(jsonString);

        // Navigate to the 'coffee' section
        JSONObject coffeeSection = jsonObject.getJSONObject("coffee");

        // Navigate to the 'country' object inside the 'coffee' section
        JSONObject countryObject = coffeeSection.getJSONObject("country");

        // Extract the company value where id is 2
        if (countryObject.getInt("id") == 2) {
            String company = countryObject.getString("company");
            System.out.println("Company for id 2 in country: " + company);
        }
    }
}



import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        String jsonString = "{\"data\":[{\"MainId\":1111,\"firstName\":\"Sherlock\",\"lastName\":\"Homes\",\"categories\":[{\"CategoryID\":1,\"CategoryName\":\"Example\"}]},{\"MainId\":122,\"firstName\":\"James\",\"lastName\":\"Watson\",\"categories\":[{\"CategoryID\":2,\"CategoryName\":\"Example2\"}]}],\"messages\":[],\"success\":true}";

        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray dataArray = jsonObject.getJSONArray("data");

        // Find the object with MainId 122
        JSONObject targetObject = dataArray
                .toList()
                .stream()
                .filter(obj -> ((JSONObject) obj).getInt("MainId") == 122)
                .map(JSONObject::new)
                .findFirst()
                .orElse(null);

        if (targetObject != null) {
            JSONArray categoriesArray = targetObject.getJSONArray("categories");
            JSONObject categoryObject = categoriesArray.getJSONObject(0);
            String categoryName = categoryObject.getString("CategoryName");
            System.out.println("Category Name for MainId 122: " + categoryName);
        } else {
            System.out.println("MainId 122 not found in the data.");
        }
    }
}




<dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20210307</version> <!-- Or the latest version available -->
</dependency>
