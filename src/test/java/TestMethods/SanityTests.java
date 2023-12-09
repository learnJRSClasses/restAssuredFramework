package TestMethods;

import Utills.RestAssuredUtills;
import Utills.jsonUtill;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SanityTests {

    @Test
    public void testGetAPI_Response()
    {
        String endPoint = "https://petstore.swagger.io/v2/pet/findByStatus?status=sold" ;
        Response res = RestAssuredUtills.perfromget(endPoint);
        Assert.assertEquals(res.statusCode(), 200);
    }

    @Test
    public void testPostAPI_Response() throws IOException {
        Map<String,String> endPoint = jsonUtill.getPayload("/endpoints.json");
        String data = endPoint.get("postEndPoint");

        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response res = RestAssuredUtills.perfromPost(data , body, new HashMap<>());
        Assert.assertEquals(res.statusCode(), 201);

    }

    /*@Test
    public void testPutAPI_Response() throws IOException {
        Map<String,String> endPoint = jsonUtill.getPayload("/endpoints.json");
        String data = endPoint.get("putEndPoint");

        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response res = RestAssuredUtills.perfromPost(data , body, new HashMap<>());
        Assert.assertEquals(res.statusCode(), 201);

    }*/


}
