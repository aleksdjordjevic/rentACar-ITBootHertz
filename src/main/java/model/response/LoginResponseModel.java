package model.response;

import java.util.UUID;

public class LoginResponseModel {
    private boolean successful;
    private UUID user_id;

    public LoginResponseModel(boolean successful, UUID user_id) {
        this.successful = successful;
        this.user_id = user_id;
    }

    public boolean isSuccessful(){
        return successful;
    }

    public UUID getUser_id() {
        return user_id;
    }
}
