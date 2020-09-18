import java.util.Random;
/**
 * Write a description of class Point here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Point
{
    private double x;
    private double y;
    private int desiredOut;
    private double[] pointArr = new double[3];
    /**
     * Constructor for objects of class Point
     */
    public Point()
    {
         x = -100 + (int) (Math.random() * ((100 - (-100)) + 1)); 
         y = -100 + (int) (Math.random() * ((100 - (-100)) + 1));
        //x = (int) (Math.random()); 
        //y =(int) (Math.random());
        pointArr[0] = 1;
        pointArr[1] = x;
        pointArr[2] = y;
        //If the point is on the line, is it accepted? I counted it as accepted for now
        if(y >= 3*x){
            desiredOut = 1;
        }
        else
        {
            desiredOut = 0;
        }
    }
    
    public String toString()
    {
        return "X: " + x + " " + "Y: " + y;
    }
    
    public int getDesiredOut()
    {
        return desiredOut;
    }
    
    public double[] getPointArr(){
        return pointArr;
    }

}
