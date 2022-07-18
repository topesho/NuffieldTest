package com.Docker;




import org.junit.Test;
import java.io.File;
import java.io.IOException;

public class DockerStop {
    @Test
  public  void stopDocker() throws IOException, InterruptedException {
      Docker.runDocker("zsh dockerDown.sh","Shutdown complete","Docker has stopped");
      Thread.sleep(10000);
      File file = new File("output.txt");
              if(file.delete()){
                  System.out.println("File has been deleted");
              }
  }
}
