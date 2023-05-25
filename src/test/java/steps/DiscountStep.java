package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.cucumber.spring.CucumberContextConfiguration;
import runner.RunCucumberTest;

@CucumberContextConfiguration
public class DiscountStep extends RunCucumberTest {

	@Dado("que estou no site da qazando")
	public void acessar_site_qazando() {
		driver.manage().window().maximize();
		driver.get("http://qazando.com.br/curso.html");

		assertEquals(true, driver.findElement(By.id("btn-ver-cursos")).isDisplayed(), "Não acessou a aplicação!");
	}

	@Quando("eu preencho meu e-mail")
	public void eu_preencho_meu_e_mail() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 10000)");
		driver.findElement(By.id("email")).sendKeys("contatoqazando@gmail.com");

	}

	@Quando("clico em ganhar cupom")
	public void clico_em_ganhar_cupom() {

		// Clica fora para habilitar o botão "Ganhar Cupom"
		driver.findElement(By.cssSelector("body > center > div.footer-section > div.logo")).click();
		driver.findElement(By.id("button")).click();
	}

	@Então("eu vejo o código de desconto")
	public void eu_vejo_o_código_de_desconto() {
		String texto_cupom = driver.findElement(By.cssSelector("#cupom > h2 > span")).getText();
				
		assertEquals("QAZANDO15OFF", texto_cupom, "O cupom está errado!");
	}

}
