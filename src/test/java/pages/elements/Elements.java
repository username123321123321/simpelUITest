package pages.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Elements {
    public static final SelenideElement mainMenuProjectButton = $(byCssSelector(Selectors.mainMenuProjectSelector));
    public static final SelenideElement filterBlockchainButton = $(byCssSelector(Selectors.filterBlockchainSelector));
    public static final SelenideElement allProjectsButton = $(byCssSelector(Selectors.allProjectsButtonSelector));
    public static final ElementsCollection blockchainPortfolioItems = $$(byCssSelector(Selectors.blockchainPortfolioItemSelector));
}
