package org.example.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TCRF001 {
    @Test
    public void tcrf001() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");

        WebElement myAccountDropMenu = driver.findElement(By.xpath("//span[text()=\"My Account\"]"));
        myAccountDropMenu.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement registerOption = driver.findElement(By.linkText("Register"));//это способ поиска элемента по полному тексту ссылки
        registerOption.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement firstNameField = driver.findElement(By.id("input-firstname"));
        firstNameField.sendKeys("Dmytro");

        WebElement lastNameField = driver.findElement(By.id("input-lastname"));
        lastNameField.sendKeys("Serhiienko");

        WebElement emailField = driver.findElement(By.id("input-email"));
        emailField.sendKeys("Dima@gmail.com");

        WebElement telephoneField = driver.findElement(By.id("input-telephone"));
        telephoneField.sendKeys("0582952212");

        WebElement passwordField = driver.findElement(By.id("input-password"));
        passwordField.sendKeys("0582952212");

        WebElement passwordConfirmField = driver.findElement(By.id("input-confirm"));
        passwordConfirmField.sendKeys("0582952212");

        WebElement privacyChekBox = driver.findElement(By.name("agree"));
        privacyChekBox.click();

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        continueButton.click();

        WebElement successHeading = driver.findElement(By.xpath("//*[@id='content']/h1"));

        // Проверка через TestNG
        String actualHeading = successHeading.getText();
        String expectedHeading = "Your Account Has Been Created!";

        Assert.assertEquals(actualHeading, expectedHeading, "Текст заголовка не совпадает!");

        // Закрыть браузер
        driver.quit();
    }
}
