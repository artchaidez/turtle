package unitTests;

import models.Models;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DistributorsTests extends Models {

    @BeforeMethod
    public void TestSetup()
    {

    }

    @AfterMethod
    public void TestTearDown()
    {

    }

    // TODO: create test to verify createDistributors() works. It is private; change to protected?

    // TODO: Create methods to test; limit Assert usage
    @Test( description = "Test getRestockCost(String body) retrieves correct data")
    public void TestGetRestockCost()
    {
        Step("Create json with data of inventory below 25% capacity that needs to be restocked");
            String lowStockjson = "[{'name':'Good & Plenty','stock':4,'capacity':20,'cost':16,'id':786123}," +
                    "{'name':'Twix','stock':17,'capacity':70,'cost':53,'id':627791}," +
                    "{'name':'Starburst','stock':8,'capacity':45,'cost':37,'id':506709}," +
                    "{'name':'Butterfinger','stock':10,'capacity':60,'cost':50,'id':601091}," +
                    "{'name':'Sour Patch Kids','stock':14,'capacity':60,'cost':46,'id':520745}]";

        Step("Create Double with the correct cost to restock inventory");
            Double costToRestock = 119.69;
            Info(String.format("Cost should be $%.2f", costToRestock));

        Step("Verify getRestockCost() returns correct cost amount");
            Assert.assertEquals(distributors.getRestockCost(lowStockjson), costToRestock);
            Info(String.format("Confirmed getRestockCost() returned $%.2f", costToRestock));
    }

    // TODO: pass in bad JSON to it fail


}
