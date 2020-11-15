package webtest;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InformacoesDeUsuarioTest {

	private WebDriver navegador; // declarando variavel navegador  como global para ser vista pelos outros metodo 
	
@Before
	public void setUp() {
	
			//abrir navegador chromedriver
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Neves\\Downloads\\chromedriver_win32\\chromedriver.exe");
			
			//importar o webDrive como navegador padrão 
			navegador = new ChromeDriver();
			
			//navegar para uma pagina na internet "navegador, chama um metodo pra o navegador
			navegador.get("http://www.juliodelima.com.br/taskit/");
	
}

@Test
	public void iniciarNavegador () throws InterruptedException {
		
		//navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		//clicar no link que possui o texto "Sign in"
		navegador.findElement(By.className("modal-trigger")).click();
		 
		//clicar no campo com o nome "login" que está dentro do formulario
		WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));
		
		//Digitar no campo com o nome de "login" que está dentro do formulario e id "signinbox" o texto "julio0001"
		formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");
		
		//Digitar no campo com o nome de "password" que está dentro do formulario e id "signinbox" o texto "123456"
		formularioSignInBox.findElement(By.name("password")).sendKeys("123456");
		
		//Clicar no link com o texto "SIGN IN"
		navegador.findElement(By.linkText("SIGN IN")).click();
		
		//Validar dentro do elemento com class "me"está o texto "Hi, Julio"
		//WebElement me = navegador.findElement(By.className("me"));
		//String TextoNoElementoMe = me.getText();
		//assertEquals ("Hi, Julio", TextoNoElementoMe);

		//clicar em um link que possui a class "me"
		navegador.findElement(By.className("me")).click();
	
		//clicar em um link que possui a class "MORE DATA ABOUT YOU"
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
	
		//clicar no botao atraves do seu xpath //button[@data-target="addmoredata"]
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
		
		//identificar a popup onde esta o formulario de id addmoredata
		WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));
		
		// no campo de name "type" escolher a opção "Phone"
		WebElement campoType = popupAddMoreData.findElement(By.name("type"));
		new Select (campoType).selectByVisibleText("Phone");
		
		//no campo de name "contact"digitar "+5511955555555"
		popupAddMoreData.findElement(By.name("contact")).sendKeys("+5511955555555");	
		
		//clicar em link de text "SAVE"que está no popup 
		popupAddMoreData.findElement(By.linkText("SAVE")).click();
	
		//na mensagem de id "toast-container" validar que o texto é "Your contact has been added!"
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals("Yourcontact has been added!",mensagem);

}

//@After
	public void tearDown () {
	
		//Fechar o navegador
		navegador.quit();
	
}

	}




