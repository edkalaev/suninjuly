package suninjuly;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class hugeForm {
    private WebDriver driver;

    @BeforeEach

    public void setUp() {

        ChromeOptions chromeOptions = new ChromeOptions();

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(chromeOptions);

        driver.get("https://suninjuly.github.io/huge_form.html ");
    }

    @Test

    public void testFormValidation() {

        //заполняем все поля


        List<WebElement> textFields = driver.findElements(By.cssSelector("input[type='text'][maxlength='32']"));
        for (WebElement textField : textFields) {
            textField.sendKeys("Hello");
        }

        //ждем появления submit и кликаем

        WebDriverWait waitSubmit = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement element = waitSubmit.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));


        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        //выполняем проверку что данные сохранились

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        driver.navigate().back();

        List<WebElement> recordElements = driver.findElements(By.cssSelector("input[type='text'][maxlength='32']"));
        assertTrue(recordElements.size() > 0);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();


    }
}