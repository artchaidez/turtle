package unitTests;

import autoFramework.AutoBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STEdGrp;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// TODO: Complete, get endpoint to hit
public class EndPointsApiTests extends AutoBase {

    @Test
    public void TestGetLowStock() throws Exception
    {
        Step("URL STRING");
        String url = "http://localhost:4567/low-stock";
        URL obj = new URL(url);
        Step("Making connection");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // default is GET
        con.setRequestMethod("GET");
        // add request header
        con.setRequestProperty("content-type", "Access-Control-Allow-Headers");
        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();
        Info(response.toString());
    }
}
