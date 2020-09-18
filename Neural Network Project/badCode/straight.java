
import java.util.Random;
import java.util.Scanner;
public class straight
{
    
    /**
     *  This is the straight up code which is violating
     *  OOP in all sorts of way, but it might explain the basic
     *  idea better because it is so limited.
     * 
     * This time, I will try to approach the explanation without
     * too much linear algebra at all. Also, we consider the case of
     * a simple line y=3x. I would you like to try this for the old example of -2x+6=y
     */
    
    static double rate=0.02;//We can play around with this or even make it
    //part of the main method and keep changing it after say 1000 iterations
    // if the training is not successful.
    //static double bias=1; We are going to treat this as w_0
    //static int trainingSize=3;  You will increase this of course. Here since
    // I am not even writing a loop I don't use this variable
    static int stopAfter=1000; //To stop the program if training is
    //taking too long
    static Scanner s=new Scanner(System.in);
    
    public static void main(String[] arguments)
    {
        /** In your assignment I would like you to actually create say 30 points that are acceptable
            and 30 points that are not. Based on the -2x+6=y. Above is accepted, below is rejected.
           
           **/
        double[] x1={1,-3,5};
        double[] x2={1,3,-1};
        //double[] x3={1,-40,3};
        Random rand =new Random();
        double[] weights={rand.nextDouble(),rand.nextDouble(),rand.nextDouble()};                
        /*** 
         * 5 > 3*-3   -1 !>3*3   3*(-40)>3
         *  We have two points. One is above the line y=3x so it should get a 1
         *  another is below the line y=3x so it should get a 0
         *  So we know that the correct answer for x1 is 
         *  1 and for x2 is -1. Or 1 and 0 for that matter.
         *  In the previous code (with traps) I used 1 and -1
         *  because it's more clever but then you have to be careful
         *  how you use it. Here I make is clear but not the most
         *  clever. So let's keep a record of the results for x1
         *  and x2 below.
         *  
         */
        int[] record={1,0};
        
        /*** Here is what we are going to do. We are going
         * to start with a weight vector of size 3. The first
         * entry is the bias. You will see that if we start
         * with a bias of 0 (this is cheating because we already
         * know the line separating the two is going through the 
         * origin) We give two random values to the remaining two
         * coordinates of the weight. In the "Good" OOP program
         * you write, you will assign random values to weights.
         * 
         * 
         * Now what? Well, we have three points. We keep calculating
         * the sum of weights*coordinates with the bias and the
         * first coordinate being 1 taken into account. This means 1 always gets
         * multiplied by the bias
         * 
         * We check to see if there is an error. If there is
         * we modify the weights. This includes the bias. I'll 
         * explain why I like to consider the bias separate from
         * the weights although functionally it makes no difference
         * 
         * If we go through the whole cycle of points (in this silly example it's
         * just two) and there is no error accumulated by the end of the loop
         * we are done. We could either do that by keeping a boolean flag. That is,
         * if you find one error then we set the flag to false, or we can keep track
         * of the total error by adding each error up (but we have to be sure that
         * whether the error is positive or negative it adds up anyways. So either
         * take absolute value or square the errors and add them).
         *  so here it is:
         */
        
        double error=0,total=0; //In the previous one I used a boolen flag that made things continue
        //untill all the answers matched the actual answers.
        
        /***
         * In the real program you have a second loop to go through all points.
         * Here there are two, so I write it thrice.
         * 
         * This is as bad a programming practice as possible. Basically we are doing a loop manually
         * doing it manually. But the point is to demonstrate the logic
         * clearly as opposed to write good code.
         */
        
       
       int count=0; /**
                     count, counts the number of full training loops. We have set
                     it to a maximum of 50. 
                    **/       
       do
       {
           total=0; //set the error to 0
           //First for x1
           error= 1-fire(x1,weights);
           total+=error*error; //We square because we don't want positive and negatives errors to cancel each other off
           if(error!=0)
             for(int i=0;i<3;i++)
                weights[i]+=rate*error*x1[i];                
           //Now x2  (Again, this is terrible coding but it clarifies the point)     
           error= 0-fire(x2,weights); 
           total+=error*error;
          
           if(error!=0)
             for(int i=0;i<3;i++)
                weights[i]+=rate*error*x2[i];
           total+=error*error;
           /**
           error= 0-fire(x3,weights); 
           total+=error*error;
          
           if(error!=0)
             for(int i=0;i<3;i++)
                weights[i]+=rate*error*x2[i];
                
          **/      
                
          count++;   
           
           
           
        }
         while(total!=0 && count<stopAfter) ; 
        
        System.out.println("training ended in "+ count + " loops");
        System.out.println("Perceptron on x1 " +fire(x1,weights)+" Perceptron on x2 "
        +fire(x2,weights));
        //+  " Perceptron on x3 "+ fire(x3,weights) );
  
        
  }

   static double localSum=0;
   static int fire(double[] point, double[] weights)
   {
       localSum=0;
       for(int i=0;i<point.length;i++)       
           localSum+=point[i]*weights[i];
      
       return((localSum>0)?1:0); 
       /** This is the same as the original but again
       **  done directly. Answer one if the sum (aka dot product) is
       **  more than 0, 0 otherwise.
       **/
           
    }


}






