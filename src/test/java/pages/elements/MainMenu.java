package pages.elements;

import com.codeborne.selenide.SelenideElement;
import pages.ProjectsPage;

import static org.junit.Assert.assertEquals;

public class MainMenu extends PageElement{
    public static SelenideElement logo;
    public static SelenideElement solutions;
    public static SelenideElement clients;
    public static SelenideElement projects = Elements.mainMenuProjectButton;
    public static SelenideElement process;
    public static SelenideElement carrier;
    public static SelenideElement blog;
    public static SelenideElement forStartup;
    public static SelenideElement lang;

    public ProjectsPage openProjectsPage() {
        clickOn(projects);
        assertEquals(URLs.projectsUrl + "/", driver.getCurrentUrl());
        return new ProjectsPage();
    }
}
