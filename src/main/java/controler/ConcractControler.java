package controler;

import dao.ContractDaoSQL;
import dao.UserDaoSQL;
import model.model.ContractModel;
import model.response.ContractSampleRequestModel;
import model.response.ContractSampleResponseModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
public class ConcractControler {
    ContractDaoSQL cd = new ContractDaoSQL();
    UserDaoSQL ud = new UserDaoSQL();
    private Object sample;


    //  1. /contracts/sample - POST
//Враћа нацрт уговора који клијент може да потпише и пошаље на одобравање
//@PostMapping
//public ContractSampleResponseModel addContract(@RequestBody ContractSampleRequestModel contract){
//    return new ContractSampleResponseModel (sample.getUserId(), sample.getCarId(), sample.getStartDate(), sample.getEndDate())
//
//}


//  2. contracts - POST

//Ово је нека врста резервације датума за клијента
//Након овога, администратор или одбија или одобрава
//Одбијање уговора значи брисање из базе (описано касније)
//Клијент може да има највише један уговор на чекању

//Додаје нови уговор (Клијент)
@PostMapping("users/contracts")
    public ContractModel addContract (@RequestBody ContractModel contract) {

return new ContractModel();
}
//3. /contracts - GET
//Администратори могу да виде све уговоре
//@GetMapping ("/contracts")
//    public List<ContractModel> getAllContracts(@RequestHeader("idAdmin") UUID id){
//    for (var i : ud.getAllUsers()) {
//        if(i.isAdmin() && i.getUser_id.equals(id))
//            return cd.getAllContracts();
//    }
//    return null;
}
//Кроз header се прослеђује id админа -

@GetMapping("/contracts/{user_id}/history")
    public List<ContractModel> getHistoryContracts (@PathVariable ("user_id") UUID user_id){
    return cd.getHistoryContracts(user_id);
}






}
