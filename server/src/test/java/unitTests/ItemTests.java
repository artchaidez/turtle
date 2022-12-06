package unitTests;

import models.Item;
import models.Models;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends Models {

    @BeforeMethod
    public void TestSetUp()
    {

    }

    @AfterMethod
    public void TestTearDown()
    {
        ResetSteps();
    }

    @Test( description = "Test Item(String name, int id, double cost) and all its methods")
    public void TestItemWithThreeArguments()
    {
        Step("Create fields for Item");
            String name = "SweetTart Ropes";
            int id = 12345;
            Double cost = 1.50;

        Step("Use fields to create new Item");
            Item candy = new Item(name, id, cost);

        Step("Verify Item methods get correct data");
            Assert.assertEquals(candy.getName(), name);
            Assert.assertEquals(candy.getId(), id);
            Assert.assertEquals(candy.getCost(), cost);
            Info("All methods return correct data");
    }

    @Test( description = "Test Item(String name, int stock, int capacity, int id) and all its methods")
    public void TestItemWithFourArguments()
    {
        Step("Create fields for Item");
            String name = "SweetTart Ropes";
            int stock = 20;
            int capacity = 100;
            int id = 12345;

        Step("Use fields to create new Item");
            Item candy = new Item(name, stock, capacity, id);

        Step("Verify Item methods get correct data");
            Assert.assertEquals(candy.getName(), name);
            Assert.assertEquals(candy.getStock(), stock);
            Assert.assertEquals(candy.getCapacity(), capacity);
            Assert.assertEquals(candy.getId(), id);
            Info("All methods return correct data");
    }
}
