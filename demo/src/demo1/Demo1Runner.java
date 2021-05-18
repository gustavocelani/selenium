
/**
 * Runner Class
 */
public class Demo1Runner {

    /**
     * Main Method
     *
     * This Selenium demonstration routine should to:
     * 1 - Spawn Firefox Browser
     * 2 - Open Google
     * 3 - Print Page Info in Console
     */
    public static void main(String[] args) {

        // Instantiating SeleniumManager Class
        Demo1SeleniumManager seleniumManager = new Demo1SeleniumManager();

        // Opening google.com
        seleniumManager.openFirefox("https://google.com");

        // Printing current page info in console
        seleniumManager.printCurrentPageInfo();
    }
}
