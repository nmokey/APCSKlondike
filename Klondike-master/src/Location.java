public class Location {
    private double x, y;
    public Location(double x, double y){
        this.x=x;
        this.y=y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public Location incrementLoc(Location original, int stackIndex){
        return new Location(original.x, original.y+15*stackIndex);
    }
}