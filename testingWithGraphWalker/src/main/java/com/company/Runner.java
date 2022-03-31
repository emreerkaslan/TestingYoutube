package com.company;

import com.company.YoutubeTest1;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;

import java.io.IOException;

public class Runner {
  public static void main(String[] args) throws IOException {
    TestExecutor executor = new TestExecutor(
            YoutubeTest1.class, YoutubeTest2.class, YoutubeTest3.class, YoutubeTest4.class
    );

    Result result = executor.execute(true);
    System.out.println("Done: [" + result.getResults().toString(2) + "]");
  }
}
