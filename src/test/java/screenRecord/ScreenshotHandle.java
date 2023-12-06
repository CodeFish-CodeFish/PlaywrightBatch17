package screenRecord;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class ScreenshotHandle {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");

//        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./screenshots/screenshot.png"))); Whole page
        page.locator("[name='search']")
                .screenshot(new Locator.ScreenshotOptions()
                        .setPath(Paths.get("./screenshots/screenshot.png"))); // single element



    }
}
