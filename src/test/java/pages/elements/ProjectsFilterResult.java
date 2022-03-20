package pages.elements;

import com.codeborne.selenide.ElementsCollection;

public class ProjectsFilterResult {
    private ElementsCollection result;

    public ProjectsFilterResult(ElementsCollection result) {
        this.result = result;
    }

    public ElementsCollection results() {
        return result;
    }
}
