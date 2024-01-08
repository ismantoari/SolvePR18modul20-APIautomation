@api
Feature: Test Automation Rest API

  #test get data user
  @apiGetUser
    Scenario: Test get list data user
      Given url for "GET_LIST_USERS"
      And hit api to get list users
      Then validation status code is equals 200
      Then validation response body get list users
      Then validation response json with JSONSchema "get_list_users.json"
#Test Case Create New User (Positive)
  @apiCreateUser
    Scenario: Test create new user
      Given url for "CREATE_NEW_USERS"
      And hit api to create new users
      Then validation status code is equals 201
      Then validation response body create new users
      Then validation response json with JSONSchema "post_new_users.json"

#Test Case Create New User - without name (Negative)
  @apiCreateUserNegative
  Scenario: Test create new without name
    Given url for "CREATE_NEW_USERS"
    And hit api to create new users without name
    Then validation status code is equals 422
    Then validation response json with JSONSchema "post_new_users_without_name.json"

#Test Case Update user Name / Patch User Name (Positive)
  @apiUpdateUser
  Scenario: Test update user name
    Given url for "CREATE_NEW_USERS"
    And hit api to create new users
    Then validation status code is equals 201
    Then validation response body create new users
    And hit api to update users
    Then validation status code is equals 200
    Then validation response body update user


#Test Case Update (Patch) edge test -"Status edge : active / inactive, filled by NA"  (Negative Edge Test)
  @apiUpdateUserEdgeNegative
  Scenario: Test update users status NA
    Given url for "CREATE_NEW_USERS"
    And hit api to create new users
    Then validation status code is equals 201
    Then validation response body create new users
    And hit api to update users with status NA
    Then validation status code is equals 422
    Then validation response json with JSONSchema "patch_users_with_status_NA.json"

#Test Delete User
  @apiDeleteUser
  Scenario: Test delete users
    Given url for "CREATE_NEW_USERS"
    And hit api to create new users
    Then validation status code is equals 201
    Then validation response body create new users
    And hit api to delete users
    Then validation status code is equals 204
