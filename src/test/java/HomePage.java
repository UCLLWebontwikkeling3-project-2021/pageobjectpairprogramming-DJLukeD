import org.openqa.selenium.WebDriver;

/*
 * @author Lukas De Ruysscher
 */
public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver.get(path + "?command=Home");
    }
}
