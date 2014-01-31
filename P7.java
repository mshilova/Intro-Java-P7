import java.io.*;

class P7
{
  private static final int ASIZE = 5; // Array size
  private static int [] qz = new int [ASIZE]; // 5 element array
  private static int max = 0;
  public static void main(String [] args) throws IOException
  {
   String inputStr;     // Input line
   String []s;         // Array of String from input
   boolean errFlag = true;

   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

   System.out.print("\nENTER " + ASIZE + " Quizzes (range 0-10): ");
   System.out.flush();

   while( (inputStr = in.readLine() ) != null)
   {
    s = inputStr.split(" "); // parse into tokens
    // check if input is less than 5
    if(s.length < qz.length)
    {
     System.out.println("Input: " + inputStr);
     System.out.print("ERROR: Entered less than 5 quizzes.");
    }else{

     try
     {
      for(int index = 0; index < s.length; index++)
      {
       qz[index] = Integer.parseInt( s[index] ); // convert to integer
       // check if value is in range
       if(qz[index] < 0 || qz[index] > 10)
       {
        if(errFlag)
        errFlag = false;
       }
      }
       if(errFlag){
        System.out.println("Input: " + inputStr);
        max();
       }
       if(!errFlag)
      {
       System.out.print("Input: " + inputStr);
       errFlag = true; // reset errFlag
       System.out.print("\nERROR! Out of range 0-10. Enter again.");
       System.out.flush();
      }
     } 

     catch(NumberFormatException ex1)
     {
      System.out.print("Input: " + inputStr);
      System.out.println(" are not valid quiz scores.");
      ex1.printStackTrace();
      System.out.print("\nENTER again - 5 Quizzes (range 0-10): ");
     }
     catch(ArrayIndexOutOfBoundsException ex2) 
     {
      System.out.print("Input: " + inputStr);
      System.err.print("\n\tEntered more than 5 quizzes");
      System.out.println("\n\tFirst 5 scores accepted. Continuing...");
      
      if(errFlag){
       max();
      }
     }
      catch(Exception ex3)
      {
       System.err.println(ex3);
       ex3.printStackTrace();
       System.exit(1);
      }
    }
      System.out.print("\n\nENTER " + ASIZE + " Quizzes (range 0-10): ");
      System.out.flush();
    }
  }

  public static void max()
  {
   max = 0;
   // traverse array to find max value
   for (int index = 0; index < ASIZE; index++)
     if(qz[index] > max)
      max = qz[index];
   System.out.print("Largest value of 5 the quizzes is " + max);

  }

}

