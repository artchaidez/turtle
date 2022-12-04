package unitTests;

import models.Item;
import models.Models;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class InventoryTests extends Models {

    @BeforeMethod
    public void TestSetUp()
    {
    }

    @AfterMethod
    public void TestTearDown()
    {

    }

    // TODO: create test to verify createInventory() works. It is private; change to protected?

    @Test(description = "Test createInventory() correctly retrieves all data from Inventory.xlsx")
    public void TestCreateInventoryWorks()
    {
        Step("Create a list that matches Inventory.xlsx");
            List<Item> testInventoryList = new ArrayList<>();
            testInventoryList.add(new Item("Licorice", 22, 25 ,398088));
            testInventoryList.add(new Item("Good & Plenty", 4, 20,	786123));
            testInventoryList.add(new Item("Smarties", 15, 25, 122666));
            testInventoryList.add(new Item("Tootsie Rolls", 30, 50, 977643));
            testInventoryList.add(new Item("Necco Wafers", 14,15, 366110));
            testInventoryList.add(new Item("Wax Cola Bottles", 8, 10, 172246));
            testInventoryList.add(new Item("Circus Peanuts", 10, 10, 131608));
            testInventoryList.add(new Item("Candy Corn", 30, 40, 965344));
            testInventoryList.add(new Item("Twix", 17, 70, 627791));
            testInventoryList.add(new Item("Snickers", 43, 65, 955449));
            testInventoryList.add(new Item("M&M's", 32, 55, 629741));
            testInventoryList.add(new Item("Skittles", 25, 45, 648968));
            testInventoryList.add(new Item("Starburst", 8, 45, 506709));
            testInventoryList.add(new Item("Butterfinger", 10, 60, 601091));
            testInventoryList.add(new Item("Peach Rings", 20, 30, 643281));
            testInventoryList.add(new Item("Gummy Bears", 15, 35, 850125));
            testInventoryList.add(new Item("Sour Patch Kids", 14, 60,520745));

        // TODO: Create methods to test; limit Assert usage
        Step("Verify createInventory() correctly retrieves all data from Inventory.xlsx");
            for (int index = 0; index < inventory.getInventorySize(); index++)
            {
                Assert.assertEquals(inventory.getItemNameByIndex(index), testInventoryList.get(index).getName());
                Assert.assertEquals(inventory.getItemStockByIndex(index), testInventoryList.get(index).getStock());
                Assert.assertEquals(inventory.getItemCapacityByIndex(index), testInventoryList.get(index).getCapacity());
                Assert.assertEquals(inventory.getItemIdByIndex(index), testInventoryList.get(index).getId());
            }
            Info("Confirmed data is correct");
    }

    @Test( description = "Test method getItemsUnderPercentCapacity() to verify items under 25% capacity grabbed from Inventory.xlsx")
    public void TestGetItemsUnderPercentCapacity()
    {
        Step("Create a list that should match with the real inventory after using getItemsUnderPercentCapacity()");
            List<Item> testInventoryList = new ArrayList<>();
            testInventoryList.add(new Item("Good & Plenty",4, 20, 786123));
            testInventoryList.add(new Item("Twix",17, 70, 627791));
            testInventoryList.add(new Item("Starburst",8, 45, 506709));
            testInventoryList.add(new Item("Butterfinger",10, 60, 601091));
            testInventoryList.add(new Item("Sour Patch Kids",14, 60, 520745));

        Step("Get all items under 25% capacity");
            double stockThreshold = 0.25;
            List<Item> realCapacityList =  inventory.getItemsUnderPercentCapacity(stockThreshold);

        // TODO: Create methods to test; limit Assert usage
        Step("Verify all data is correct from getItemsUnderPercentCapacity()");
            for (int index = 0; index < realCapacityList.size(); index++)
            {
                Assert.assertEquals(realCapacityList.get(index).getName(), testInventoryList.get(index).getName());
                Assert.assertEquals(realCapacityList.get(index).getStock(), testInventoryList.get(index).getStock());
                Assert.assertEquals(realCapacityList.get(index).getCapacity(), testInventoryList.get(index).getCapacity());
                Assert.assertEquals(realCapacityList.get(index).getId(), testInventoryList.get(index).getId());
            }
            Info("Confirmed all correct items retrieved using getItemsUnderPercentCapacity()");

    }

    // TODO: create you own inventory and test capacity
    // TODO: create test to verify createInventory() works. It is private; change to protected?


}
