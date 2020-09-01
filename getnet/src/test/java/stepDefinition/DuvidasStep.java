package stepDefinition;

import Utils.GetnetUtil;
import helper.MainHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DuvidasStep {
	
	MainHelper mainHelper;
	
	
	@Given("Como posso acessar minha conta superget")
	public void AcessarSite() {
		mainHelper = new MainHelper(GetnetUtil.GetDriver());
		mainHelper.AcessarSite("https://site.getnet.com.br/");
	}
	
	@When("Clicar no icone de pesquisa")
	public void ClicarIconePesquisa() {
		mainHelper.ClicarIconePesquisa();
	}

	@When("Digitar {string} e clicar em procurar")
	public void PreencherProcurar(String msg) {
			mainHelper.PreencherCampoPesquisar(msg);
			mainHelper.ClicarProcurar();
	}

	@Then("Sistema apresenta as duvidas mais frequentes {string}")
	public void sistema_apresenta_as_duvidas_mais_frequentes(String titulo) {
		mainHelper.VerificarPesquisa(titulo);
	}

	@Then("Eu clico no link {string}")
	public void eu_clico_no_link(String link) {
		mainHelper.ClicarLink(link);
	}

	@Then("Verifico se o titulo da modal apresenta a frase {string}")
	public void verifico_se_o_titulo_da_modal_apresenta_a_frase(String msg) {
		mainHelper.VerificarTituloModal(msg);
	}

	
}
