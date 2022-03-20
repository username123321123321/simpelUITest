package pages;

import com.codeborne.selenide.SelenideElement;
import pages.elements.Elements;
import pages.elements.URLs;

import static org.junit.Assert.assertEquals;

public class MainPage extends BasePage {
    SelenideElement allProjectsButton = Elements.allProjectsButton;

    public ProjectsPage openProjectsPage() {
        scrollTo(allProjectsButton, false);
        clickOn(allProjectsButton);
        assertEquals(URLs.projectsUrl + "/", driver.getCurrentUrl());
        return new ProjectsPage();
    }
}
