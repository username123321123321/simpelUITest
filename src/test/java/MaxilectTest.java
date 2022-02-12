import com.codeborne.selenide.WebDriverRunner;
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
        open(baseUrl);
        $(byCssSelector(mainMenuProjectSelector)).click();
        assertEquals(projectsUrl + "/", WebDriverRunner.getWebDriver().getCurrentUrl());
        blockchainContentCheck();

        open(baseUrl);
        $(byCssSelector(allProjectsButtonSelector)).scrollIntoView(false);
        $(byCssSelector(allProjectsButtonSelector)).click();
        assertEquals(projectsUrl + "/", WebDriverRunner.getWebDriver().getCurrentUrl());
        blockchainContentCheck();
    }

    private void blockchainContentCheck() {
        $(byCssSelector(filterBlockchainSelector)).click();
        assertEquals(blockchainProjectsCount, $$(byCssSelector(blockchainPortfolioItemSelector)).size());
    }
}
