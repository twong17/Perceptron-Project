
import java.util.Random;
import java.util.Scanner;
public class Driver
{
    static double rate=0.02;
    static int stopAfter=1000; 
    
    static Scanner s=new Scanner(System.in);
    
    public static void main(String[] arguments)
    {
        
        // double[] x1={1,-3,5};
        // double[] x2={1,3,-1};
        //double[] x3={1,-40,3};
        Random rand =new Random();
        Perceptron perceptron = new Perceptron(3, rate, rand.nextDouble()); 
        Point tempPoint;
        Point pointArr[] = new Point[60];
        for(int i = 0; i < 60; i++){
            tempPoint = new Point();
            System.out.println("The expected output is: " + tempPoint.getDesiredOut());
            System.out.println(tempPoint.toString());
            pointArr[i] = tempPoint;
            
        }
        //double[] weights={rand.nextDouble(),rand.nextDouble(),rand.nextDouble()};                
        
        //int[] record={1,0};
        

        
        double error=0,total=0; 
       int count=0;        
       do
       {
           total=0; //set the error to 0
           //First for x1
           // error= 1-fire(x1,weights);
           // total+=error*error; //We square because we don't want positive and negatives errors to cancel each other off
           // if(error!=0)
             // for(int i=0;i<3;i++)
                // weights[i]+=rate*error*x1[i];                
           // //Now x2  (Again, this is terrible coding but it clarifies the point)     
           // error= 0-fire(x2,weights); 
           // total+=error*error;
          
           // if(error!=0)
             // for(int i=0;i<3;i++)
                // weights[i]+=rate*error*x2[i];
           // total+=error*error;   
          for(int i = 0; i < 60; i++)
          {
              total += perceptron.train(pointArr[i].getPointArr(),pointArr[i].getDesiredOut());
          }
                
          count++;   
           
           
           
        }
         while(total!=0 && count<stopAfter) ; 
        
        System.out.println("training ended in "+ count + " loops");
        for(int i = 0; i < 60; i++)
          {
              System.out.println("Perceptron on x1 " +perceptron.fire(pointArr[i].getPointArr()));
          }
        //+  " Perceptron on x3 "+ fire(x3,weights) );
  
        
  }

   static double localSum=0;
   static int fire(double[] point, double[] weights)
   {
       localSum=0;
       for(int i=0;i<point.length;i++)       
           localSum+=point[i]*weights[i];
      
       return((localSum>0)?1:0);  
    }


}






