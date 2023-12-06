package batch17;

import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();// to be able to use playwright you need to create it
        List<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        // To be able to open a browser you need browser object - to create a browser you need to use playwright obj
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));

        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        // you need browser object to open a page
        Page page = browserContext.newPage();
        page.navigate("https://google.com");


        System.out.println(page.title());// this is our title

        page.navigate("https://udemy.com");
        Thread.sleep(2000);
        page.goBack();
        Thread.sleep(2000);
        page.goForward();
        page.reload(); //refresh
//        page.close();
//        playwright.close();

    }
}
