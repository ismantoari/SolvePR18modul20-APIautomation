package StepDef;

import pages.ApiPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ApiStep {
    ApiPage apiPage = new ApiPage();

    @Given("url for {string}")
    public void urlFor(String urlGiven) {
        apiPage.urlForExecute(urlGiven);
    }

    @And("hit api to get list users")
    public void hitApiToGetListUsers() {
        apiPage.apiToGetListUsers();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int statusCode) {
        apiPage.validationStatusCode(statusCode);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validationResponseBodyGetListUsers();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String filename) {
        apiPage.validationResponseJsonWithJSONSchema(filename);
    }

    @And("hit api to create new users")
    public void hitApiToCreateNewUsers() {
        apiPage.apiToCreateNewUsers();
    }


    @Then("validation response body create new users")
    public void validationResponseBodyCreateNewUsers() {
        apiPage.validationResponseBodyCreateNewUsers();
    }

    @And("hit api to update users")
    public void hitApiToUpdateUsers() {
        apiPage.ApiToUpdateUsers();
    }

    @Then("validation response body update user")
    public void validationResponseBodyUpdateUser() {
        apiPage.validationResponseBodyUpdateUser();
    }

    @And("hit api to delete users")
    public void hitApiToDeleteUsers() {
        apiPage.apiToDeleteUsers();
    }

    @And("hit api to create new users without name")
    public void hitApiToCreateNewUsersWithoutName() {
        apiPage.ApiToCreateNewUsersWithoutName();
    }


    @And("hit api to update users without name")
    public void hitApiToUpdateUsersWithoutName() {
        apiPage.ApiToUpdateUsersWithoutName();
    }

    @And("hit api to update users with status NA")
    public void hitApiToUpdateUsersWithStatusNA() {
        apiPage.ApiToUpdateUsersWithStatusNA();
    }
}
