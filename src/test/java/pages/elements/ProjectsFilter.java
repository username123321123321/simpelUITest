package pages.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;

public class ProjectsFilter extends PageElement {
    private static HashMap<ProjectsFilterTypes, SelenideElement> filterElementByType= new HashMap<>();
    private static HashMap<ProjectsFilterTypes, ElementsCollection> filteredProjectsByType= new HashMap<>();

    public ProjectsFilter() {
        filterElementByType.putIfAbsent(ProjectsFilterTypes.BLOCKCHAIN, Elements.filterBlockchainButton);
        filteredProjectsByType.putIfAbsent(ProjectsFilterTypes.BLOCKCHAIN, Elements.blockchainPortfolioItems);
    }

    public static ProjectsFilterResult filterByType(ProjectsFilterTypes type) {
        clickOn(filterElementByType.get(type));
        return new ProjectsFilterResult(filteredProjectsByType.get(type));
    }
}
