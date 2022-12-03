package unitTests;

// TODO: extend to a class containing all the java classes

import models.Item;
import models.Models;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class TopBlocModelsTests extends Models {

    @BeforeMethod
    public void TestSetUp()
    {
    }

    @AfterMethod
    public void TestTearDown()
    {
        Quit();
    }

    @Test
    public void TestInventory()
    {
        Step("Get all items under 25% capacity");
        List<Item> capacityList =  inventory.getItemsUnderPercentCapacity(25);

    }
}
