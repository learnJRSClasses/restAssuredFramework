package Utills;

import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class RestAssuredUtills {

    public static Response perfromPost(String endpoint, String Body, Map<String, String> Heards)
    {
        return RestAssured.given().log().all()
                .baseUri(endpoint).body(Body).headers(Heards).post()
                .then().log().all().extract().response() ;

    }

    public static Response perfromget(String endpoint)
    {
        return RestAssured.given().log().all()
                .baseUri(endpoint).get()
                .then().log().all().extract().response();

    }

   /* @Test
    public void createMap()
    {
        Map<String,String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer ACCESS-TOKEN");

    }*/
}

//Endpoint - URl
//Body
//Headers
//Cookies
//JWT


