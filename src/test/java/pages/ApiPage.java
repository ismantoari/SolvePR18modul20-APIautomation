package pages;

import Helper.Endpoint;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.RestUtil;
import java.io.File;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static utility.RestUtil.*;


public class ApiPage {

    String setURL, id_user;
    public static String idUser;

    Response res;
    private static RequestSpecification req;


    public void urlForExecute(String url) {
         switch (url) {
            case "GET_LIST_USERS":
                setURL = Endpoint.GET_LIST_USERS;
                System.out.println("setURL : " + setURL);
                break;
            case "CREATE_NEW_USERS":
                setURL = Endpoint.CREATE_NEW_USERS;
                System.out.println("setURL : " + setURL);
                break;
            case "UPDATE_USERS":
                setURL = Endpoint.UPDATE_USERS;
//                break;
//            case "DELETE_USERS":
//                setURL = Endpoint.DELETE_USER;
//                break;
            default:
                System.out.println("input correct url");
        }
    }


    public void apiToGetListUsers() {
        res = getListUsers(setURL);
        System.out.println("respnse body: " + res.getBody().asString());
    }

     public static Response getListUsers(String endpoint) {
         headersNoAuth();
         //req = request;
         // req = RestAssured.given();
       return request.when().get(endpoint);
       }

    public void validationStatusCode(int statusCode){
        assertThat(res.statusCode()).isEqualTo(statusCode);
        System.out.println("status code : "+ res.statusCode());
    }

    public void validationResponseBodyGetListUsers(){
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female","male");
        assertThat(status.get(0)).isIn("active","inactive");

    }

    public void validationResponseJsonWithJSONSchema(String filename){
        File JSONFile = RestUtil.getJSONSchemaFile(filename);
        // File JSONFile = new File("src/test/java/utility/JSONSchemaData/"+filename);
        System.out.println("JSONFilenya : "+JSONFile);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void apiToCreateNewUsers(){
        res = CreateNewUsers(setURL);
        System.out.println(res.getBody().asString());
    }

    public void ApiToCreateNewUsersWithoutName(){
        res= CreateNewUsersWithoutName(setURL);
        System.out.println(res.getBody().asString());
    }



    public void validationResponseBodyCreateNewUsers(){
        int id = res.jsonPath().get("id");
        String name = res.jsonPath().get("name");
        String email = res.jsonPath().get("email");
        String gender = res.jsonPath().get("gender");
        String status = res.jsonPath().get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female","male");
        assertThat(status).isIn("active","inactive");

        id_user = Integer.toString(id);
        idUser = id_user;
    }



public void ApiToUpdateUsers(){
    System.out.println("id yang akan di update : " + id_user);
    res = RestUtil.updateUser(setURL,id_user);
    System.out.println("update data : " +res.getBody().asString());
}

    public void ApiToUpdateUsersWithoutName(){
        res= UpdateUsersWithoutName(setURL,id_user);
        System.out.println(res.getBody().asString());
    }

    public void ApiToUpdateUsersWithStatusNA(){
        res= UpdateUsersWithStatusNA(setURL,id_user);
        System.out.println(res.getBody().asString());
    }

public void validationResponseBodyUpdateUser(){
    int id = res.jsonPath().get("id");
    String name = res.jsonPath().get("name");
    String email = res.jsonPath().get("email");
    String gender = res.jsonPath().get("gender");
    String status = res.jsonPath().get("status");

    assertThat(id).isNotNull();
    assertThat(name).isNotNull();
    assertThat(email).isNotNull();
    assertThat(gender).isIn("female","male");
    assertThat(status).isIn("active","inactive");
}

public void apiToDeleteUsers(){
    System.out.println("id yang akan di delete : " + id_user);
    res = RestUtil.deleteUser(setURL,id_user);

}

}
