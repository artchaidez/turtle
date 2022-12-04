package unitTests;

import models.Item;
import models.Models;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class inventoryTests extends Models {

    @BeforeMethod
    public void TestSetUp()
    {
    }

    @AfterMethod
    public void TestTearDown()
    {

    }

    //TODO: create test to verify createInventory() works. It is private; change to protected?

    @Test( description = "Test method getItemsUnderPercentCapacity() to verify items under 25% capacity grabbed from Inventory.xlsx")
    public void TestGetItemsUnderPercentCapacity()
    {
        Step("Create list that should match with the real capacity list");
            List<Item> testCapacityList = new ArrayList<>();
            testCapacityList.add(new Item("Good & Plenty",4, 20, 786123));
            testCapacityList.add(new Item("Twix",17, 70, 627791));
            testCapacityList.add(new Item("Starburst",8, 45, 506709));
            testCapacityList.add(new Item("Butterfinger",10, 60, 601091));
            testCapacityList.add(new Item("Sour Patch Kids",14, 60, 520745));

        Step("Get all items under 25% capacity");
            List<Item> realCapacityList =  inventory.getItemsUnderPercentCapacity(.25);

        // TODO: change assertions to methods comparisons
        for (int index = 0; index < realCapacityList.size(); index++)
        {
            Assert.assertEquals(realCapacityList.get(index).getName(), testCapacityList.get(index).getName());
            Assert.assertEquals(realCapacityList.get(index).getStock(), testCapacityList.get(index).getStock());
            Assert.assertEquals(realCapacityList.get(index).getCapacity(), testCapacityList.get(index).getCapacity());
            Assert.assertEquals(realCapacityList.get(index).getId(), testCapacityList.get(index).getId());

        }

    }

    // TODO: create you own inventory and test capacity

}
