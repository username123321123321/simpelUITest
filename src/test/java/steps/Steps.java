package steps;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import pages.MainPage;
import pages.ProjectsPage;
import pages.elements.MainMenu;
import pages.elements.ProjectsFilterTypes;
import pages.elements.URLs;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class Steps {
    @Step("Открываем сайт")
    @Attachment
    public static MainPage openSite() {
        return open(URLs.baseUrl, MainPage.class);
    }

    @Step("Переходим на страницу проектов через Меню")
    @Attachment
    public static ProjectsPage openProjectsPageFrom(MainMenu mainMenu) {
        return mainMenu.openProjectsPage();
    }

    @Step("Переходим на страницу проектов через кнопку Все проекты")
    @Attachment
    public static ProjectsPage openProjectsPageFrom(MainPage mainPage) {
        return mainPage.openProjectsPage();
    }

    @Step("Фильтруем проекты по типу BLOCKCHAIN")
    @Attachment
    public static ElementsCollection filterProjectsBy(ProjectsPage projectsPage, ProjectsFilterTypes type) {
        return projectsPage.filterProjects(type).results();
    }

    @Step("Проверяем количество проектов")
    public static void checkCountOfProjects(ElementsCollection projects, int count) {
        assertEquals(count, projects.size());
    }
}
