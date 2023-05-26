package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.cucumber.spring.CucumberContextConfiguration;
import pages.HomePage;
import runner.RunCucumberTest;

@CucumberContextConfiguration
public class DiscountStep extends RunCucumberTest {

	HomePage homePage = new HomePage(driver);

	@Dado("que estou no site da qazando")
	public void acessar_site_qazando() {
		homePage.acessarAplicacao();
	}

	@Quando("eu preencho meu e-mail")
	public void eu_preencho_meu_e_mail() {
		homePage.scrollDown();
		homePage.preencheEmail("contatoqazando@gmail.com");
	}

	@Quando("clico em ganhar cupom")
	public void clico_em_ganhar_cupom() {
		homePage.clickNoLogo(); // Clica fora para habilitar o botão "Ganhar Cupom"
		homePage.clickGanharDesconto();
	}

	@Então("eu vejo o código de desconto")
	public void eu_vejo_o_código_de_desconto() {
		homePage.verificarCupomDesconto("QAZANDO15OFF");
	}

}
