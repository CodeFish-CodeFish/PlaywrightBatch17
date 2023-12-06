package batch17;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.options.LoadState;

public class IframeHandle {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        int retryCount = 3;
        int retry = 0;
        while (retry < retryCount) {
            try {
                page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
                page.waitForLoadState(LoadState.LOAD);
                break;  // Successful navigation, exit the loop
            } catch (Exception e) {
                System.out.println("Timeout error, retrying...");
                retry++;
            }
        }

        FrameLocator frameLocator = page.frameLocator("[name='iframeResult']");

        frameLocator.
                locator("body > button").click(new ClickOptions().setTimeout(30000));

        System.out.println(page.frameLocator("[name='iframeResult']").locator("#demo").innerText());

        Locator frame = page.locator("iframe");
        System.out.println(frame.count());

        for (int i = 0; i < frame.count(); i++) {

            System.out.println(frame.nth(i).getAttribute("id"));
        }

    }
}
