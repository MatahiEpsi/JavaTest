package pizza.spring.acceptanceTest;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class CommandPage {
    private WebDriver webDriver;

    public CommandPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public CommandPage open() {
        webDriver.navigate().to("http://localhost:8080/pizza_spring_war/commande");
        assertTrue("Titre de page inattendu " + webDriver.getTitle(),
                webDriver.getTitle().startsWith("DuckDuckGo"));
        return this;
    }

    public static CommandPage openWith(WebDriver webDriver) {
        CommandPage homePage = new CommandPage(webDriver);
        homePage.open();
        return homePage;
    }

    public CommandPage enterPizzaId(int id) {
        WebElement pizzaInput = webDriver.findElement(By.id("pizzaId"));
        Select selectInput = new Select(webDriver.findElement(By.id("pizzaId")));
        selectInput.selectByIndex(id);
        return this;
    }
    public CommandPage enterUserName(String username) {
        WebElement userNameInput = webDriver.findElement(By.id("nom"));
        userNameInput.sendKeys(String.join(" ", username));
        return this;
    }
    public CommandPage enterTelephone(String phone) {
        WebElement phoneInput = webDriver.findElement(By.id("telephone"));
        phoneInput.sendKeys(String.join(" ", phone));
        return this;
    }

    public ResultPage validCommand() {
        WebElement commandButton = webDriver.findElement(By.id("bouton.commande"));
        commandButton.click();
        return new ResultPage(webDriver);
    }

}
