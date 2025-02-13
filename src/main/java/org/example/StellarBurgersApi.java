package org.example;

import io.restassured.response.Response;

public class StellarBurgersApi extends BaseHttpClient{
    private String pathGetIngredients = "/api/ingredients";
    private String pathCreateOrders = "/api/orders";
    private String pathCreateUser = "/api/auth/register";
    private String pathLogin = "/api/auth/login";
    private String pathGetUserInfo = "/api/auth/user";
    private String pathUpdateUserInfo = "/api/auth/user";
    private String pathDeleteUser = "/api/auth/user";
    private String pathGetUserOrders = "/api/orders";

    public Response doGetIngredients(){
        return doGetRequest(pathGetIngredients);
    }

    public Response doPostCreateOrders(Object object, String token){
        return doPostRequest(pathCreateOrders, object, token);
    }

    public Response doPostCreateUser(Object object){
        return doPostRequest(pathCreateUser, object);
    }

    public Response doPostLogin(Object object){
        return doPostRequest(pathLogin, object);
    }

    public Response doGetUserInfo(String token){
        return doGetUserInfo(pathGetUserInfo, token);
    }

    public Response doGetUserOrders(String token){
        return doGetUserOrders(pathGetUserOrders, token);
    }

    public Response doPatchRequest(Object object, String token){
        return doPatchUpdateUserInfo(pathUpdateUserInfo, object, token);
    }

    public Response doDeleteUser(String token){
        return doDeleteRequest(pathDeleteUser, token);
    }

}
