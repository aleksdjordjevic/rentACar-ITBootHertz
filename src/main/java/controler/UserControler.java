package controler;

import model.model.UserModel;
import model.response.RegisterResponseModel;
import org.springframework.web.bind.annotation.*;

@RestController                                                       //Anotacija//endpoints moze i Controler ali on vraca prikaz, neki HTML
public class UserControler {

//    @GetMapping("/users/{id}")                                           //automatski mapira u JSON
//    public GetUserResponseModel getUser (@PathVariable ("id") String id)
//    {
//    return userDaoSQL.getUser(id);
//    }
//

//        @GetMapping("/users")
//        public List<GetUserResponseModel>getAllUsers(@RequestHeader ("autorization") String id)
//    if (UserModel.isAdmin(id)){
//        return UserModel.getAllUsers();
//    }
    ///users/register - POST
//username и email морају бити јединствени
//email мора бити валидан
//username мора имати барем 3 карактера
//password мора имати барем 8 карактера, 1 број и 1 слово
//*password желимо да чувамо у бази енкриптован (на било који начин)
//@PostMapping("/users/register")
//    public RegisterResponseModel registerUser(@RequestBody UserModel userName) {
//public RegisterResponseModel register (RegisterResponseModel user){   //userSql
//    if(!user.isUniqueUser(userName.getUserName())){
//        return new RegisterResponseModel(false, "Username in use");
//    }else if (!user.isUniqueEmail(userName.getEmail())){
//        return new RegisterResponseModel(false, "Email in use");
//    }else if (user.getUserName.length()<3){
//        return new RegisterResponseModel(false, " To short User name");
//    }else if ()
//    }
//
//    else{
//        userSql.register(user);
//        return new RegisterResponseModel(true, "Username valid "+ user.getUserName);
//    }

}



}
