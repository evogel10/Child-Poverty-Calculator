import java.io.*;

public class SmallAreaIncomePovertyReport
{
    // Main Method
    public static void main( String [] args ) throws IOException
    {
        // Open the file
        try ( Reader reader = new FileReader(args[0]); BufferedReader br = new BufferedReader(reader))
        {
            // Instatiate the third parameter passed in through terminal
            int numLine = Integer.parseInt(args[2]);
            String strLine;
            PrintWriter writer = new PrintWriter(args[1], "UTF-8");
            // For loop to print out each line of the program
            for (int i = 0 ; i < numLine ; i++ )
            {
                // Read text file line by line
                strLine = br.readLine();
                writer.println(strLine.substring(0, 2).trim()
                               + "," + strLine.substring(83, 90).trim()
                               + "," + strLine.substring(92, 99).trim()
                               + "," + strLine.substring(101, 108).trim());

            }
            writer.close();
            
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
        
        
    }
}