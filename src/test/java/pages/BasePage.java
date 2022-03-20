package pages;

import pages.elements.Footer;
import pages.elements.MainMenu;
import pages.elements.PageElement;

public abstract class BasePage extends PageElement {
    public static MainMenu mainMenu;
    public static Footer footer;

    public BasePage() {
        this.mainMenu = new MainMenu();
        this.footer = new Footer();
    }

    public BasePage(MainMenu mainMenu, Footer footer) {
        this.mainMenu = mainMenu;
        this.footer = footer;
    }
}
