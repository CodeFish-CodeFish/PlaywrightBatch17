package batch17;

import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;

public class AlertsHandle {
    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        List<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");

        Browser browser = playwright.chromium().launch(new BrowserType
                .LaunchOptions().setHeadless(false).setArgs(arguments));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browserContext.newPage();
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(40000);

        page.click("[onclick='jsAlert()']");

        Thread.sleep(5000);

        page.onDialog(dialog -> {
        dialog.accept();
        });

        System.out.println(page.locator("#result").innerText());
    }
}
