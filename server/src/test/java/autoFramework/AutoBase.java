package autoFramework;

import com.google.gson.Gson;
import models.Distributors;
import models.Inventory;
import org.openqa.selenium.WebDriver;
import webTestFramework.SeleniumControl;

import java.text.MessageFormat;
import java.util.ArrayList;

import static spark.Spark.*;
import static spark.Spark.post;

public class AutoBase extends AutoLogger {

    protected static WebDriver webDriver;
    public SeleniumControl seleniumControl;

    private WebDriverFactory webDriverFactory = new WebDriverFactory();

    public void Sleep(int seconds) throws InterruptedException{
        if(seconds > 5)
            Info(MessageFormat.format("  Sleeping for {0} seconds....", seconds));

        Thread.sleep(seconds * 1000L);
    }

    public void InitWebDriver()
    {
        webDriver = webDriverFactory.CreateSeleniumDriver();
        setWebDriver(webDriver);
    }

    public void GoToURL(String url)
    {
        this.webDriver.navigate().to(url);
        Info("Navigating to " + url);
    }

    public void RunAPIs()
    {
        Gson gson = new Gson();
        Inventory inventory = new Inventory();
        Distributors distributors = new Distributors();

        final double stockThreshold = 0.25;

        //This is required to allow GET and POST requests with the header 'content-type'
        options("/*",
                (request, response) -> {
                    response.header("Access-Control-Allow-Headers",
                            "content-type");

                    response.header("Access-Control-Allow-Methods",
                            "GET, POST");


                    return "OK";
                });

        //This is required to allow the React app to communicate with this API
        before((request, response) -> response.header("Access-Control-Allow-Origin", "http://localhost:3000"));

        //Returns JSON containing the candies for which the stock is less than 25% of it's capacity
        get("/low-stock", (request, response) -> inventory.getItemsUnderPercentCapacity(stockThreshold), gson::toJson);

        //Returns JSON containing the total cost of restocking candy
        post("/restock-cost", (request, response) -> distributors.getRestockCost(request.body()), gson::toJson);
    }

    public void Quit()
    {
        this.webDriver.quit();
    }

    public void setWebDriver(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver()
    {
        return webDriver;
    }

    public void switchToiFrame(String iFrameID)
    {
        this.webDriver = webDriver.switchTo().frame(iFrameID);
    }

    public void switchToMainFrame()
    {
        this.webDriver = webDriver.switchTo().defaultContent();
    }

    public void switchToNewlyOpenTab()
    {
        ArrayList<String> allTabs = new ArrayList<>(webDriver.getWindowHandles());
        int lastTabIndex = allTabs.size() - 1;
        this.webDriver = webDriver.switchTo().window(allTabs.get(lastTabIndex));
        Step(String.format("Switched to newest tab: %s", this.webDriver.getTitle()));
    }
}
