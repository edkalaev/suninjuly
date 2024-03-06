package suninjuly;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class explicit_wait2 {
    private WebDriver driver;

    private WebDriverWait priceWait;



    @BeforeEach
     public void setUp() {



        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://suninjuly.github.io/explicit_wait2.html");
        priceWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @Test
    public void testExplicit_wait2() {

        //ищем элемент price и ждем когда цена будет 100 долларов


        Boolean priceElement = priceWait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("price"), "$100"));


        WebElement button = driver.findElement(By.id("book"));
        button.click();

        //находим значение x

        WebElement xElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("input_value")));
        String xValue = xElement.getText();

        // Вычисляем результат и вписываем его в поле ответа
        double result = Math.log(Math.abs(12 * Math.sin(Double.parseDouble(xValue))));

        WebElement answerField = driver.findElement(By.id("answer"));
        answerField.sendKeys(Double.toString(result));

        // кликаем на submit

        WebElement submitButton = driver.findElement(By.id("solve"));
        submitButton.click();



    }

    @AfterEach
    public void tearDown() {
        driver.quit();

    }

}
