import org.junit.jupiter.api.Test;
import com.asuna.launcher.utils.Downloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Created by Eleria on 07/01/2017.
 */
public class DownloaderTest {
    @Test
    public void testDownloader() {
        Logger LOGGER = Logger.getLogger("DownloadTest");
        try {
            Downloader.download(new URL("https://raw.githubusercontent.com/Asuna-Project/core/master/README.md"),
                    new File("./Readme.MD"));

        } catch (Exception ex) {
            fail("Downloader Failed with " + ex.getMessage());
        }
        try {
            File file = new File("./Readme.MD");
            if (file.delete()) {
                LOGGER.log(Level.INFO, file.getName() + " is deleted!");
                return;
            } else {
                LOGGER.log(Level.INFO, "Delete operation is failed.");
                fail("Failed to delete Test File");
            }
        }
        catch(Exception e){

        fail("Failed with Deleting File " + e.getMessage());
    }

    }
}
