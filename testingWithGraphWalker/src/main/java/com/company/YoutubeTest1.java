package com.company;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


/**
 * Implements the GraphWalker model: src/main/resources/YoutubeTest1.json
 * <p/>
 * The interface SmallTest, that SomeSmallTest implements, is generated by
 * running: mvn graphwalker:generate-sources
 * also: mvn compile
 */
@GraphWalker(value = "random(edge_coverage(100))", start = "v_Start")
public class YoutubeTest1 extends ExecutionContext implements YoutubeTestModel1 {

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

  public YoutubeTest1(){ }

  @Override
  public void e_GoLibrary() {
    waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get("http://youtube.com/feed/library");
  }

  @Override
  public void v_Explore() {
    System.out.println("Explore title: " + driver.getTitle());
    Assert.assertEquals(driver.getTitle(),"Explore - YouTube");
  }

  @Override
  public void e_StartbyHomepage() {
    driver = new ChromeDriver();
    waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get("https://youtube.com");
  }

  @Override
  public void e_GoHistory() {
    waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get("http://youtube.com/feed/history");
  }

  @Override
  public void v_History() {
    System.out.println("History title: " + driver.getTitle());
    Assert.assertEquals(driver.getTitle(),"YouTube");
  }

  @Override
  public void e_GoExplore() {
    waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get("http://youtube.com/feed/explore");
  }

  @Override
  public void v_Subscriptions() {
    System.out.println("Subscriptions title: " + driver.getTitle());
    Assert.assertEquals(driver.getTitle(),"Subscriptions - YouTube");
  }

  @Override
  public void v_Library() {
    System.out.println("Library title: " + driver.getTitle());
    Assert.assertEquals(driver.getTitle(),"Library - YouTube");
  }

  @Override
  public void v_Start() { }

  @Override
  public void e_GoSubscriptions() {
    waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get("http://youtube.com/feed/subscriptions");
  }

  @Override
  public void e_GoHomepage() {
    waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get("http://youtube.com");
  }

  @Override
  public void v_Homepage() {
    System.out.println("Homepage title: " + driver.getTitle());
    Assert.assertEquals(driver.getTitle(),"YouTube");
  }
}