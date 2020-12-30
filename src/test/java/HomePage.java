import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @author Lukas De Ruysscher
 */
public class HomePage extends Page {

    @FindBy(id = "userId")
    private WebElement userIdField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id="signUp2")
    private WebElement logInButton;

    @FindBy(id="signUp")
    private WebElement logOutButton;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver.get(path + "?command=Home");
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

    public void login(){
        setUserId("Dirk");
        setPassword("5789");
        submitValid();
    }

    public void logInAsAdmin(){
        setUserId("Admin");
        setPassword("admin");
        submitValid();
    }

    public void logOut(){
        logOutButton.click();

    }

    public boolean containsErrorMessage(String message) {
        WebElement errorMessage = driver.findElement(By.cssSelector(".alert-danger"));
        return (message.equals(errorMessage.getText()));
    }

    public boolean containsSuccessMessage(String message) {
        WebElement errorMessage = driver.findElement(By.cssSelector(".success"));
        return (message.equals(errorMessage.getText()));
    }
}
