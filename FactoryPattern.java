/*
Implement the Factory Method design pattern.

The Factory Method is a creational design pattern that provides an interface 
for creating objects in a superclass but allows subclasses to alter the type 
of objects that will be created.
*/

interface Vehicle {
    String getType();
}

class Car implements Vehicle{
    @Override
    public String getType(){
        return "Car";
    }
}

class Bike implements Vehicle{
    @Override
    public String getType(){
        return "Bike";
    }
}

class Truck implements Vehicle{
    @Override
    public String getType(){
        return "Truck";
    }
}

//Factory Classes
abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle(){
        return new Car();
    }
}


class BikeFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle(){
        return new Bike();
    }
}


class TruckFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle(){
        return new Truck();
    }
}


//Main
class Main {
    public static void  main(String [] args){
       VehicleFactory carFactory =  new CarFactory();
       VehicleFactory truckFactory =  new TruckFactory();
       VehicleFactory bikeFactory = new BikeFactory();

       Vehicle myCar =  carFactory.createVehicle();
       Vehicle myTruck =  truckFactory.createVehicle();
       Vehicle myBike =  bikeFactory.createVehicle();

       myCar.getType(); // "Car"
       myTruck.getType(); // "Truck"
       myBike.getType(); // "Bike"

    }
}