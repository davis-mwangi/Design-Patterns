/*
The Adapter is a structural design pattern that allows incompatible interfaces 
to work together. It wraps an existing class with 
a new interface so that it becomes compatible with the client's interface.

*/

class SquareHole{
    private double sideLength;
   
    public SquareHole(double sideLength){
        this.sideLength = sideLength;
    }

    public boolean canFit(Square square){
        return this.sideLength >=  square.getSideLength();
    }
}


class Square {
    private double sideLength;
   
    public Square(double sideLength){
        this.sideLength = sideLength;
    }

    public double getSideLength(){
        return this.sideLength;
    }
}

class Circle {
    
    private double radius;
   
    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }
}

class CircleToSquareAdapter  extends Square {

    private Circle circle;
  
    public CircleToSquareAdapter(Circle circle){
         this.circle = circle;
    }

    @Override
    public double getSideLength(){
        return  2 *  this.circle.getRadius();
    }


}

class Main {
    SquareHole squareHole = new SquareHole(5);

    Square square = new Square(6);
    squareHole.canFit(square);            // false

    Circle circle = new Circle(2);
    CircleToSquareAdapter circleAdapter = new CircleToSquareAdapter(circle);
    squareHole.canFit(circleAdapter);     // true

}
