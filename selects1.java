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
import org.openqa.selenium.support.ui.Select;

public class selects1 {

    private WebDriver driver;
    String firstNumberText;
    String secondNumberText;

    @BeforeEach

    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://suninjuly.github.io/selects1.html");
    }
    @Test
    public void testSelects1() {
        // находим числа

        WebElement firstNumberElement = driver.findElement(By.xpath(("//span[@id='num1']")));
        WebElement secondNumberElement = driver.findElement(By.xpath(("//span[@id='num2']")));

        // считываем цифры, преобразовываем текст в тип числа,  считаем сумму

        String firstNumberText = firstNumberElement.getText();
        String secondNumberText = secondNumberElement.getText();

        int firstNumber = Integer.parseInt(firstNumberText);
        int secondNumber = Integer.parseInt(secondNumberText);

        int sum = firstNumber + secondNumber;

        // поиск доступных вариантов ответа

        WebElement selectElement = driver.findElement(By.id("dropdown"));
        selectElement.click();

        //выбираем правильный ответ

        Select select = new Select(selectElement);
        select.selectByValue(Integer.toString(sum));

        //кликаем на выбранный вариант

        WebElement selectedOption = select.getFirstSelectedOption();
        selectedOption.click();

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

    }

    @AfterEach
    public void tearDown() {
        driver.quit();

    }

}
