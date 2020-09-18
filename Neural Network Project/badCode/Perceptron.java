import java.util.Random;
import java.util.Scanner;
/**
 * Write a description of class Perceptron here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Perceptron
{
    // instance variables - replace the example below with your own
    private double[] weights;
    private int size;
    private Random rand =new Random();
    private double learningRate;
    private double bias;
    private double localSum;
    public Perceptron(int inputSize, double rate, double bias)
    {
        size = inputSize;
        learningRate = rate;
        weights = new double[size];
        for(int i = 0 ; i < size; i++)
        {
            weights[i] = (double) (Math.random());
        }
        bias = weights[0];
    }
    
   public int fire(double[] point)
   {
       localSum=0;
       for(int i=0;i<point.length;i++)       
           localSum+=point[i]*weights[i];
      
       return((localSum>0)?1:0); 
       
           
   }
   
   public int train(double[] point, int expectedOut)
   {
       //First for x1
       int error = 0;
       int total = 0;
       error= expectedOut-fire(point);
       total+=error*error; //We square because we don't want positive and negatives errors to cancel each other off
       if(error!=0)
         for(int i=0;i<3;i++)
            weights[i]+=learningRate*error*point[i]; 
            
       return total;
   }

}
