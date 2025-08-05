package com.defaultstatic;

interface Vehicle{
    String getBrand();
    String speedUp();
    String slowdown();
    default String turnOnAlarm(){
        return "vehicle alarm turning on";
    }
    default String turnOffAlarm(){
        return "vehicle alarm turning off";
    }
    static String getCompany(){
        return "Audi";
    }
}
class Car implements Vehicle{

    @Override
    public String getBrand() {
        return "BMW";
    }

    @Override
    public String speedUp() {
        return "car is speeding up";
    }

    @Override
    public String slowdown() {
        return "car is slowing down";
    }
}
public class DefaultStaticDemo {
    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        System.out.println(vehicle.getBrand());
        System.out.println(vehicle.speedUp());
        System.out.println(vehicle.slowdown());
        System.out.println(vehicle.turnOnAlarm());
        System.out.println(vehicle.turnOffAlarm());
        System.out.println(Vehicle.getCompany());
    }
}
