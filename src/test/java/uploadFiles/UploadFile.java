package uploadFiles;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadFile {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");

       Locator upLfile =  page.locator("#register_form > fieldset:nth-child(9) > input[type=file]");
       upLfile.setInputFiles(Paths.get("src/test/java/sql.pages"));

    }
}
