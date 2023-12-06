package batch17;

import com.microsoft.playwright.*;

public class PopUpHandle {
    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://sso.teachable.com/secure/673/identity/sign_up/email");

        Locator privicyPolicy = page.locator("text=Privacy Policy");

        Page popup = page.waitForPopup(() -> {
            privicyPolicy.nth(0).click();
        });

        popup.locator("//*[@id=\"header-sign-up-btn\"]").click();

        Thread.sleep(1000);

        popup.locator("//html/body/main/div/form/div[1]/button").click();

        popup.locator("//*[@id=\"user_name\"]").fill("codefish");

        page.locator("//*[@id=\"user_name\"]").fill("backTomainPage");

    }
}
