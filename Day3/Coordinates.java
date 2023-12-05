package Day3;

public class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){return x;}
    public int getY(){return y;}

    @Override
    public String toString(){
        return this.x+","+this.y;
    }

    @Override
    public boolean equals(Object object){
        Coordinates coordinate = (Coordinates) object;
        if (this.x == coordinate.x && this.y == coordinate.y){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        int tmp = (this.y + ((this.x+1)/2));
        return this.x + (tmp * tmp);
    }
}
