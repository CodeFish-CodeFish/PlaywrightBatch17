package userMoves;

import com.microsoft.playwright.*;

public class SliderHandle {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://jqueryui.com/resources/demos/slider/default.html");

        Thread.sleep(2000);

        Locator slider = page.locator("//*[@id=\"slider\"]/span");

        page.mouse().move(slider.boundingBox().x + slider.boundingBox().width / 2,slider.boundingBox().y + slider.boundingBox().height / 2 );
        page.mouse().down();

        page.mouse().move(slider.boundingBox().x + 500,0 );
        page.mouse().up();



    }
}
