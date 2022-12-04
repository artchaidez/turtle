package unitTests;

import models.Distributor;
import models.Item;
import models.Models;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DistributorTests extends Models {

    @BeforeMethod
    public void TestSetUp()
    {

    }

    @AfterMethod
    public void TestTearDown()
    {

    }

    // TODO: Create methods to test; limit Assert usage
    @Test(description = "Test getCheapestCost will return cost if item exists.")
    public void TestGetCheapestCostExists()
    {
        Step("Create fields for the cheapest item that should be returned by getCheapestCost()");
            String name = "Art's Sweets";
            String cheapestItemName = "Good & Plenty";
            int cheapestItemID = 786123;
            Double cheapestItemCost = 0.18;

        Step("Create Distributor and give the company Items");
        // TODO: make these fields
            Distributor company = new Distributor(name);
            company.addItem(new Item("Twix", 627791, 0.54));
            company.addItem(new Item("Starburst", 506709, 0.77));
            company.addItem(new Item(cheapestItemName, cheapestItemID, cheapestItemCost));
            company.addItem(new Item("Butterfinger", 601091, 0.93));
            company.addItem(new Item("Sour Patch Kids", 520745, 0.85));

        Step(String.format("Verify getCheapestCost() retrieves '%s' and returns %f", cheapestItemName, cheapestItemCost));
            Assert.assertEquals(company.getCheapestCost(cheapestItemName), cheapestItemCost);
            Info(String.format("Confirmed lowest cost was '%s' at %f", cheapestItemName, cheapestItemCost));
    }

    @Test(description = "Test getCheapestCost will return DOUBLE.MAX_VALUE if item does not exist.")
    public void TestGetCheapestCostDoesNotExist()
    {
        Step("Create Item name that will not be sold by Distributor");
            String itemNotSoldByDistributor = "Good & Plenty";

        Step("Create a list of costs that will not be returned");
            List<Double> costList = new ArrayList<>();
            costList.add(0.54);
            costList.add(0.77);
            costList.add(0.93);
            costList.add(0.85);

        Step("Create Distributor and give the company Items");
            Distributor company = new Distributor("Art's Sweets");
            for (int index = 0; index < costList.size(); index++)
            {
                String itemName = "Item " + costList.get(index);
                int itemId = index;
                company.addItem(new Item(itemName, itemId, costList.get(index)));
            }

        Step("Verify getCheapestCost() returns DOUBLE.MAX_VALUE");
            Assert.assertEquals(company.getCheapestCost(itemNotSoldByDistributor), Double.MAX_VALUE);
            Info("Confirmed DOUBLE.MAX_VALUE was returned");
    }

    // TODO: test addItem() ?
}
