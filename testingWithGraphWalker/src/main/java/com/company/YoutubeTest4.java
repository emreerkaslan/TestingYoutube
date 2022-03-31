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
public class YoutubeTest4 extends ExecutionContext implements YoutubeTestModel4 {

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

    public YoutubeTest4() {
    }

    @Override
    public void e_ClickBack() {
        driver.navigate().back();
    }

    @Override
    public void v_ShortsPage() {
        waiter.until(ExpectedConditions.urlContains("https://www.youtube.com/shorts"));
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com/shorts"));
    }

    @Override
    public void v_Start() { }

    @Override
    public void e_ClickExplore() {
        String pathToExploreButton = "/html/body/ytd-app/div[1]/ytd-mini-guide-renderer/div/ytd-mini-guide-entry-renderer[2]/a/yt-icon";
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(pathToExploreButton))).click();
    }

    @Override
    public void e_StartByHomepage() {
        driver = new ChromeDriver();
        waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://youtube.com");
    }

    @Override
    public void v_FeaturedPage() {
        waiter.until(ExpectedConditions.urlContains("https://www.youtube.com/watch?"));
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com/watch?"));
    }

    @Override
    public void e_ClickShorts() {
        String pathToReportButton = "/html/body/ytd-app/div[1]/ytd-mini-guide-renderer/div/ytd-mini-guide-entry-renderer[3]/a/yt-icon";
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(pathToReportButton))).click();
    }

    @Override
    public void v_Explore() {
        waiter.until(ExpectedConditions.urlToBe("https://www.youtube.com/feed/explore"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.youtube.com/feed/explore");
    }

    @Override
    public void e_ClickHomepage() {
        String pathToHomepageButton = "/html/body/ytd-app/div[1]/ytd-mini-guide-renderer/div/ytd-mini-guide-entry-renderer[1]/a";
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(pathToHomepageButton))).click();
    }

    @Override
    public void v_Homepage() {
        waiter.until(ExpectedConditions.urlToBe("https://www.youtube.com/"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.youtube.com/");
    }

    @Override
    public void e_ClickFeatured() {
        String pathToFeaturedButton = "/html/body/ytd-app/div[1]/ytd-page-manager/ytd-browse[2]/ytd-two-column-browse-results-renderer/div[1]/ytd-section-list-renderer/div[2]/ytd-item-section-renderer[2]/div[3]/ytd-shelf-renderer/div[1]/div[2]/ytd-expanded-shelf-contents-renderer/div/ytd-video-renderer[1]/div[1]/div/div[1]/div/h3/a/yt-formatted-string";
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(pathToFeaturedButton))).click();
    }
}