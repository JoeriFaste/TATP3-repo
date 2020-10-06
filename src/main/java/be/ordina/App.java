package be.ordina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
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


        if(message.contains("\"username\"")){
            System.out.println("SUCCESS!");
        }else{
            System.out.println("FAILURE!");
        }



        //driver.quit();
    }
}
