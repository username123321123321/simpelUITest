package pages.elements;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

public abstract class PageElement {
    public static WebDriver driver;

    public PageElement() {
        this.driver = WebDriverRunner.getWebDriver();
    }

    public PageElement(WebDriver driver) {
        this.driver = driver;
    }

    public static void scrollTo(SelenideElement el, Boolean isIntoView) {
        el.scrollIntoView(isIntoView);
    }

    public static void clickOn(SelenideElement el) {
        el.click();
    }

    public static void clickOn(SelenideElement el, ClickOptions clickOptions) {
        el.click(clickOptions);
    }
}
