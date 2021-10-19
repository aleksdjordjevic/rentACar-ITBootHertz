package controler;

import dao.CarDaoSQL;
import model.model.CarModel;
import model.model.UserModel;
import model.request.CarRequestModel;
import model.response.CarResponseModel;
import org.springframework.web.bind.annotation.*;
//SELECT generate_series(start_date, end_date, interval '1 day'):
// :date AS dates FROM contracts WHERE car_id = ?
import java.util.List;
import java.util.UUID;

@RestController
public class CarControler {
    private static final CarDaoSQL cd = new CarDaoSQL();
    private static final CarDaoSQL cars = new CarDaoSQL();
    private UserModel ud;


    //    @GetMapping("/cars/{carId}")
//    public CarResponseModel getCar (@PathVariable("carId") UUID id) {
//return cars.getCar(id.toString());
//    }
//1. /cars - GET
//Враћа све аутомобиле
    @GetMapping("/cars")
    public List<CarResponseModel> getAllCars() {
        return cars.getAllCars();
    }


    //2. /cars/search - GET
    @GetMapping("/cars/search/{query}")
    public List<CarModel> getCars(@PathVariable("query") String carQuery) {
        return cd.getAllCars(carQuery);
    }
//@GetMapping("/cars/search")
//public List<CarModel>searhCars (@RequestParam(required = false) String make,
//                                @RequestParam(required = false)  Integer year,
//                                @RequestParam(required = false) String model,
//                                @RequestParam(required = false) Boolean automatic,
//                                @RequestParam(required = false) Double price,
//                                @RequestParam(required = false) Integer power,
//                                @RequestParam(required = false) Integer doors){
//        return cd.searchCar(new SearchCarModel(make,year, model, automatic, price, power, doors),
//                cd.getAllCars());
//}

    
    
    
    @PatchMapping("/cars/{carId}")
    public CarResponseModel getCar(@PathVariable("carId") UUID id) {
        return cars.getCar(id.toString());
    }

//    @GetMapping("/cars/{id}")
//    public void updateCar(@PathVariable("carId") String carId,
//                          @RequestHeader("autorization") String adminId,
//                          @RequestBody UpdateCarRequestModel carInfo
//                          ){
//        if (!ud.isAdmin(UUID.fromString(adminId))) return;
//        cd.update(new CarModel(UUID.fromString(carId), carInfo));
//}

    //4. /cars/{carId} - PATCH
//    Мења аутомобил (Ово може да ради само администратор)
//    Кроз header се прослеђује id админа - https://www.baeldung.com/spring-rest-http-headers
    @PatchMapping("/cars/{carId}")
    public void adminChangeCar(@RequestHeader("autorisation") UUID adminId, CarRequestModel cr) {

    }


    //5. /cars/{carId} - DELETE
//Брише аутомобил са датим id - (Само админ)
    @DeleteMapping("/cars/{carId}")
    public CarModel deleteCars(@RequestHeader("autorisation") UUID adminId) {
        for (int i = 0; i < cars.getAllCars().size(); i++) {
//        if(i.equals(adminId){
//
//        }
        }
        return null;
    }

    //6. /cars - POST
//    Додаје нови аутомобил - (Само админ)
//    Кроз header се прослеђује id админа -
    @PostMapping("/cars")
    public CarModel addCarr(@RequestBody CarModel car) {
        try {
            UUID u = UUID.randomUUID();
            CarModel cm = new CarModel();
            cars.add(car);
            return new CarModel(car);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//    @GetMapping("/cars/avaible/search")
//    public List<GetCarResponseModel>searchCars(@RequestParam String date,
//                                               @RequestParam String endDate,
//                                               @RequestParam(),
//                                               )

}
