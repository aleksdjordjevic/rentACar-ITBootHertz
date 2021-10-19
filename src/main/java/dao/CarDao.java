package dao;

import model.model.CarModel;
import model.response.CarResponseModel;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface CarDao

{
    List<CarModel>getAllCars(String query);
    List<CarResponseModel> getAllCars ();
    //public CarResponseModel getCar();
    CarModel getCar(UUID carId);
    void delete(CarModel cm);
    List<CarModel> getAllAvaibleCars(LocalDate start_date, LocalDate end_date);
    List<CarModel> getAllAvaibleCars(LocalDate start_date, LocalDate end_date, String query);
List<String> getUnavaibleDates (UUID carId);

    CarResponseModel getCar();
}

