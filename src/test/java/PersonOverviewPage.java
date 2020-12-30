import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/*
 * @author Lukas De Ruysscher
 */
public class PersonOverviewPage extends Page {

    public PersonOverviewPage(WebDriver driver) {
        super(driver);
        this.driver.get(getPath() + "?command=Overview");
    }

    public boolean containsUserWithEmail(String email) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(email)) {
                found = true;
            }
        }
        return found;
    }

    public boolean containsUserWithFirstname(String firstname) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(firstname)) {
                found = true;
            }
        }
        return found;
    }

    public boolean containsUserWithUsername(String username) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(username)) {
                found = true;
            }
        }
        return found;
    }

    public boolean containsUserWithLastname(String lastname) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(lastname)) {
                found = true;
            }
        }
        return found;
    }

    public boolean containsErrorMessage(String message) {
        WebElement errorMessage = driver.findElement(By.cssSelector(".alert-danger"));
        return (message.equals(errorMessage.getText()));
    }
}
