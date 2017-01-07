import com.asuna.launcher.utils.Downloader;
import org.junit.jupiter.api.Test;
import com.asuna.launcher.utils.HashChecker;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Created by Eleria on 07/01/2017.
 */
public class TestHasher {
    @Test
    public void testHasher(){
        try {
            Downloader.download(new URL("https://raw.githubusercontent.com/Asuna-Project/core/master/README.md"), new File("./Readme.MD"));
        }
        catch (Exception ex){
            fail("Couldnt download TEst FIle");
        }
        File file = new File("./Readme.MD");
        try {
            String checksum = HashChecker.checkHash(file);
            System.out.println(checksum);
            return;
        }catch (IOException ex){
            System.out.println(ex.getMessage());
            fail("Couldnt get Hash");
        }
        file.delete();

    }
}
