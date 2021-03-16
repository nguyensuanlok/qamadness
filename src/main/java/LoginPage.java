import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath= "//div[@id = 'login-tab']//input[@class = 'input-field phone_mask']")
    WebElement loginField;

    @FindBy(xpath= "//div[@id = 'login-tab']//input[@class = 'input-field br-login-pass-field']")
    WebElement passwordLoginField;

    @FindBy(xpath= "//button[@class = 'br-login-submit']")
    WebElement buttonLogin;

    @FindBy(xpath= "//div[@class = 'login-error']")
    WebElement errorMessage;

    @FindBy(xpath= "//button[@class = 'br-login-button-toggle']")
    WebElement rememberPassword;

    @FindBy(xpath= "//div[@class = 'password-recovery-message error']")
    WebElement message;

    @FindBy(xpath= "//form[contains(@class, 'br-login-form modal-br-login-form')]//div[contains(@class, 'form-group row')][1]//label[contains(@class, 'error error_msg empty_field')]")
    WebElement phoneErrorMessage;

    @FindBy(xpath= "//form[contains(@class, 'br-login-form modal-br-login-form')]//div[contains(@class, 'form-group row')][2]//label[contains(@class, 'error error_msg empty_field')]")
    WebElement passwordErrorMessage;

    LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    void enterLoginUsername(String login) {
        WebDriverWait driverWait = new WebDriverWait(driver, 10);
        driverWait.until(ExpectedConditions.visibilityOfAllElements(loginField));
        loginField.click();
        loginField.sendKeys(login);
    }

    void enterLoginPassword(String password) {
        passwordLoginField.sendKeys(password);
    }

    void clickLogin() {
        WebDriverWait driverWait = new WebDriverWait(driver, 10);
        driverWait.until(ExpectedConditions.visibilityOfAllElements(buttonLogin));
        buttonLogin.click();
    }

    String returnError() {
        WebDriverWait driverWait = new WebDriverWait(driver, 10);
        driverWait.until(ExpectedConditions.visibilityOfAllElements(errorMessage));
        return errorMessage.getText();
    }

    void clickRemember(){
        rememberPassword.click();
    }

    String returnMessage() {
        WebDriverWait driverWait = new WebDriverWait(driver, 10);
        driverWait.until(ExpectedConditions.visibilityOfAllElements(message));
        return message.getText();
    }

    String returnPhoneError() {
        WebDriverWait driverWait = new WebDriverWait(driver, 10);
        driverWait.until(ExpectedConditions.visibilityOfAllElements(phoneErrorMessage));
        return phoneErrorMessage.getText();
    }

    String returnPasswordError() {
        WebDriverWait driverWait = new WebDriverWait(driver, 10);
        driverWait.until(ExpectedConditions.visibilityOfAllElements(passwordErrorMessage));
        return passwordErrorMessage.getText();
    }
}