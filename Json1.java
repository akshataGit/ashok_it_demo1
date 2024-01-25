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
