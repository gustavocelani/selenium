
/**
 * Runner Class
 */
public class Demo2Runner {

    /**
     * Main Method
     *
     * This Selenium demonstration routine should to:
     * 1 - Spawn Firefox Browser
     * 2 - Open Google
     * 3 - Search the string "Selenium" in Google
     * 4 - Let search result opened for 3 seconds
     * 4 - Close Firefox Browser
     */
    public static void main(String[] args) {

        // Instantiating SeleniumManager Class
        Demo2SeleniumManager seleniumManager = new Demo2SeleniumManager();

        // Opening google.com
        seleniumManager.openFirefox("https://google.com");

        // Search on Google
        seleniumManager.searchOnGoogle("Selenium");

        // Wait 3 seconds
        seleniumManager.sleepSeconds(3);

        // Closing Firefox
        seleniumManager.closeFirefox();
    }
}
