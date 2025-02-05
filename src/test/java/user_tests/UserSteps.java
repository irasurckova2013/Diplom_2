package user_tests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.StellarBurgersApi;

public class UserSteps {
    private StellarBurgersApi stellarBurgersApi = new StellarBurgersApi();

    //Создание пользователя:
    @Step("Создание уникального пользователя")
    public Response createUser(){
        return stellarBurgersApi.doPostCreateUser(UserTestData.bodyPostUniqueData());
    }

    @Step("Создание пользователя, который уже зарегистрирован")
    public Response createExistUser(){
        return stellarBurgersApi.doPostCreateUser(UserTestData.bodyPost());
    }

    @Step("Создание пользователя без одного из обязательных полей")
    public Response createUserNotFullData(){
        return stellarBurgersApi.doPostCreateUser(UserTestData.bodyPostNotFullData());
    }
    //Логин пользователя:
    @Step("Логин под существующим пользователем")
    public Response loginUser(){
        return stellarBurgersApi.doPostLogin(UserTestData.doPostLogin());
    }

    @Step("Логин с неверным логином и паролем")
    public Response loginWithIncorrectDataUser(){
        return stellarBurgersApi.doPostLogin(UserTestData.doPostLoginWithIncorrectDataUser());
    }

    //Изменение данных пользователя:
    @Step("Получение информации о пользователе")
    public Response getUserData(String token){
        return stellarBurgersApi.doGetUserInfo(token);
    }

    @Step("Изменение информации о пользователе")
    public Response patchUpdateUserData(String token){
        return stellarBurgersApi.doPatchRequest(UserTestData.doUpdateUserData(), token);
    }

    //Удаление пользователя

    @Step("Проверка, что пользователя не существует")
    public boolean checkingThatNoUser() {
        return stellarBurgersApi.doPostLogin(UserTestData.bodyPostUniqueData()).getStatusCode() != 200;
    }

    @Step("Удалить пользователя, если он существует")
    public void deleteUserIfExist() {
        if(!checkingThatNoUser()) {
            Response postLogin = createUser();
            String accessToken = postLogin.jsonPath().getString("accessToken");
            stellarBurgersApi.doDeleteUser(accessToken);
        }

    }

}
