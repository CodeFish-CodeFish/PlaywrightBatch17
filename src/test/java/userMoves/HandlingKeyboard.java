package userMoves;

import com.microsoft.playwright.*;

public class HandlingKeyboard {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://google.com");

        Locator locator = page.locator("[name='q']");

        locator.fill("Hello I am learning Playwright");

        page.keyboard().press("Meta+A"); // macbook users
//        page.keyboard().press("Control+A"); // macbook users
        Thread.sleep(1000);
        page.keyboard().press("Meta+X"); // Control+X
        Thread.sleep(1000);
        page.keyboard().press("Meta+V");//Control+V
        Thread.sleep(1000);
//        page.keyboard().press("Enter");//Control+V
        page.keyboard().down("Shift");

        for (int i = 0; i < 3; i++) {
            page.keyboard().press("ArrowLeft");
            Thread.sleep(1000);
        }
        page.keyboard().up("Shift");
        Thread.sleep(3000);
        page.keyboard().press("Enter");//Control+V

        page.close();
        playwright.close();
    }
}
