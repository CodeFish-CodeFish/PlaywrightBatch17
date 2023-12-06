package batch17;

import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;

public class HandleLinks {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();// to be able to use playwright you need to create it
        List<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        // To be able to open a browser you need browser object - to create a browser you need to use playwright obj
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));

        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        // you need browser object to open a page
        Page page = browserContext.newPage();
        page.navigate("https://www.wikipedia.org/");

//        Locator links = page.locator("a");

//        System.out.println(links.count());

//        for (int i = 0; i < links.count(); i ++){
//            System.out.println(links.nth(i).innerText() + " URL " + links.nth(i).getAttribute("href"));
//        }

        page.locator("#portalBanner_en6C_2023_4 > button").click();
        Thread.sleep(2000);


        Locator block = page.locator("#www-wikipedia-org > div.footer > div.other-projects");
        Locator links = block.locator("a");


        System.out.println(links.count());

        for (int i = 0; i < links.count(); i++) {
            System.out.println(links.nth(i).innerText() + " URL " + links.nth(i).getAttribute("href"));
        }
        Thread.sleep(2000);
        links.nth(0).click();
    }
}
