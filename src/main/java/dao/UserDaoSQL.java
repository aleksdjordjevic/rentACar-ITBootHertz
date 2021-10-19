package dao;

import model.model.UserModel;
import model.request.LoginRequestModel;
import model.request.RegisterRequestModel;
import model.response.LoginResponseModel;
import model.response.RegisterResponseModel;

import java.util.List;
import java.util.UUID;

public class UserDaoSQL implements  UserDao{
    @Override
    public RegisterResponseModel registerUser(RegisterRequestModel rrm) {
        return null;
    }

    @Override
    public LoginResponseModel loginUser(LoginRequestModel lrm) {
        return null;
    }

    @Override
    public LoginResponseModel update(UserModel um) {
        return null;
    }

    @Override
    public UserModel getUser(UUID userId) {
        return null;
    }

    public List<UserModel> getAllUsers() {
        return null;
    }

    @Override
    public Boolean IsAdmin(UUID userId) {
        return null;
    }
}
