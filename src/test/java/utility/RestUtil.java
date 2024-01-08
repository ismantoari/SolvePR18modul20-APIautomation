package utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import java.io.File;

public class RestUtil {

    public static RequestSpecification request;
    public static void headersNoAuth(){
        request = RestAssured.given()
       .header("Content-type","application/json")
       .header("Accept","application/json");
    }

    public static void headersAuth(){
        request = RestAssured.given()
                .header("Content-type","application/json")
                .header("Accept","application/json")
                .header("Authorization","Bearer abf32e8f18c51e3f627a2db1d23609a46527883be37b1cdf73f68841c852ac12");
       }


    public static Response CreateNewUsers(String alamat){
        String name = "Ari Sragen";
        String gender = "male";
        String email = randomEmail();
        String status = "active";

        JSONObject bodyReq = new JSONObject();

        bodyReq.put("name",name);
        bodyReq.put("gender",gender);
        bodyReq.put("email",email);
        bodyReq.put("status",status);

        headersAuth();
        return request.body(bodyReq.toString()).when().post(alamat);
    }

    public static Response CreateNewUsersWithoutName(String URL){
        //String name = "Ari Sragen";
        String gender = "male";
        String email = randomEmail();
        String status = "active";

        JSONObject bodyReq = new JSONObject();

        //bodyReq.put("name",name);
        bodyReq.put("gender",gender);
        bodyReq.put("email",email);
        bodyReq.put("status",status);

        headersAuth();
        return request.body(bodyReq.toString()).when().post(URL);
    }





    public static File getJSONSchemaFile(String JSONFile){
        return new File("src/test/java/utility/JSONSchemaData/"+JSONFile);
    }

    public static String randomEmail(){
        //String allowedChars = "abcdefghijklmnopqrstuvwxyz"+"1234567890"+"_";
        String email;
        String temp = RandomStringUtils.randomAlphanumeric(5);//panjang email 5 karakter
        email = temp + "@arisaja.com";
        return email;

    }

 public static Response updateUser (String endpoint, String id_user){

     String updateEndpoint= endpoint +"/"+id_user;

     String name = "Ari Edit";
     String email = randomEmail();
     String gender = "male";
     String status = "active";
     JSONObject payload = new JSONObject();

     payload.put("name",name);
     payload.put("gender",gender);
     payload.put("email",email);
     payload.put("status",status);

     headersAuth();

    return request .body(payload.toString())
            .when()
            .patch(updateEndpoint);
    }

    public static Response UpdateUsersWithoutName(String endpoint, String id_user){
        String updateEndpoint= endpoint +"/"+id_user;

        //String name = "Ari Edit";
        String email = randomEmail();
        String gender = "male";
        String status = "active";
        JSONObject payload = new JSONObject();

        //payload.put("name",name);
        payload.put("gender",gender);
        payload.put("email",email);
        payload.put("status",status);

        headersAuth();

        return request .body(payload.toString())
                .when()
                .patch(updateEndpoint);
    }

    public static Response UpdateUsersWithStatusNA(String endpoint,String id_user){
        String updateEndpoint= endpoint +"/"+id_user;

        String name = "Ari Edit";
        String email = randomEmail();
        String gender = "male";
        String status = "NA";
        JSONObject payload = new JSONObject();

        payload.put("name",name);
        payload.put("gender",gender);
        payload.put("email",email);
        payload.put("status",status);

        headersAuth();

        return request .body(payload.toString())
                .when()
                .patch(updateEndpoint);
    }

    public static Response deleteUser(String endpoint, String id_user){
        String deleteEndpoint= endpoint +"/"+id_user;
        headersAuth();
        return request
                .when()
                .delete(deleteEndpoint);

    }
}
