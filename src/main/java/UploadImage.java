
import okhttp3.HttpUrl;
import org.fastily.jwiki.core.Wiki;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class UploadImage {

    public static void main(String[] s) {
        Wiki wiki = new Wiki.Builder()
                .withApiEndpoint(
                        HttpUrl.parse("https://kailasapedia.org/api.php")
                ).withLogin("Admin@ImageUpload", "jak9e92urqltebqsfpuao28jh1jecada")
                .build();

        ArrayList<String> images = new ArrayList<>(
                Arrays.asList("2016-5may-2nd-nithyananda-diary_IMG_6811_ujjain-aadheenam-kumbh-mela-shivoham-process-swamiji.jpg")
                );

        images.parallelStream().forEach(image -> {
            boolean result = wiki.upload(Path.of("/repo/" + image), "File:" + image, image, "image upload");
            if(!result)
                System.out.println("Failed for: " + image);
        });
    }
}