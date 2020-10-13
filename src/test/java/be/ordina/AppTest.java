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

    @Test
    public void successfulUserLogin() throws InterruptedException {
        driver.get("https://www.plex.tv/nl");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement signUpBtn = driver.findElement(By.xpath("//a[@class='signup button']"));
        signUpBtn.click();
        Thread.sleep(2000);
        driver.switchTo().frame("fedauth-iFrame");
        Thread.sleep(2000);
        WebElement emailInput = driver.findElement(By.id("email"));
        String email = getAlphanumericString(8) + "@mailinator.com";
        emailInput.sendKeys(email);
        Thread.sleep(2000);
        WebElement passwordInput = driver.findElement(By.id("password"));
        String password = "testPaswoord1";
        passwordInput.sendKeys(password);
        Thread.sleep(2000);
        WebElement formBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        formBtn.click();
        Thread.sleep(7000);
        // <span class="PageHeaderBreadcrumbButton-link-30Jgzu">Home</span>
        WebElement confirmationTextHome = driver.findElement(By.xpath("//span[contains(@class,'PageHeaderBreadcrumbButton')]"));
        Thread.sleep(7000);
        String messageHome = confirmationTextHome.getText();
        assertTrue(messageHome.contains("Home"));

    }
    static String getAlphanumericString(int n){
        // chose a character random from this string
        String AlphaNumericString = "ABCEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789" + "abcdefghijklmnopqrstuvwxyz";
        // create StringBuffer size of AlphaNumeriString
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i<n; i++){
            // generate a random number between 0
            // to AlphaNumericString variabele length
            int index = (int) (AlphaNumericString.length()
                    * Math.random() );
            // add character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

}
