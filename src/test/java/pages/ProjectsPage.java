package pages;

import pages.elements.ProjectsFilter;
import pages.elements.ProjectsFilterResult;
import pages.elements.ProjectsFilterTypes;

public class ProjectsPage extends BasePage {
    public static final ProjectsFilter filter = new ProjectsFilter();

    public ProjectsFilterResult filterProjects(ProjectsFilterTypes byType) {
        return filter.filterByType(byType);
    }
}
