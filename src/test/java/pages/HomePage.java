package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void acessarAplicacao() {
		driver.manage().window().maximize();
		driver.get("http://qazando.com.br/curso.html");
		assertEquals(true, driver.findElement(By.id("btn-ver-cursos")).isDisplayed(), "Não acessou a aplicação!");
	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 10000)");
	}

	public void preencheEmail(String email) {
		driver.findElement(By.id("email")).sendKeys(email);
	}

	public void clickNoLogo() {
		// Clica fora para habilitar o botão "Ganhar Cupom"
		driver.findElement(By.cssSelector("body > center > div.footer-section > div.logo")).click();
	}

	public void clickGanharDesconto() {
		driver.findElement(By.id("button")).click();
	}

	public void verificarCupomDesconto(String cupomDesconto) {
		String texto_cupom = driver.findElement(By.cssSelector("#cupom > h2 > span")).getText();
		assertEquals(cupomDesconto, texto_cupom, "O cupom está errado!");
	}
}
