package unitTests;

import models.Models;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static spark.Spark.post;

public class DistributorsTests extends Models {

    @BeforeMethod
    public void TestSetup()
    {

    }

    @AfterMethod
    public void TestTearDown()
    {

    }

    // TODO: Create methods to test; limit Assert usage
    // getRestockCost(String body)
    @Test( description = "Test getRestockCost(String body) retrieves correct data")
    public void TestGetRestockCost()
    {
        String json = "[{\"name\":\"Good & Plenty\",\"stock\":4,\"capacity\":20,\"cost\":0,\"id\":786123},{\"name\":\"Twix\",\"stock\":17,\"capacity\":70,\"cost\":0,\"id\":627791},{\"name\":\"Starburst\",\"stock\":8,\"capacity\":45,\"cost\":0,\"id\":506709},{\"name\":\"Butterfinger\",\"stock\":10,\"capacity\":60,\"cost\":0,\"id\":601091},{\"name\":\"Sour Patch Kids\",\"stock\":14,\"capacity\":60,\"cost\":0,\"id\":520745}]";
        // TODO: create JSON String to give to the method
        //distributors.getRestockCost()
    }


}
