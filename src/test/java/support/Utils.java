package support;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import runner.RunCucumberTest;

public class Utils extends RunCucumberTest{

	public void esperarElementoEstarPresente(By element, Integer tempo) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tempo));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
