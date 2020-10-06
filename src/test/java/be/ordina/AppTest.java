package be.ordina;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private WebDriver driver;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void successfulLoginWithUser() throws InterruptedException {

        driver.get("http://aqua-training.westeurope.cloudapp.azure.com:8080/training-app-0.0.1-SNAPSHOT/");

        WebElement btnAccount = driver.findElement(By.id("account-menu"));
        btnAccount.click();

        WebElement BtnLogin = driver.findElement(By.id("login"));
        BtnLogin.click();

        WebElement tbUsername = driver.findElement(By.name("username"));
        tbUsername.sendKeys("username");

        WebElement tbPassword = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        tbPassword.sendKeys("password");
        tbPassword.submit();

        /*WebElement btnSignIn = driver.findElement(By.cssSelector("body > ngb-modal-window > div > div > jhi-login-modal > div.modal-body > div > div:nth-child(2) > form > button"));
        btnSignIn.click();*/

        Thread.sleep(2000);
        WebElement textLoginConfirm = driver.findElement(By.id("home-logged-message"));
        String message = textLoginConfirm.getText();

        String username = "username";
        assertTrue("the message <" + message + "> doesn't contain the right username <" + username + ">", message.contains(username));

    }
}
