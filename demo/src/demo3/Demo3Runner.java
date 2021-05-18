
/**
 * Runner Class
 */
public class Demo3Runner {

    /**
     * Main Method
     *
     * This Selenium demonstration routine should to:
     * 1 - Spawn Firefox Browser
     * 2 - Open Google
     * 3 - Type the string "Selenim" in Google
     * 4 - Print all Google search suggestions in console
     * 5 - Close Firefox Browser
     */
    public static void main(String[] args) {

        // Instantiating SeleniumManager Class
        Demo3SeleniumManager seleniumManager = new Demo3SeleniumManager();

        // Opening google.com
        seleniumManager.openFirefox("https://google.com");

        // Search on Google
        seleniumManager.printGoogleSuggestionsFor("Selenium");

        // Closing Firefox
        seleniumManager.closeFirefox();
    }
}
