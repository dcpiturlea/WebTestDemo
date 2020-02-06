import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "E:\\1. PROGRAMARE\\2. JAVA\\TestingWebSite\\TestingWebSite\\chromedriver.exe");

        ChromeDriver chrome = new ChromeDriver();
        chrome.get("http://posabogdan.tech/demo/selenium/add_bug.html");

        for (int i = 0; i < 100; i++) {
            for (int j=0; j < 100; j++) {
                WebElement webElement1 = chrome.findElementByCssSelector("#nr1");
                webElement1.clear();
                webElement1.sendKeys(i + "");

                WebElement webElement2 = chrome.findElementByCssSelector("#nr2");
                webElement2.clear();
                webElement2.sendKeys(j + "");

                WebElement submit = chrome.findElementByCssSelector("button");
                submit.submit();

                WebElement result = chrome.findElementByCssSelector("#result");
                String resText = result.getText();


                if (resText.equals(i+j + "")) {
                    System.out.println("TEST OK " +i+"+"+j+"= "+resText);
                } else {
                    System.out.println("Nu functioneaza pentru " + i+"+"+j+"= "+resText);
                    System.exit(0);
                }
            }
        }

    }
}
