package com.Docker;

import java.io.IOException;

public class DockerStart {

  public static void startDocker() throws IOException, InterruptedException {
      Docker.runDocker("zsh dockerUp.sh","Node has been added","Docker has started");
      Runtime.getRuntime().exec("zsh scaleUpChrome.sh");
      Thread.sleep(15000);
  }
}
