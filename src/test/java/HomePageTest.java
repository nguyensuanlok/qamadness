import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {

    private WebDriver driver;

    private HomePage homePage;
    private LoginPage loginPage;

    @Before
    public  void setUp()
    {
        System.setProperty("webdriver.chrome.driver","/Users/thanh/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void successfulLoginTest() {
        homePage.open();
        homePage.clickLoginToOpenForm();
        loginPage.enterLoginUsername("+38 (093) 914-25-49");
        loginPage.enterLoginPassword("QWERTYtest123");
        loginPage.clickLogin();
        Assert.assertEquals("Suan Lok", homePage.returnUsername());
    }

    @Test
    public void unsuccessfulLoginTest() {
        homePage.open();
        homePage.clickLoginToOpenForm();
        loginPage.enterLoginUsername("+38 (093) 123-45-67");
        loginPage.enterLoginPassword("wrongpassword");
        loginPage.clickLogin();
        Assert.assertEquals("Некоректний пароль", loginPage.returnError());
    }

    @Test
    public void rememberPasswordTest() {
        homePage.open();
        homePage.clickLoginToOpenForm();
        loginPage.enterLoginUsername("+38 (093) 914-25-49");
        loginPage.clickRemember();
        Assert.assertEquals("На ваш номер телефону вже було відправлено 3 смс з новим кодом доступу. Якщо повідомлень нема - зверніться в колл-центр", loginPage.returnMessage());
    }

    @Test
    public void checkEmptyFieldsTest() {
        homePage.open();
        homePage.clickLoginToOpenForm();
        loginPage.clickLogin();
        Assert.assertEquals("Введіть мобільний телефон", loginPage.returnPhoneError());
        Assert.assertEquals("Пароль обов'язковий", loginPage.returnPasswordError());
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
