import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath= "//button[@class = 'auth-popup-button']")
    WebElement loginForm;

    @FindBy(xpath= "//button[@class = 'user-panel-button active']")
    WebElement username;

    HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    void open() {
        driver.get("https://brain.com.ua/");
    }

    void clickLoginToOpenForm() {
        loginForm.click();
    }

    String returnUsername() {
        WebDriverWait driverWait = new WebDriverWait(driver, 10);
        driverWait.until(ExpectedConditions.visibilityOfAllElements(username));
        return username.getText();
    }
}
