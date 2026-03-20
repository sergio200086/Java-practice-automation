package api;

import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UserApiClient {

    private static final HttpClient client = HttpClient.newHttpClient();
    private static final String apiKey = System.getenv("REQRES_API_KEY") != null
            ? System.getenv("REQRES_API_KEY")
            : Dotenv.load().get("REQRES_API_KEY");

    public static String createUser(String name, String job) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users"))
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(
                        "{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}"
                ))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(response.body());

        return  json.getString("id");
    }

    public static String getUser(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users/"+id ))
                .header("x-api-key", apiKey)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject data = new JSONObject(response.body()).getJSONObject("data");

        return data.getString("first_name") + " " + data.getString("last_name");
    }

}
