package com.utilities;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;


public class Hook extends BasePage {

    @Before("@test")

    public void setUp() throws IOException {
        driver = Driver.getDriver();
    }

    @After("@test")
    public void tearDown(Scenario scenario) throws IOException, InterruptedException {
        if (scenario.isFailed()) {
            String dir = "target/errors",
                    fileName = LocalDateTime.now() +scenario.getName().replace(" ", "_") + ".png";

            BufferedImage fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver).getImage();
            File outPutFile = new File("image.jpg");
            try {
                ImageIO.write(fpScreenshot, "PNG", outPutFile);
                FileUtils.copyFile(outPutFile, new File(dir + "-" + fileName), true);
                boolean file = new File("image.jpg").delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Driver.tearDown();
    }
}
