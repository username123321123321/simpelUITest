import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class MaxilectTest {
    String baseUrl = "https://maxilect.ru";
    String mainMenuProjectText = "Проекты";
    String blockchainTagText = "Blockchain";
    String allProjectsButtonText = "Все проекты";
    String projectsUrl = baseUrl + "/projects/";
    String blockchainPortfolioItemSelector = ".portfolio-item[data-filter='blockchain']";
    int blockchainProjectsCount = 2;

    @Test
    public void redirectToBlockchainProjectsPage() {
        open(baseUrl);
        $(byText(mainMenuProjectText)).click();
        assertEquals(projectsUrl, WebDriverRunner.getWebDriver().getCurrentUrl());
        blockchainContentCheck();

        open(baseUrl);
        $(byText(allProjectsButtonText)).scrollIntoView(false);
        $(byText(allProjectsButtonText)).click();
        assertEquals(projectsUrl, WebDriverRunner.getWebDriver().getCurrentUrl());
        blockchainContentCheck();
    }

    private void blockchainContentCheck() {
        $(byText(blockchainTagText)).click();
        assertEquals(blockchainProjectsCount, $$(byCssSelector(blockchainPortfolioItemSelector)).size());
    }
}
