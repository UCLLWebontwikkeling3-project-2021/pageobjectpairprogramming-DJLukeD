import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
/*
 * @author Lukas De Ruysscher
 */
public class PersonOverviewTest {
    private WebDriver driver;
    private String path = "http://localhost:8080/Controller";


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\PBA_Toegepaste_Informatica\\TI 2\\Sem 1\\Web3\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.managed_default_content_settings.javascript", 2);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
    }


    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void test_User_Not_Logged_In_Shows_Error(){
        PersonOverviewPage personOverviewPage = PageFactory.initElements(driver, PersonOverviewPage.class);
        assertEquals("Home", personOverviewPage.getTitle());
        assertTrue(personOverviewPage.containsErrorMessage("Please log in to see this content"));
    }

    @Test
    public void test_User_Is_Logged_In_But_Has_No_Rights_To_Access_Page(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.logInAsUser();
        PersonOverviewPage personOverviewPage = PageFactory.initElements(driver, PersonOverviewPage.class);
        assertEquals("Home", personOverviewPage.getTitle());
        assertTrue(personOverviewPage.containsErrorMessage("You are not authorized to see this content!"));
    }

    @Test
    public void test_User_Is_Admin_And_Shows_Overview(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.logInAsAdmin();
        PersonOverviewPage personOverviewPage = PageFactory.initElements(driver, PersonOverviewPage.class);

        assertEquals("Overview", personOverviewPage.getTitle());
        assertTrue(personOverviewPage.containsUserWithEmail("nina@ucll.be"));
        assertTrue(personOverviewPage.containsUserWithUsername("Nina"));
        assertTrue(personOverviewPage.containsUserWithFirstname("Nina"));
        assertTrue(personOverviewPage.containsUserWithLastname("Kumps"));
        assertTrue(personOverviewPage.containsUserWithEmail("lukas@ucll.be"));
        assertTrue(personOverviewPage.containsUserWithUsername("Lukas"));
        assertTrue(personOverviewPage.containsUserWithFirstname("Lukas"));
        assertTrue(personOverviewPage.containsUserWithLastname("De Ruysscher"));
    }
}
