package Day3;

import java.util.List;

public class Coordinates {
    private final int x; //this define the LEFTMOST digit in the number
    private final int y;
    private final int length; //the number of digits in the number
    private final int number; //the actual number lol
    private final boolean symbolAttached;

    public Coordinates(int x, int y, int length, int number){
        this.x = x;
        this.y = y;
        this.length = length;
        this.symbolAttached = false;
        this.number = number;
    }

    public Coordinates(int x, int y, int length, boolean symbolAttached, int number){
        this.x = x;
        this.y = y;
        this.length = length;
        this.symbolAttached = symbolAttached;
        this.number = number;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public int getLength(){return length;}
    public boolean getSymbolAttached(){return symbolAttached;}
    public int getNumber(){return number;}

    public boolean isSymbolAttached(List<String> input){
        boolean hasSymbol = false;
        //use own x+y coords + length to find the surrounding chars in the input to find out.


        return hasSymbol;
    }

    public boolean within(int x, int y){
        boolean isIn = false;
        if (y == this.y && this.x <= x && x <=this.x+(length-1) ){ //if y=y and x coord is within bound of the length than then umber is within
            isIn = true;
        }
        return isIn;
    }

    @Override
    public String toString(){
        return this.x+","+this.y+":"+this.length;
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
