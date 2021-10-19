package dao;

import model.model.CarModel;
import model.response.CarResponseModel;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarDaoSQL implements CarDao {
    private static final Connection conn = DatabaseConnection.getConnection();


    @Override
    public List<CarModel> getAllCars(String query) {
        List<CarModel> allCars = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT FROM CARS WHERE");
            while (rs.next()) {
                CarModel newCar = new CarModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getDouble(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getBoolean(12),
                        rs.getString(13)
                );

                allCars.add(newCar);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allCars;
    }
    @Override
    public List<CarResponseModel> getAllCars() {
        List<CarModel> allCars = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CARS");
            while (rs.next()) {
                CarModel newCar = new CarModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getDouble(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getBoolean(12),
                        rs.getString(13)
                );

                allCars.add(newCar);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allCars;
    }

    @Override
    public CarModel getCar(UUID carId) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cars WHERE carId = " + carId);
            if (rs.next()) {
                return new CarModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getDouble(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getBoolean(12),
                        rs.getString(13)
                );
            } else {
                System.out.println("No results");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(CarModel cm) {

        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM cars WHERE car_id = ?");
            st.setString(1, cm.getCar_id().toString());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public List<CarModel> getAllAvaibleCars(LocalDate start_date, LocalDate end_date) {
        return null;
    }

    @Override
    public List<CarModel> getAllAvaibleCars(LocalDate start_date, LocalDate end_date, String query) {
        return null;
    }

    @Override
    public List<String> getUnavaibleDates(UUID carId) {
        return null;
    }

    @Override
    public CarResponseModel getCar() {
        return null;
    }

    public void add(CarModel car) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO CARS" +
                    "VALUES ( ?,?,?,?,?,?,?,?,?,?,?,?,?");
            st.setString(1, car.getCar_id().toString());
            st.setString(2, car.getLicence_plate());
            st.setString(3, car.getMake());
            st.setString(4, car.getModel());
            st.setInt(5, car.getYear());
            st.setInt(6, car.getEngine_capacity());
            st.setString(7, car.getColor());
            st.setDouble(8, car.getPrice());
            st.setInt(9, car.getDoors());
            st.setString(10, car.getSize());
            st.setInt(11, car.getPower());
            st.setBoolean(12, car.isAutomatic());
            st.setString(13, car.getFuel());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public CarResponseModel getCar(String toString) {

        return null;
    }


    public List<CarModel>searhCars(){
        return null;
    }


}
