package com.company;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@GraphWalker(value = "random(edge_coverage(100))", start = "v_Start")
public class YoutubeTest2 extends ExecutionContext implements YoutubeTestModel2 {

    WebDriver driver = null;
    WebDriverWait waiter = null;

    @BeforeExecution
    public void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterExecution
    public void cleanup() {
        if (driver != null) {
            driver.quit();
        }
    }

    public YoutubeTest2(){ }

    @Override
    public void e_ClickHistory() {
        String pathToHistoryButton = "/html/body/ytd-app/div[1]/ytd-mini-guide-renderer/div/ytd-mini-guide-entry-renderer[6]/a/yt-icon";
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(pathToHistoryButton))).click();
    }

    @Override
    public void e_ClickBack() {
        driver.navigate().back();
    }

    @Override
    public void v_SigninPage() {
        waiter.until(ExpectedConditions.urlContains("https://accounts.google.com/"));
        Assert.assertTrue(driver.getCurrentUrl().contains("https://accounts.google.com/"));
    }

    @Override
    public void e_StartByHomepage() {
        driver = new ChromeDriver();
        waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://youtube.com");
    }

    @Override
    public void e_QuerySearch() {
        waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
        String pathToSearchField = "/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div[1]/div[1]/input";
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathToSearchField))).sendKeys("deephouse");
        String pathToForm = "/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form";
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(pathToForm))).submit();
    }

    @Override
    public void v_Start() { }

    @Override
    public void v_Homepage() {
        waiter.until(ExpectedConditions.urlToBe("https://www.youtube.com/"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.youtube.com/");
    }

    @Override
    public void v_SearchResultsPage() {
        waiter.until(ExpectedConditions.urlContains("results?search_query"));
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com/results?search_query="));
    }

    @Override
    public void v_HistoryPage() {
        waiter.until(ExpectedConditions.urlToBe("https://www.youtube.com/feed/history"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/feed/history");
    }

    @Override
    public void e_ClickSignin() {
        String pathToSigninButton = "/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[3]/div[2]/ytd-button-renderer/a/tp-yt-paper-button";
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(pathToSigninButton))).click();
    }
}
