package userMoves;

import com.microsoft.playwright.*;

public class MouseHoverOverHandle {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        Page page = browser.newPage();
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
//        page.navigate("https://www.way2automation.com/");
        page.navigate("https://www.browserstack.com/guide/mouse-hover-in-selenium");

        Locator developers = page.locator("//*[@id=\"developers-dd-toggle\"]");

        developers.hover();
        Thread.sleep(2000);
        page.locator("//*[@id=\"developers-dd-menu\"]/div/div[1]/a/span").click();

        page.close();
        playwright.close();
        System.out.println("test is done ");
    }
}
