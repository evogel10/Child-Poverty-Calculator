import java.io.*;

public class SmallAreaIncomePovertyChildPovertyPercent
{
    public static void main( String[] args)
    {
        // Open the file
        try ( Reader reader = new FileReader(args[0]); BufferedReader br = new BufferedReader(reader))
        {
            // Instatiate the second parameter passed in through terminal
            int numLine = Integer.parseInt(args[1]);
            String strLine;
            String state = "";
            int pop = 0;
            int childPop = 0;
            int childPovPop = 0;
            double perChildPov = 0.0;
            
            // Prints out header
            System.out.println( "State   Population    Child Population    Child Poverity Population    % Child Poverty");
            System.out.println( "-----   ----------    ----------------    -------------------------    ---------------");
            
            // For loop to print out each line of the program
            for (int i = 0 ; i < numLine ; i++ )
            {
                // Read text file line by line
                strLine = br.readLine();
                
                // Creation of a 1D array from each line in the file
                String[] strArray = strLine.split(",");
                
                // if-else statement used to add up each column and print out each row
                if (state.equals(strArray[0]))
                {
                    pop = pop + Integer.parseInt(strArray[1]);
                    childPop = childPop + Integer.parseInt(strArray[2]);
                    childPovPop = childPovPop + Integer.parseInt(strArray[3]);
                }
                else
                {
                    if ( !state.equals(""))
                    {
                        // Prints out states 01-55
                        perChildPov = ((double)childPovPop/(double)childPop) * 100.0;
                        System.out.printf("%5s %12d %19d %28d %18.4g%n", state, pop, childPop, childPovPop, Math.round(perChildPov * 100.0)/100.0);
                    }
                    state = strArray[0];
                    pop = Integer.parseInt(strArray[1]);
                    childPop = Integer.parseInt(strArray[2]);
                    childPovPop = Integer.parseInt(strArray[3]);
                    
                }
            }
            // Prints out state 56
            perChildPov = ((double)childPovPop/(double)childPop) * 100.0;
            System.out.printf("%5s %12d %19d %28d %18.4g%n", state, pop, childPop, childPovPop, Math.round(perChildPov * 100.0)/100.0);

        }
    
        // Catch IOException if file not found
        catch ( FileNotFoundException e )
        {
            System.out.println( "I/O Error: " + e.getMessage() );
        }
        // Catch IOExceptions
        catch ( IOException e )
        {
            System.out.println( "I/O Error: " + e.getMessage() );
        }
        // Catch arithmetic exceptions
        catch (ArithmeticException e )
        {
            System.out.println( "I/O Error: " + e.getMessage() );
            
        }
    }
}