import com.codeborne.selenide.ElementsCollection;
import org.junit.Test;
import pages.MainPage;
import pages.ProjectsPage;
import pages.elements.MainMenu;
import pages.elements.ProjectsFilterTypes;
import steps.Steps;

public class MaxilectTest {
    static int blockchainProjectsCount = 2;
    MainPage mainPage;
    ProjectsPage projectsPage;
    ElementsCollection filteredProjects;

    @Test
    public void redirectToBlockchainProjectsPage() {
        redirectToBlockchainProjectsPageFrom(MainMenu.class);
        redirectToBlockchainProjectsPageFrom(MainPage.class);
    }

    public void redirectToBlockchainProjectsPageFrom(Class classOfElement) {
        mainPage = Steps.openSite();
        if (classOfElement.equals(MainMenu.class)) projectsPage = Steps.openProjectsPageFrom(mainPage.mainMenu);
        else if (classOfElement.equals(MainPage.class)) projectsPage = Steps.openProjectsPageFrom(mainPage);
        filteredProjects = Steps.filterProjectsBy(projectsPage, ProjectsFilterTypes.BLOCKCHAIN);
        Steps.checkCountOfProjects(filteredProjects, blockchainProjectsCount);
    }
}
