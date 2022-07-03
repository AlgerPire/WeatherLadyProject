import com.google.gson.*;
import com.squareup.okhttp.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.GetWeatherInformation;
import model.SpecifiedInformation;

@Data
@NoArgsConstructor


public class HttpTest {
    public static final String BASE_URL = "http://api.weatherstack.com";
    public static final String ACCESS_KEY = "c1192590413603096f0ba5a889ac77cc";

    public SpecifiedInformation getWeatherDataFromApi(String city) {
        try {
            // Create http client
            OkHttpClient client = new OkHttpClient();

            // Set URL and parameters
            HttpUrl.Builder urlBuilder
                    = HttpUrl.parse(BASE_URL + "/current").newBuilder();

            // Set query parameters
            urlBuilder.addQueryParameter("access_key", ACCESS_KEY);
            urlBuilder.addQueryParameter("query", city);

            String url = urlBuilder.build().toString();

            // Build request and execute
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Call call = client.newCall(request);
            Response response = call.execute();

            // Convert response to String
            String sResponse = response.body().string();

            // Convert String to our class model
            Gson gson = new Gson();
            GetWeatherInformation getWeatherInformation = gson.fromJson(sResponse, GetWeatherInformation.class);

            System.out.println(" City is: "+city+" \n Temperature: "+getWeatherInformation.getCurrent().getTemperature()+" °C "+
                    "\n Wind Direction: "+getWeatherInformation.getCurrent().getWind_dir()
                    +"\n Wind Speed: "+getWeatherInformation.getCurrent().getWind_speed()+" km/h");
            // Return class model
            return  getWeatherInformation.getCurrent();
        } catch (Exception e) {
            System.out.println("* Something went wrong while retrieving weather data. *");
        }

        return null;
    }

}
