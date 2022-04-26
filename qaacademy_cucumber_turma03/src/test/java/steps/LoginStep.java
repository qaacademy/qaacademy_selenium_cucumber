package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CadastroPage;
import pages.LoginPage;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginStep {
    WebDriver driver;
    CadastroPage cadastroPage;
    LoginPage loginPage;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        cadastroPage = new CadastroPage(driver);
        loginPage = new LoginPage(driver);
    }

    @After
    public void after() {
        driver.quit();
    }


    @Dado("que esteja na pagina inicial: {string}")
    public void queEstejaNaPaginaInicial(String url) {
        driver.get(url);
    }

    @Quando("preencher email: {string} e senha: {string}")
    public void preencherEmailESenha(String email, String senha) {
        loginPage.preencherEmail(email);
        loginPage.preencherSenha(senha);
    }

    @E("clicar em fazer login")
    public void clicarEmFazerLogin() {
        loginPage.clicarAcessar();
    }

    @Entao("valido que a pagina de boas vindas foi carregada com sucesso")
    public void validoQueAPaginaDeBoasVindasFoiCarregada() {
        String url = "http://localhost:3000/home";
        new WebDriverWait(driver, 5000).until(ExpectedConditions.urlToBe(url));
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
    }

    @Dado("possuo cadastro")
    public void possuoCadastro() {
        cadastroPage.clicarRegistrar();
        cadastroPage.preencherEmail("teste10@teste.com.br");
        cadastroPage.preencherNome("QA Academy");
        cadastroPage.preencherSenha("teste");
        cadastroPage.preencherConfirmacaoSenha("teste");
        cadastroPage.clicarEmCriarComSaldo();
        cadastroPage.clicarCadastrar();
        cadastroPage.clicarFechar();
    }

    @Dado("preencho o cadastro com os dados")
    public void possuoCadastroDataTable(List<Map<String, String>> dataTable) {
        String email = dataTable.get(2).get("Email");
        String nome = dataTable.get(1).get("Nome");
        String senha = dataTable.get(1).get("Senha");
        String confirmacao = dataTable.get(1).get("Confirmacao");

        cadastroPage.clicarRegistrar();
        cadastroPage.preencherEmail(email);
        cadastroPage.preencherNome(nome);
        cadastroPage.preencherSenha(senha);
        cadastroPage.preencherConfirmacaoSenha(confirmacao);
        cadastroPage.clicarEmCriarComSaldo();
        cadastroPage.clicarCadastrar();
        cadastroPage.clicarFechar();
    }
}
