import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * Selenium Manager Class
 * It should manage all Selenium actions
 */
public class Demo3SeleniumManager {

    // Local path to Firefox application binary
    private static final String FIREFOX_BINARY_PATH = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";

    // Private Global Firefox Web Driver
    private WebDriver mFirefoxWebDriver;

    /**
     * SeleniumManager Class Constructor
     */
    public Demo3SeleniumManager() {

        // Acquiring GeckoDriver binary file URL
        URL geckoDriverUrl = this.getClass().getClassLoader().getResource("geckodriver.exe");
        if (geckoDriverUrl == null) {
            System.out.println("[ ERROR ] Fail to get geckodriver.exe URL");
            return;
        }

        // GeckoDriver Setup
        System.setProperty("webdriver.gecko.driver", geckoDriverUrl.getFile());

        // Firefox Application Setup
        File firefoxBinaryPath = new File(FIREFOX_BINARY_PATH);
        FirefoxBinary firefoxBinary = new FirefoxBinary(firefoxBinaryPath);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);

        // Instantiating Global Firefox Driver
        mFirefoxWebDriver = new FirefoxDriver(firefoxOptions);
    }

    /**
     * openFirefox Method
     * It should spawn firefox browser in parameter URL
     * @param Url URL to be opened in Firefox browser
     */
    public void openFirefox(String Url) {
        mFirefoxWebDriver.get(Url);
    }

    /**
     * closeFirefox Method
     */
    public void closeFirefox() {
        mFirefoxWebDriver.close();
    }

    /**
     * Print all Google suggestions for parameter "text"
     * @param text Text to be searched in Google
     */
    public void printGoogleSuggestionsFor(String text) {

        // Input "text" parameter in "q" Google page HTML element
        mFirefoxWebDriver.findElement(By.name("q")).sendKeys(text);

        // Wait 2 seconds
        sleepSeconds(2);

        // Finding all suggestion elements by class name
        List<WebElement> suggestionsList = mFirefoxWebDriver.findElements(By.className("aypzV"));

        // Printing Suggestions
        System.out.println("\n");
        System.out.println("===========================================");
        System.out.println("Google Suggestions for: " + text);
        System.out.println("===========================================");

        for (WebElement suggestion : suggestionsList) {
            if (!suggestion.getText().isBlank()) {
                System.out.println("-> " + suggestion.getText());
            }
        }

        System.out.println("+==========================================");
        System.out.println("Total: " + suggestionsList.size());
        System.out.println("+==========================================");
        System.out.println("\n");
    }

    /**
     * Sleep in seconds
     * @param time Time to sleep (in seconds)
     */
    public void sleepSeconds(long time) {
        try {
            Thread.sleep(time * 1000);

        } catch (InterruptedException ignored) {
            System.out.println("[ ERROR ] Fail to sleep " + time);
        }
    }
}
