package model.request;

public class LoginRequestModel {
private String user_id;
private String password;

    public LoginRequestModel(String user_id, String password) {
        this.user_id = user_id;
        this.password = password;
    }
}
