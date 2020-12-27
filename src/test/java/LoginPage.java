import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @author Lukas De Ruysscher
 */

public class LoginPage extends Page {

    @FindBy(id = "userId")
    private WebElement userIdField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id="signUp2")
    private WebElement logInButton;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver.get(path+"?command=Home");
    }

    public void setUserId(String userId){
        userIdField.clear();
        userIdField.sendKeys(userId);
    }

    public void setPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public HomePage submitValid(){
        logInButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }

    public void logInAsUser(){
        setUserId("Lukas");
        setPassword("1234");
        submitValid();
    }

    public void logInAsAdmin(){
        setUserId("Admin");
        setPassword("admin");
        submitValid();
    }
}
