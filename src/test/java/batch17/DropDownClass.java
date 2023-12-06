package batch17;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.util.ArrayList;
import java.util.List;

public class DropDownClass {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();// to be able to use playwright you need to create it
        List<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        // To be able to open a browser you need browser object - to create a browser you need to use playwright obj
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));

        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        // you need browser object to open a page
        Page page = browserContext.newPage();
        page.navigate("https://www.wikipedia.org/");

        List<ElementHandle> elementHandles = page.querySelectorAll("select > option");
        System.out.println(elementHandles.size());

        for (ElementHandle value: elementHandles) {
            System.out.println(value.innerText() + " ---------- " + value.getAttribute("lang"));
        }
//        page.selectOption("select", "Latina");// by value
//        page.selectOption("select", "Latina");// by text
//        page.selectOption("select", new SelectOption().setLabel("Euskara"));// by text
//        page.selectOption("select", new SelectOption().setIndex(1));// by text
//        Locator locators = page.locator("select > option");
//        System.out.println(locators.count());
//        List<String> languages = new ArrayList<>();
//        for (int i = 0; i < locators.count(); i++) {
////            System.out.println(locators.nth(i).innerText() + "-------" +
////                    locators.nth(i).getAttribute("lang"));
//            String valueOfTheLang = locators.nth(i).innerText();
//            languages.add(valueOfTheLang);
//            System.out.println(languages.get(i));
//        }
//



    }
}
