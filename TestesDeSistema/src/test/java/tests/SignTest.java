package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SignTest {
    @Test
    public void testFazerLoginNoDiscord() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        navegador.get("https://discord.com/login");
        navegador.findElement(By.name("email")).sendKeys("marcos.2020109733@unicap.br");
        navegador.findElement(By.name("password")).sendKeys("senhadaconta123");
        navegador.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div/div/form/div/div/div[1]/div[2]/button[2]")).click();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String nome = navegador.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div[2]/div/div[1]/div/div/div[1]/section/div[2]/div[1]/div[2]/div[1]/div")).getText();
        assertEquals("MarcosTST", nome);
    }

    @Test
    public void testPaginaDeSeguranca() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        navegador.get("https://discord.com/");
        navegador.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[1]/header[2]/nav/div[1]/a[3]")).click();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String titulo = navegador.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/div[2]/h1")).getText();
        assertEquals("CENTRAL DE SEGURANÇA DO DISCORD", titulo);
    }

    @Test
    public void testPaginaDeSuport() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        navegador.get("https://discord.com/");
        navegador.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[1]/header[2]/nav/div[1]/a[4]")).click();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.findElement(By.xpath("/html/body/main/section[3]/ul/a[1]")).click();
        String titulo = navegador.findElement(By.xpath("/html/body/main/div[2]/div/div/header/h1")).getText();
        assertEquals("Anúncios", titulo);
    }
}
