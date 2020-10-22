
import okhttp3.HttpUrl;
import org.fastily.jwiki.core.Wiki;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class UploadImage {

    public static void main(String[] s) {
        Wiki wiki = new Wiki.Builder()
                .withApiEndpoint(
                        HttpUrl.parse("https://kailasapedia.org/api.php")
                ).withLogin("Admin@ImageUpload", "jak9e92urqltebqsfpuao28jh1jecada")
                .build();

        String dirpath = "/repo/images/";
        var dir = new File(dirpath);

        ArrayList<String> images = new ArrayList<>(Arrays.asList(Objects.requireNonNull(dir.list())));

        images.parallelStream().forEach(image -> {
            boolean result = wiki.upload(Path.of(dirpath + image), "File:" + image, image, "image upload");
            if(!result)
                System.out.println("Failed for: " + image);
        });
    }
}