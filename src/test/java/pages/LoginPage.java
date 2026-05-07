package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By txtUser = By.id("user-name");
    By txtPass = By.id("password");
    By btnLogin = By.id("login-button");

    public LoginPage(WebDriver driver) {

        this.driver = driver;

    }

    public void escribirUsuario(String usuario) {

        driver.findElement(txtUser).sendKeys(usuario);

    }

    public void escribirPassword(String password) {

        driver.findElement(txtPass).sendKeys(password);

    }

    public void clickLogin() {

        driver.findElement(btnLogin).click();

    }

}