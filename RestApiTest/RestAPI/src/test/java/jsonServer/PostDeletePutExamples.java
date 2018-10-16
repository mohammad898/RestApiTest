package jsonServer;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostDeletePutExamples {
    @Test
    public void postTest() {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", 101);
        jsonObject.put("title", "Java Developer");
        jsonObject.put("author", "Mohammad Haque");

        request.body(jsonObject.toJSONString());
        Response response = request.post("http://localhost:3000/posts");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
    }

    @Test
    public void deletePost() {
        RequestSpecification request = RestAssured.given();

        Response response = request.delete("http://localhost:3000/posts/82");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }

    @Test
    public void putPost() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();


        jsonObject.put("id", 102);
        jsonObject.put("title", ".Net Devoloper");
        jsonObject.put("author", "Mohammad Rahman");

        request.body(jsonObject.toJSONString());
        Response response = request.put("http://localhost:3000/posts/102");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
    @Test
    public void putNullPost() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject jsonObject = new JSONObject();


        jsonObject.put("id", 103);
        jsonObject.put("title", "JavaScript Developer");
        jsonObject.put("author", "Haque");

        request.body(jsonObject.toJSONString());
        Response response = request.put("http://localhost:3000/posts/103");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404);
    }
}
