import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws Exception {
        String url = "https://http.cat/" + code + ".jpg";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();
        connection.disconnect();

        if (responseCode == 200) {
            return url;
        } else if (responseCode == 404) {
            throw new Exception("There is no image for HTTP status " + code);
        } else {
            throw new Exception("Unhandled HTTP response status: " + responseCode);
        }
    }
}
