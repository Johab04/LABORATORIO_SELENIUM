package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.*;

import pages.LoginPage;

public class LoginTest {

    WebDriver driver;
    LoginPage login;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        login = new LoginPage(driver);

    }

    @Test(priority = 1)
    public void loginExitoso() {

        driver.get("https://www.saucedemo.com/");

        login.escribirUsuario("standard_user");
        login.escribirPassword("secret_sauce");
        login.clickLogin();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"));

        System.out.println("Login exitoso");

    }

    @Test(priority = 2)
    public void agregarCarrito() {

        driver.get("https://www.saucedemo.com/");

        login.escribirUsuario("standard_user");
        login.escribirPassword("secret_sauce");
        login.clickLogin();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        String badge = driver.findElement(
                By.className("shopping_cart_badge")).getText();

        Assert.assertEquals(badge, "1");

        System.out.println("Producto agregado");

    }

    @Test(priority = 3)
    public void loginFallido() {

        driver.get("https://www.saucedemo.com/");

        login.escribirUsuario("locked_out_user");
        login.escribirPassword("secret_sauce");
        login.clickLogin();

        String error = driver.findElement(
                By.cssSelector("[data-test='error']")).getText();

        Assert.assertTrue(error.contains("locked out"));

        System.out.println("Usuario bloqueado validado");

    }

    @AfterMethod
    public void cerrar() {

        driver.quit();

    }
}