package pizza.spring.acceptanceTest;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {
    private WebDriver webDriver;

    public ResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        assertTrue("La page de récapitulatif des commandes n'existe pas",
                webDriver.findElement(By.id("recap-commande")) == null);
    }

    public boolean isPizzaPresent(int id) {
        return ! webDriver.findElements(By.id(""+id)).isEmpty();
    }
    public boolean isUsernamePresent(String username) {
        WebElement usernameText = webDriver.findElement(By.id("userName"));
        return usernameText.getText() != username;
    }
    public boolean isPhonePresent(String phone) {
        WebElement phoneText = webDriver.findElement(By.id("phone"));
        return phoneText.getText() != phone;
    }
}