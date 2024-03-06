package suninjuly;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.logging.Logger;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class redirectAccept {

    private WebDriver driver;


    @BeforeEach
    public void setUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://suninjuly.github.io/redirect_accept.html");

    }

    @Test

    public void testRedirectAccept() {
        WebElement button = driver.findElement(By.cssSelector(".trollface.btn.btn-primary"));
        button.click();

        driver.navigate().to("http://suninjuly.github.io/redirect_page.html");

        //проверяем  правильный ли url

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://suninjuly.github.io/redirect_page.html"));

        String expectedUrl = "https://suninjuly.github.io/redirect_page.html";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);

        //переключаемся на вторую кладку


        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));


        // находим х и решаем задачу

        WebElement xElement = driver.findElement(By.id("input_value"));
        String xValue = xElement.getText();
        double result = Math.log(Math.abs(12 * Math.sin(Double.parseDouble(xValue))));

        //записываем x в поле
        WebElement answer = driver.findElement(By.id("answer"));
        answer.sendKeys(Double.toString(result));

        //нажимаем кнопку submit

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();

    }

}



