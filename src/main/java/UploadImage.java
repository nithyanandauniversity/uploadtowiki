
import okhttp3.HttpUrl;
import org.fastily.jwiki.core.Wiki;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class UploadImage {

    public static void main(String[] s) {
        Wiki wiki = new Wiki.Builder()
                .withApiEndpoint(
                        HttpUrl.parse("https://kailasapedia.org/api.php")
                ).withLogin("Admin@ImageUpload", "jak9e92urqltebqsfpuao28jh1jecada")
                .build();

        String[] images = {"2016-5may-2nd-nithyananda-diary_IMG_6811_ujjain-aadheenam-kumbh-mela-shivoham-process-swamiji.jpg"};

        for (String image : images) {
            wiki.upload(Path.of("/repo/" + image), "File:" + image, image, "image upload");
        }
    }
}