package screenRecord;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class VideoRecording {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));

        Page page = context.newPage();

        page.navigate("https://www.wikipedia.org/");

        page.locator("#www-wikipedia-org").click();
//select by value
        Thread.sleep(5000);
        page.selectOption("select", "hi");

        Thread.sleep(5000);
    }
}
