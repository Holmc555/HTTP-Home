import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws Exception {
        HttpStatusChecker checker = new HttpStatusChecker();
        String imageUrl = checker.getStatusImage(code);

        try (InputStream in = new URL(imageUrl).openStream();
             FileOutputStream out = new FileOutputStream(code + ".jpg")) {
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new Exception("Failed to download the image: " + e.getMessage());
        }
    }
}
