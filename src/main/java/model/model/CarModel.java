package model.model;

import java.util.UUID;

public class CarModel {
    UUID car_id;
    String licence_plate;
    String make;
    String model;
    int year;
    int engine_capacity;
    String color;
    double price;
    int doors;
    String size;
    int power;
    boolean automatic;
    String fuel;

    public CarModel(UUID car_id, String licence_plate, String make, String model, int year,
                    int engine_capacity, String color, double price, int doors, String size,
                    int power, boolean automatic, String fuel) {
        this.car_id = car_id;
        this.licence_plate = licence_plate;
        this.make = make;
        this.model = model;
        this.year = year;
        this.engine_capacity = engine_capacity;
        this.color = color;
        this.price = price;
        this.doors = doors;
        this.size = size;
        this.power = power;
        this.automatic = automatic;
        this.fuel = fuel;
    }

    public CarModel() {
    }

    public CarModel(CarModel car) {
    }

    public CarModel(String licence_plate, String make, String model, int year,
                    int engine_capacity, String color, double price, int doors,
                            String size, int power, boolean automatic, String fuel) {
        this.licence_plate = licence_plate;
        this.make = make;
        this.model = model;
        this.year = year;
        this.engine_capacity = engine_capacity;
        this.color = color;
        this.price = price;
        this.doors = doors;
        this.size = size;
        this.power = power;
        this.automatic = automatic;
        this.fuel = fuel;
    }

    public CarModel(int anInt, String string, String string1, String string2, int anInt1, int anInt2, String string3, double aDouble, int anInt3, String string4, int anInt4, boolean aBoolean, String string5) {
    }//novi konstruktor zbog UUID

//    public CarModel(UUID fromString, UpdateCarRequestModel carInfo) {
//
//    }

    public UUID getCar_id() {
        return car_id;
    }

    public void setCar_id(UUID car_id) {
        this.car_id = car_id;
    }

    public String getLicence_plate() {
        return licence_plate;
    }

    public void setLicence_plate(String licence_plate) {
        this.licence_plate = licence_plate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getEngine_capacity() {
        return engine_capacity;
    }

    public void setEngine_capacity(int engine_capacity) {
        this.engine_capacity = engine_capacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "car_id=" + car_id +
                ", licence_plate='" + licence_plate + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", engine_capacity=" + engine_capacity +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", doors=" + doors +
                ", size='" + size + '\'' +
                ", power=" + power +
                ", automatic=" + automatic +
                ", fuel='" + fuel + '\'' +
                '}';
    }
}
