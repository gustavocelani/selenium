import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.net.URL;

/**
 * Selenium Manager Class
 * It should manage all Selenium actions
 */
public class Demo1SeleniumManager {

    // Local path to Firefox application binary
    private static final String FIREFOX_BINARY_PATH = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";

    // Private Global Firefox Web Driver
    private WebDriver mFirefoxWebDriver;

    /**
     * SeleniumManager Class Constructor
     */
    public Demo1SeleniumManager() {

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
     * Print Current Page Info Method
     */
    public void printCurrentPageInfo() {
        System.out.println("\n");
        System.out.println("+===============================+");
        System.out.println("|       Current Page Info       |");
        System.out.println("+===============================+");
        System.out.println("URL:   " + mFirefoxWebDriver.getCurrentUrl());
        System.out.println("Title: " + mFirefoxWebDriver.getTitle());
        System.out.println("+===============================+");
        System.out.println("\n");
    }
}
