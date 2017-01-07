import org.junit.jupiter.api.Test;
import com.asuna.launcher.utils.Downloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Created by Eleria on 07/01/2017.
 */
public class DownloaderTest {
    @Test
    public void testDownloader(){
        try {
            Downloader.download(new URL("https://raw.githubusercontent.com/Asuna-Project/core/master/README.md"),
                    new File("./Readme.MD"));
            return;
        }
        catch (Exception ex){
            fail("Downloader Failed with " + ex.getMessage());
        }
        File file = new File("./Readme.MD");
        file.delete();


    }
}
