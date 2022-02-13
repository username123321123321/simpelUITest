import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class MaxilectTest {
    String baseUrl = "https://maxilect.ru";
    String projectsUrl = baseUrl + "/projects";
    String mainMenuProjectSelector = "li#menu-item-89";
    String filterBlockchainSelector = ".filter[data-filter='blockchain']";
    String allProjectsButtonSelector = "div.Load-More a[href='" + projectsUrl + "']";
    String blockchainPortfolioItemSelector = ".portfolio-item[data-filter='blockchain']";
    int blockchainProjectsCount = 2;


    @Test
    public void redirectToBlockchainProjectsPage() {
        openSite();
        clickOnProjectsInMenu();
        blockchainContentCheck();

        openSite();
        clickOnProjectsInMainPage();
        blockchainContentCheck();
    }

    @Step("Открываем сайт")
    @Attachment
    private void openSite() {
        open(baseUrl);
    }

    @Step("Проверка фильтрации проектов по тегу Blockchain")
    @Attachment
    private void blockchainContentCheck() {
        $(byCssSelector(filterBlockchainSelector)).click();
        assertEquals(blockchainProjectsCount, $$(byCssSelector(blockchainPortfolioItemSelector)).size());
    }

    @Step("Кликаем на Проекты в меню")
    @Attachment
    private void clickOnProjectsInMenu() {
        $(byCssSelector(mainMenuProjectSelector)).click();
        assertEquals(projectsUrl + "/", WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    @Step("Кликаем на Все проекты на главной странице")
    @Attachment
    private void clickOnProjectsInMainPage() {
        $(byCssSelector(allProjectsButtonSelector)).scrollIntoView(false);
        $(byCssSelector(allProjectsButtonSelector)).click();
        assertEquals(projectsUrl + "/", WebDriverRunner.getWebDriver().getCurrentUrl());
    }
}
