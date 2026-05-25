package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SoftassertTest {


	@Test
	public void softassert(){

		WebDriver driver = new ChromeDriver();

		SoftAssert soft = new SoftAssert();

		driver.manage().window().maximize();

		driver.get("https://testautomationpractice.blogspot.com/");

		//Textbox

		WebElement nametextbox= driver.findElement(By.xpath("//input[@id='name']"));
		nametextbox.sendKeys("Jagu");
		
		soft.assertEquals(nametextbox.getAttribute("value"), "Jagu", "incorrect name");
		
		System.out.println("Textbox " + nametextbox.getAttribute("value"));
		
		

		//radio
		WebElement Gender =	driver.findElement(By.xpath("//input[@id='male']"));
		Gender.click();
		soft.assertTrue(Gender.isSelected(), "male not selected");
		System.out.println("Gender " + Gender.isSelected());
		

		//check
		WebElement Days =	driver.findElement(By.xpath("//input[@id='monday']"));
		Days.click();
		soft.assertTrue(Days.isSelected(), "Days not selected");
		System.out.println("Days " + Days.isSelected());

		//Dropdown

		WebElement Dropdown=  driver.findElement(By.xpath("//select[@id='country']"));

		Select select = new Select(Dropdown);

		select.selectByVisibleText("India");

		soft.assertEquals(select.getFirstSelectedOption().getText(),"India", "India not selected");
		
		System.out.println("select " + select.getFirstSelectedOption().getText());


		//selection

		WebElement Selection =  driver.findElement(By.xpath("//option[@value='white']"));
		Selection.click();
		soft.assertTrue(Selection.isSelected(), "Selection not done");
		System.out.println("Selection " + Selection.isSelected());


		//Alert

		WebElement simplealert = driver.findElement(By.xpath("//button[@id='alertBtn']"));
		simplealert.click();
		String Alerttext = driver.switchTo().alert().getText();

		soft.assertEquals(Alerttext, "I am an alert box!", "alert wrong");
		driver.switchTo().alert().accept();

		System.out.println("simplealert " + Alerttext);
		
		//Confirmation alert

		WebElement Confirmationalert = driver.findElement(By.xpath("//button[@id='confirmBtn']"));
		Confirmationalert.click();

		driver.switchTo().alert().dismiss();

		WebElement Confirmationalertmessage	= driver.findElement(By.xpath("//p[contains(text(), 'You pressed Cancel!')]"));

		soft.assertTrue(Confirmationalertmessage.isDisplayed());

		System.out.println("Confirmation alert message " + Confirmationalertmessage.getText());
		
		soft.assertAll();
		driver.quit();
		System.out.println("Bhaskar first");










	}

}
