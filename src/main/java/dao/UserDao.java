package dao;

import model.model.UserModel;
import model.request.LoginRequestModel;
import model.request.RegisterRequestModel;
import model.response.LoginResponseModel;
import model.response.RegisterResponseModel;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    RegisterResponseModel registerUser(RegisterRequestModel rrm);
    LoginResponseModel loginUser (LoginRequestModel lrm);
    LoginResponseModel update (UserModel um);
    UserModel getUser(UUID userId);
    List<UserModel> getAllUsers();
    Boolean IsAdmin(UUID userId);
}
