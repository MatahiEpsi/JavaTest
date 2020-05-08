package pizza.spring.acceptanceTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzaSpringCommandAcceptanceTest {
    private WebDriver webDriver;

    @Before
    public void createWebDriver() {
        webDriver = new ChromeDriver();
    }

    @After
    public void closeWebDriver() {
        webDriver.quit();
    }

    @Test
    public void checkSeleniumDevSiteFoundInFirstPageOfDuckduckgo() throws Exception {
        ResultPage resultPage = CommandPage.openWith(webDriver)
                .enterPizzaId(1)
                .enterUserName("Matahi")
                .enterTelephone("0650754685")
                .validCommand();

        assertTrue("La pizza ne correspondant pas",resultPage.isPizzaPresent(1));
        assertTrue("Le nom d'utilisateur ne correspondant pas",resultPage.isUsernamePresent("Matahi"));
        assertTrue("Le numéro de téléphone ne correspondant pas",resultPage.isPhonePresent("0650754685"));
    }
}
