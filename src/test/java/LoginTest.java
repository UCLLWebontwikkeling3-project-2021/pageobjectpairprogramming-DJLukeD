/*
 * @author Lukas De Ruysscher
 */

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class LoginTest {
    private WebDriver driver;
    private String path = "http://localhost:8080/pageobjectpairprogramming_DJLukeD_war/Controller";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\PBA_Toegepaste_Informatica\\TI 2\\Sem 1\\Web3\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void clean(){
        driver.quit();
    }

    @Test
    public void loginAsUser(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.logInAsUser();
        assertEquals("Home", loginPage.getTitle());
    }

    @Test
    public void loginAsAdmin(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.logInAsAdmin();
        assertEquals("Home", loginPage.getTitle());
    }
}
