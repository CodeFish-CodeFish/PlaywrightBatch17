package batch17;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;


public class TestGen {

 public static void main(String[] args) {

         try (Playwright playwright = Playwright.create()) {
             Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                     .setHeadless(false));
             BrowserContext context = browser.newContext();
             Page page = context.newPage();
             page.navigate("https://demo.playwright.dev/todomvc/");
             page.navigate("https://demo.playwright.dev/todomvc/#/");
             page.navigate("https://www.google.com/");
             page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).click();
             page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).fill("Hello kitty ");
             page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).click();
         }
    }
}
