package suninjuly;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class math {
    private WebDriver driver;

    @BeforeEach

    public void SetUp() {

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://suninjuly.github.io/math.html");

    }

    @Test

    public void testMath() {
        // находим икс на странице и решаем задачу


        WebElement xElement = driver.findElement(By.id("input_value"));
        String xValue = xElement.getText();
        double result = Math.log(Math.abs(12 * Math.sin(Double.parseDouble(xValue))));

        // вписываем  решение в поле

        WebElement answerField = driver.findElement(By.id("answer"));
        answerField.sendKeys(Double.toString(result));

        //кликаем по чекбоксу

        WebElement checkbox = driver.findElement(By.id("robotCheckbox"));
        checkbox.click();

        //кликаем по submit

        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        // закрываем алерт

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        //проверяем, что после правильного решения пользователь может продолжить работу на сайте

        WebElement xElement2 = driver.findElement(By.id("input_value"));
        String xValue2 = xElement2.getText();
        double result2 = Math.log(Math.abs(12 * Math.sin(Double.parseDouble(xValue2))));
        WebElement answerField2 = driver.findElement(By.id("answer"));
        answerField2.sendKeys(Double.toString(result2));
        WebElement button2 = driver.findElement(By.xpath("//button[@type='submit']"));
        button2.click();

    }

    @AfterEach
    public void tearDown() {
        driver.quit();

    }
}
