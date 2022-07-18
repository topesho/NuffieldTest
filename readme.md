# **Simple Java Project to Test NuffieldHealth website:**

**Java
Cucumber
Docker
Selenium WebDriver
Maven
Junit
Selenium Grid
PageObjects**

Test can run with either Chrome, Firefox using WebDriver manager or with RemoteWebDriver in selenium grid on docker.
Default browser is Chrome
To run test in Firefox use  `mvn test -Dbrowser=Firefox`

## **Running Test in Selenium grid on docker**

Install docker locally and ensure docker desktop is running
Change browser name in Driver class line 87 to RemoteDriver 
Run Feature file to run test, on completion run docker stop or run `docker-compose -f docker-compose.yaml down` in terminal to stop docker

## **Or**

Run `mvn test -Dbrowser=RemoteDriver`
And on completion run docker stop or run `docker-compose -f docker-compose.yaml down` in terminal to stop docker
Reports are generated using Cucumber Reports Plugin 

You can watch the test run on selenium grip on VNC on **http://localhost:7900** or check the selenium Grid console on **http://localhost:4444/ui**

**On test failure screenshots are taken using Ashot from yandex and saved in target/errors folder/**





