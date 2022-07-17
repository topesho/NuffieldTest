package com.Docker;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class Docker {


  public static void runDocker(String command, String text, String outPutText) throws IOException, InterruptedException {
    Runtime.getRuntime().exec(command);

    Boolean flag = false;
    String f = "output.txt";

    Calendar cal = Calendar.getInstance(); // gets the local time in java
    cal.add(Calendar.SECOND, 40);
    long stopNowTime = cal.getTimeInMillis();

    while (System.currentTimeMillis() < stopNowTime) {

      if (flag) {
        break;
      }

      /** BufferReader read text from files */
      BufferedReader reader = new BufferedReader(new FileReader(f));
      String currentLine = reader.readLine();
      while (currentLine != null && !flag) {

        if (currentLine.contains(text)) {
          flag = true;
          System.out.println(outPutText);
          break;
        }
        currentLine = reader.readLine();
      }
      reader.close();
    }
    assertThat(flag, is(true));
  }
}
